// To check equality of URLs. Describe use case for equals() and sameFile() methods.

import java.net.MalformedURLException;
import java.net.URL;

public class URLEquality {
    public static void main(String[] args) {
        try {
            // Two URLs that are technically the same except for fragment
            URL url1 = new URL("https://youtube.com/index.html#section1");
            URL url2 = new URL("https://youtube.com/index.html#section2");

            // Compare using equals()
            System.out.println("url1.equals(url2): " + url1.equals(url2)); // false (fragment matters)

            // Compare using sameFile() (ignores fragment)
            System.out.println("url1.sameFile(url2): " + url1.sameFile(url2)); // true

        } catch (MalformedURLException e) {
            System.err.println("Invalid URL: " + e.getMessage());
        }
    }
}
