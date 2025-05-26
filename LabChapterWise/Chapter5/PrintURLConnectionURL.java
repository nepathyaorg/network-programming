import java.net.*;

public class PrintURLConnectionURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://nepathyacollege.edu.np");
            URLConnection connection = url.openConnection();

            System.out.println("URL of the connection: " + connection.getURL());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
