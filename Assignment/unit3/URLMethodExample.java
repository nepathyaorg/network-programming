package unit3;

import java.net.*;

public class URLMethodExample {
    public static void main(String[] args) throws Exception {

        URL url = new URL("https://www.example.org:9090/products/details?id=1234&category=electronics#reviews");

        System.out.println("URL: " + url);
        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("Host: " + url.getHost());
        System.out.println("Port: " + url.getPort());
        System.out.println("Path: " + url.getPath());
        System.out.println("Query: " + url.getQuery());
        System.out.println("Ref (Fragment): " + url.getRef());
        System.out.println("File: " + url.getFile());
        System.out.println("Authority: " + url.getAuthority());
        System.out.println("Host Name: " + url.getHost());
    }
}
