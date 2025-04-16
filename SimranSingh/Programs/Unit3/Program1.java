import java.net.*;

public class Program1 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com:8080/path/page.html?query=value#section");

            
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("File: " + url.getFile());
            System.out.println("Reference (Fragment): " + url.getRef());

        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + e.getMessage());
        }
    }
}
