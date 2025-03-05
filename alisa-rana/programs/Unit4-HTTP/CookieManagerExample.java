package Unit4;

import java.io.*;
import java.net.*;
import java.util.*;

public class CookieManagerExample {
    public static void main(String[] args) throws Exception {
        String loginUrl = "https://httpbin.org/cookies/set/sessionID/123456";
        String profileUrl = "https://httpbin.org/cookies"; // Page that requires session

        System.out.println("Using Default CookieManager:");
        useDefaultCookieManager(loginUrl, profileUrl);

        System.out.println("\nUsing Custom CookieManager (Blocks Non-Session Cookies):");
        useCustomCookieManager(loginUrl, profileUrl);
    }

    // Using Java's Default CookieManager
    private static void useDefaultCookieManager(String loginUrl, String profileUrl) throws Exception {
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);

        // Simulate login (set cookie)
        openUrlConnection(loginUrl);

        // Access profile (send stored cookie)
        openUrlConnection(profileUrl);

        // Print stored cookies
        printCookies(cookieManager);
    }

    // Using a Custom CookieManager that only stores session cookies
    private static void useCustomCookieManager(String loginUrl, String profileUrl) throws Exception {
        CookieManager customManager = new CustomCookieManager();
        CookieHandler.setDefault(customManager);

        // Simulate login
        openUrlConnection(loginUrl);

        // Access profile
        openUrlConnection(profileUrl);

        // Print stored cookies
        printCookies(customManager);
    }

    // Open URL connection and print response
    private static void openUrlConnection(String urlString) throws IOException {
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection(); // Using openConnection() directly
        connection.connect();

        // Print response headers
        System.out.println("Response Headers from: " + urlString);
        Map<String, List<String>> headers = connection.getHeaderFields();
        for (String key : headers.keySet()) {
            System.out.println(key + ": " + headers.get(key));
        }

        // Read response body
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
    }

    // Print stored cookies
    private static void printCookies(CookieManager manager) {
        System.out.println("Stored Cookies:");
        for (HttpCookie cookie : manager.getCookieStore().getCookies()) {
            System.out.println(cookie);
        }
    }
}

// Custom CookieManager: Only allows session cookies
class CustomCookieManager extends CookieManager {
    @Override
    public void put(URI uri, Map<String, List<String>> responseHeaders) throws IOException {
        List<String> cookiesList = responseHeaders.get("Set-Cookie");
        if (cookiesList != null) {
            for (String cookieString : cookiesList) {
                HttpCookie cookie = HttpCookie.parse(cookieString).get(0);
                if (cookie.getName().equalsIgnoreCase("sessionID")) { // Only store session cookies
                    super.getCookieStore().add(uri, cookie);
                }
            }
        }
    }
}



