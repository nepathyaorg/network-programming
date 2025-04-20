package Nisha_Bhattarai.Programs.Unit3;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
// - To check equality of URLs. Describe use case for `equals()` and `sameFile()` methods.

public class Program3 {
    public static void main(String[] args) {

        try {
            URL url1 = new URI("https://example.com/index.html").toURL();
            URL url2 = new URI("https://example.com/index.html?abc=5").toURL();
            System.out.println(url1.equals(url2));
            System.out.println(url1.sameFile(url2));

        } catch (Exception e) {
            System.out.println("Invalid URL: " + e.getMessage());
        }

    }
}