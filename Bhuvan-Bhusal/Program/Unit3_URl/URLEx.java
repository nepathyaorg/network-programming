package Unit3_URl;

import java.net.MalformedURLException;

public class URLEx {
    public static void main(String[] args) throws MalformedURLException {
        java.net.URL url = new java.net.URL("https://alexbhusal.com:8080/mac/book.html?query=alexbhusal#12");
        System.out.println("URL: " + url);
        System.out.println("protocol: " + url.getProtocol());
        System.out.println("host: " + url.getHost());
        System.out.println("port: " + url.getPort());
        System.out.println("file: " + url.getFile());
        System.out.println("path: " + url.getPath());
        System.out.println("query: " + url.getQuery());
        System.out.println("referer: " + url.getRef());
        System.out.println("Default port: " + url.getDefaultPort());
    }
}
