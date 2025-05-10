// To access password protected site asking user to promt for username and password.

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AuthenticatorExample {
    public static void main(String[] args) {
        // Set the default Authenticator
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // Provide the required username and password
                return new PasswordAuthentication("user", "passwd".toCharArray());
            }
        });

        try {
            // URL requiring basic authentication
            URL url = new URL("https://httpbin.org/basic-auth/user/passwd");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Check the response code
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read and display the response
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } else {
                System.out.println("Authentication failed with response code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
