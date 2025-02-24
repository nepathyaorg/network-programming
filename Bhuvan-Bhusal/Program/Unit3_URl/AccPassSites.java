package Unit3_URl;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;

public class AccPassSites {
    public static void main(String[] args) throws IOException {
        JTextArea userName = new JTextArea();
        JPasswordField passwordField = new JPasswordField();
        Object[] messages = {
                "Username: ",userName,
                "Password: ",passwordField
        };

        int option = JOptionPane.showConfirmDialog(null, messages, "Login", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String username = userName.getText();
            char[] password = passwordField.getPassword();
            Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
        }
        try{
            URL url = new URL("https://httpbin.org/basic-auth/user/passwd");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }
                in.close();
            }else {
                System.out.println(responseCode);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
