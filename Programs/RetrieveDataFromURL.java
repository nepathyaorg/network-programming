package Programs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class RetrieveDataFromURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.facebook.com"); // Use a website that allows scraping
            URLConnection urlConnection = url.openConnection();
            
            // Set User-Agent to bypass bot detection
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;
            System.out.println("=== Page Content ===");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
