import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class DownloadWebPage {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Webpage download garna error: " + e);
        }
    }
}