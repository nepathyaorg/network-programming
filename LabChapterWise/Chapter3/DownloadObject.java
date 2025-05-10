import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class DownloadObject {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com");
            InputStream input = url.openStream();
            FileOutputStream output = new FileOutputStream("downloaded_sample.pdf");

            byte[] buffer = new byte[2048];
            int bytesRead;

            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

            input.close();
            output.close();
            System.out.println("File download successfully.");
        } catch (Exception e) {
            System.out.println("File download garna error: " + e);
        }
    }
}