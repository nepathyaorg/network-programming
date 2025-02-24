package Programs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class cookies {

    public static void main(String[] args) throws Exception {
        String loginUrl = "http://example.com/login";
        String profileUrl = "http://example.com/profile";

        useCookieManager(loginUrl, profileUrl);
    }

    private static void useCookieManager(String loginUrl, String profileUrl) throws Exception {
        CookieManager customManager = new CustomCookieManager();
        CookieHandler.setDefault(customManager);

        openUrlConnection(loginUrl);
        openUrlConnection(profileUrl);
        printCookies(customManager);
    }

    // Custom Cookie Manager
    static class CustomCookieManager extends CookieManager {
        @Override
        public void put(URI uri, Map<String, List<String>> responseHeaders) throws IOException {
            List<String> cookieList = responseHeaders.get("Set-Cookie");

            if (cookieList != null) {
                for (String cookieString : cookieList) {
                    List<HttpCookie> cookies = HttpCookie.parse(cookieString);
                    for (HttpCookie cookie : cookies) {
                        super.getCookieStore().add(uri, cookie);
                    }
                }
            }
        }
    }

    // Method to Open URL Connection
    private static void openUrlConnection(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Read response (optional)
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
        }

        connection.disconnect();
    }

    // Method to Print Cookies
    private static void printCookies(CookieManager manager) {
        System.out.println("\nStored Cookies:");
        for (HttpCookie cookie : manager.getCookieStore().getCookies()) {
            System.out.println(cookie);
        }
    }
}
