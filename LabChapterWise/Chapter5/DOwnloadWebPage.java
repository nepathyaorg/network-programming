
import java.io.*;
import java.net.*;

public class DOwnloadWebPage {
    public static void main(String[] args) {
        String website = "http://nepathyacollege.edu.np";

        try {
            URL url = new URL(website);
            URLConnection connection = url.openConnection();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("DownloadedPage.html"));

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("Web page downloaded successfully as 'DownloadedPage.html'");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
