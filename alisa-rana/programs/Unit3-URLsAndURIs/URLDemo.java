package Unit3;

import java.net.*;

public class URLDemo {
    public static void main(String[] args) {
        try {
            // Example URL
            URL url = new URL("https://www.example.com:8080/docs/resource.html?query=java#section1");

            // Display various URL components
            System.out.println("Full URL: " + url);
            System.out.println("Protocol: " + url.getProtocol()); // https
            System.out.println("Host: " + url.getHost()); // www.example.com
            System.out.println("Port: " + url.getPort()); // 8080
            System.out.println("Default Port: " + url.getDefaultPort()); // 443 (for https)
            System.out.println("File: " + url.getFile()); // /docs/resource.html?query=java
            System.out.println("Path: " + url.getPath()); // /docs/resource.html
            System.out.println("Query: " + url.getQuery()); // query=java
            System.out.println("Ref (Fragment): " + url.getRef()); // section1
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL: " + e.getMessage());
        }
    }
}
