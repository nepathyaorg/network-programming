import java.net.*;

public class ReadHTTPHeaderFields {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://nepathyacollege.edu.np");
            URLConnection connection = url.openConnection();

            String contentType = connection.getHeaderField("Content-Type");
            String server = connection.getHeaderField("Server");

            System.out.println("Content-Type: " + contentType);
            System.out.println("Server: " + server);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
