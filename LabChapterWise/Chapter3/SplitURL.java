import java.net.URL;

public class SplitURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com:8080/path/to/resource?query=nepal#section");

            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Reference: " + url.getRef());

        } catch (Exception e) {
            System.out.println("URL ko parts split garna error: " + e);
        }
    }
}