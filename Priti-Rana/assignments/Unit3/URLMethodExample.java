import java.net.*;

public class URLMethodExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com:8080/path/to/resource?name=RohanTiwari");

            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("File: " + url.getFile());
            System.out.println("Authority: " + url.getAuthority());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    
}
