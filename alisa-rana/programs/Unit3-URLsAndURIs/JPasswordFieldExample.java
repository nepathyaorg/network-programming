package Unit3;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.*;

public class JPasswordFieldExample {
    public static void main(String[] args) {
        // Prompt the user for username and password
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        Object[] message = {
                "Username:", usernameField,
                "Password:", passwordField
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();

            // Set up the Authenticator with user-provided credentials
            Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {
                // URL for authentication (fixed, no user/pass in URL)
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
        } else {
            System.out.println("Login canceled.");
        }
    }
}
