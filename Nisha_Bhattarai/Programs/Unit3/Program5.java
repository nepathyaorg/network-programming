package Nisha_Bhattarai.Programs.Unit3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// - To access password protected site using default authentication.
public class Program5 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com");

            String userpass = "user:pass";
            String basicAuth = "Basic " + java.util.Base64.getEncoder().encodeToString(userpass.getBytes());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", basicAuth);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
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
