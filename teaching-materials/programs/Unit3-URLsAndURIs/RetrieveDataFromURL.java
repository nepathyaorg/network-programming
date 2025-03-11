package Unit3;

import java.io.*;
import java.net.*;

public class RetrieveDataFromURL {
    public static void main(String[] args) {
        try {
            // URL to fetch data from
            URL url = new URL("https://www.example.com");

            // Open a connection
            URLConnection urlConnection = url.openConnection();

            // Create a reader to read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            // Read and print the webpage content line by line
            String line;
            System.out.println("=== Page Content ===");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Step 2: Retrieve raw content using getContent()
            // URL imageUrl = new URL("https://www.example.com");
            // Object content = imageUrl.getContent();
            // System.out.println("\n=== getContent() Output ===");
            // System.out.println("Content Class: " + content.getClass().getName());

            
            reader.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
