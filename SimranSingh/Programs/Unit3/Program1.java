// Write a JAVA program for each of the following:
// To illustrate important methods of URL class.
// To retrieve data from a URL. Use different URL than used in the program that I demoed in the class.
// To check equality of URLs. Describe use case for equals() and sameFile() methods.
// To demo encoding and decoding of special characters using URLEncoder class.
// To access password protected site using default authentication.
// To access password protected site asking user to promt for username and password.

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
