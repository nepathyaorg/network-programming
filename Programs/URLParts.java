package Programs;
import java.net.MalformedURLException;
import java.net.URL;

public class URLParts {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.ncsa.illinois.edu/AboutUs/");
            System.out.println("Full URL: " + url);
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Path: " + url.getPath());

        } catch (MalformedURLException e) {
            System.err.println("Invalid URL: " + e.getMessage());
        }
    }
}
