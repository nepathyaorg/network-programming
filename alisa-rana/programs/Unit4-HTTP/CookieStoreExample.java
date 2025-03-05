package Unit4;

import java.net.*;
import java.util.*;

public class CookieStoreExample {
    public static void main(String[] args) {
        CookieManager manager = new CookieManager();
        CookieStore store = manager.getCookieStore();

        // Create and add a cookie manually
        HttpCookie cookie = new HttpCookie("sessionID", "12345");
        cookie.setDomain(".example.com");
        cookie.setPath("/");
        store.add(null, cookie);

        // Retrieve cookies
        List<HttpCookie> cookies = store.getCookies();
        System.out.println("Stored Cookies: " + cookies);
    }
}
