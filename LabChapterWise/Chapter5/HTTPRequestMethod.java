import java.net.*;

public class HTTPRequestMethod {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://nepathyacollege.edu.np");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");  // You can try "POST", "HEAD" etc.

            System.out.println("HTTP Request Method: " + connection.getRequestMethod());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
