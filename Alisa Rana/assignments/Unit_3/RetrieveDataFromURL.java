// To access password protected site using default authentication.

import java.io.*;
import java.net.*;

public class RetrieveDataFromURL {
    public static void main(String[] args) {
        try {
            // URL to fetch data from
            URL url = new URL("https://www.facebook.com");

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
            reader.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}