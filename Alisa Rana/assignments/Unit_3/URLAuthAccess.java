// To access password protected site using default authentication.

import java.io.*;
import java.net.*;
import java.util.Base64;
import java.util.Scanner;

public class URLAuthAccess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for credentials
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
        // Encode credentials in Base64
        String auth = username + ":" + password;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
        
        try {
            // URL of the password-protected site
            URL url = new URL("https://www.facebook.com/protected");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set authorization header
            connection.setRequestProperty("Authorization", "Basic " + encodedAuth);
            connection.setRequestMethod("GET");
            
            // Read response
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } else {
                System.out.println("Access Denied: " + responseCode);
            }
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}