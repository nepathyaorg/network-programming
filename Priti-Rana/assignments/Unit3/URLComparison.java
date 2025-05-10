
import java.net.*;

public class URLComparison {
    public static void main(String[] args) {
        try {
            URL url1 = new URL("https://www.example.com/page?query=123#section");
            URL url2 = new URL("https://www.example.com/page?query=123#section");
            URL url3 = new URL("https://www.example.com/page");

            System.out.println("url1 equals url2: " + url1.equals(url2)); // true
            System.out.println("url1 sameFile url3: " + url1.sameFile(url3)); // true (ignores query & fragment)

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
