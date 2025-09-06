import java.net.*;
import java.util.*;

public class CookieStoreExample {
    public static void main(String[] args) throws Exception {
        CookieManager manager = new CookieManager();
        CookieHandler.setDefault(manager);
        CookieStore store = manager.getCookieStore();

        URI nepUri = new URI("http://nepathya.edu.np");

        // Add a cookie
        HttpCookie cookie = new HttpCookie("user", "Dinesh-SixthSemester");
        store.add(nepUri, cookie);
        
        System.out.println(" Cookie added for nepathya.edu.np: " + cookie);
        System.out.println("\n Cookies after addition (" + store.getCookies().size() + "):");
        for (HttpCookie c : store.getCookies()) {
            System.out.println(" " + c);
        }

        // Delete cookie
        store.remove(nepUri, cookie);
        System.out.println("\n Cookie deleted.");

        // Verify deletion
        List<HttpCookie> cookies = store.getCookies();
        System.out.println("\n Cookies after deletion (" + cookies.size() + "):");
        for (HttpCookie c : cookies) {
            System.out.println("➡️ " + c);
        }
    }
}
