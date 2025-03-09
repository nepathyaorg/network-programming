package unit3;

import java.net.*;

public class URLEqualityCheck {
    public static void main(String[] args) throws MalformedURLException {

        URL url1 = new URL("https://www.example.com/index.html?user=123#section2");
        URL url2 = new URL("https://www.example.com/index.html?user=123#section2");
        URL url3 = new URL("https://www.example.com/index.html?user=456#section3");
        URL url4 = new URL("https://www.example.com/index.html");

        if (url1.equals(url2)) {
            System.out.println("url1 and url2 are equal using equals().");
        } else {
            System.out.println("url1 and url2 are not equal using equals().");
        }

        if (url1.sameFile(url3)) {
            System.out.println("url1 and url3 refer to the same file using sameFile().");
        } else {
            System.out.println("url1 and url3 do not refer to the same file using sameFile().");
        }

        if (url1.sameFile(url4)) {
            System.out.println("url1 and url4 refer to the same file using sameFile().");
        } else {
            System.out.println("url1 and url4 do not refer to the same file using sameFile().");
        }
    }
}
