import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class URLLastModifiedTime {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://nepathyacollege.edu.np");
            URLConnection connection = url.openConnection();

            long lastModified = connection.getLastModified();
            if (lastModified == 0) {
                System.out.println("No Last-Modified information.");
            } else {
                Date date = new Date(lastModified);
                SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
                System.out.println("Last Modified: " + sdf.format(date));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
