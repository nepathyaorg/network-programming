package unit3;

import java.net.*;
import java.io.*;

public class RetrieveData {
    public static void main(String[] args) {
        try {
            // URL from which data is retrieved
            URL url = new URL("https://jsonplaceholder.typicode.com/comments/1");

            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
