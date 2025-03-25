package Unit4;

import java.io.IOException;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class CookieManagerEx {
    public static void main(String[] args) {
        class CustomCookieManager extends CookieManager {
            @Override
            public void put(URI uri, Map<String, List<String>> responseHeader) throws IOException {
                List<String> cookies = responseHeader.get("Set-Cookie");
                if (cookies != null) {
                    for (String cookieString : cookies) {
                        HttpCookie httpCookie = HttpCookie.parse(cookieString).get(0);
                        // Only add sessionId cookies to the store
                        if (httpCookie.getName().equalsIgnoreCase("sessionId")) {
                            super.getCookieStore().add(uri, httpCookie);
                        }
                    }
                }
            }
        }

        // Example of testing the CustomCookieManager
        CustomCookieManager cookieManager = new CustomCookieManager();

        try {
            URI testUri = new URI("https://example.com");
            Map<String, List<String>> mockResponseHeader = Map.of(
                    "Set-Cookie", List.of("sessionId=abc123; Path=/; HttpOnly")
            );

            // Simulate putting a cookie into the manager
            cookieManager.put(testUri, mockResponseHeader);

            // Print cookies for the URI to verify
            System.out.println("Cookies for " + testUri + ":");
            for (HttpCookie cookie : cookieManager.getCookieStore().get(testUri)) {
                System.out.println(cookie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
