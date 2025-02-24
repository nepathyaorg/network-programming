package Programs;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class HeaderViewer {
    public static void main(String[] args) {
        String url = "https://www.example.com";

        try {
            URL u = new URL(url);
            URLConnection uc = u.openConnection();

            System.out.println("Content-Type: " + uc.getContentType());

            if (uc.getContentEncoding() != null) {
                System.out.println("Content Encoding: " + uc.getContentEncoding());
            }

            if (uc.getDate() != 0) {
                System.out.println("Date: " + new Date(uc.getDate()));
            }

            if (uc.getLastModified() != 0) {
                System.out.println("Last Modified: " + new Date(uc.getLastModified()));
            }

            if (uc.getExpiration() != 0) {
                System.out.println("Expiration Date: " + new Date(uc.getExpiration()));
            }

            if (uc.getContentLength() != -1) {
                System.out.println("Content Length: " + uc.getContentLength());
            }

        } catch (java.net.MalformedURLException ex) {
            System.out.println(url + " is not a URL I understand.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}