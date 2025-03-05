import java.io.*;
import java.net.*;
import java.util.*;

// Simple CacheResponse implementation
class SimpleCacheResponse extends CacheResponse {
    private final ByteArrayInputStream bodyStream;
    private final Map<String, List<String>> headers;

    public SimpleCacheResponse(byte[] body, Map<String, List<String>> headers) {
        this.bodyStream = new ByteArrayInputStream(body);
        this.headers = headers;
    }

    @Override
    public InputStream getBody() {
        return bodyStream;
    }

    @Override
    public Map<String, List<String>> getHeaders() {
        return headers;
    }
}

// Simple CacheRequest implementation
class SimpleCacheRequest extends CacheRequest {
    private final ByteArrayOutputStream bodyStream = new ByteArrayOutputStream();
    private final SimpleResponseCache cache;
    private final String key;

    public SimpleCacheRequest(SimpleResponseCache cache, String key) {
        this.cache = cache;
        this.key = key;
    }

    @Override
    public OutputStream getBody() {
        return bodyStream;
    }

    @Override
    public void abort() {
        bodyStream.reset();
    }

    public void store() {
        byte[] data = bodyStream.toByteArray();
        cache.storeCache(key, data);
    }
}

// Simple ResponseCache implementation
class SimpleResponseCache extends ResponseCache {
    private final Map<String, byte[]> cacheStore = new HashMap<>();
    private static final Map<String, List<String>> SAMPLE_HEADERS = Collections.singletonMap("Content-Type",
            Collections.singletonList("text/plain"));

    @Override
    public CacheResponse get(URI uri, String rqstMethod, Map<String, List<String>> rqstHeaders) {
        String key = uri.toString();
        byte[] cachedData = cacheStore.get(key);

        if (cachedData == null) {
            System.out.println("CACHE MISS: No cached data found for " + key);
            return null;
        }

        System.out.println("CACHE HIT: Found cached data for " + key);
        return new SimpleCacheResponse(cachedData, SAMPLE_HEADERS);
    }

    @Override
    public CacheRequest put(URI uri, URLConnection conn) {
        String key = uri.toString();
        System.out.println("Attempting to cache response for " + key);

        if (!cacheStore.containsKey(key)) {
            return new SimpleCacheRequest(this, key);
        }

        System.out.println("Already cached, skipping storage");
        return null;
    }

    public void storeCache(String key, byte[] data) {
        cacheStore.put(key, data);
        System.out.println("Stored response in cache for " + key);
    }
}

// Utility class to read InputStream in Java 8
class StreamUtil {
    public static byte[] readAllBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, bytesRead);
        }
        return buffer.toByteArray();
    }
}

// Demonstration class
public class WebCacheExample {
    public static void main(String[] args) throws Exception {
        // Register our simple cache
        ResponseCache.setDefault(new SimpleResponseCache());

        URI uri = new URI("http://example.com");
        URL url = new URL(uri.toString());

        // === First Request (Should be Cache Miss) ===
        System.out.println("\n=== FIRST REQUEST (Should be cache miss) ===");
        HttpURLConnection connection1 = (HttpURLConnection) url.openConnection();
        
        SimpleResponseCache cache = (SimpleResponseCache) ResponseCache.getDefault();

        CacheResponse cachedResponseBefore = cache.get(uri, "GET", new HashMap<>());
        if (cachedResponseBefore == null) {
            System.out.println("Please cache the data first!");
        }

        SimpleCacheRequest request = (SimpleCacheRequest) cache.put(uri, connection1);

        if (request != null) {
            byte[] responseData = "Hello, World! (Fetched from server)".getBytes();
            request.getBody().write(responseData);
            request.store();
        }

        // === Second Request (Triggers a Cache Hit) ===
        System.out.println("\n=== SECOND REQUEST (Should be cache hit) ===");
        CacheResponse cachedResponseAfter = cache.get(uri, "GET", new HashMap<>());

        if (cachedResponseAfter != null) {
            System.out.println(new String(StreamUtil.readAllBytes(cachedResponseAfter.getBody()), "UTF-8"));
        }
    }
}
