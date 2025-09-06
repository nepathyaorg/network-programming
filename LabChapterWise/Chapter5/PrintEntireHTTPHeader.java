import java.net.*;
import java.util.*;

public class PrintEntireHTTPHeader {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://nepathyacollege.edu.np");
            URLConnection connection = url.openConnection();

            Map<String, List<String>> headers = connection.getHeaderFields();

            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                List<String> values = entry.getValue();
                System.out.println(key + ": " + String.join(", ", values));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
