import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PasswordProtectedSiteAccess {

    public static void main(String[] args) {
        //6. To access password protected site asking user to prompt for username and password.


        //Prompt for user input
        JTextField userNameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        //combine input fields into dialog box
        Object[] loginComponent={
            "Username:", userNameField,
            "Password:", passwordField
        };
        
        //show dialog box and store user's choice
        int userChoice = JOptionPane.showConfirmDialog(null, loginComponent, "Enter secure site credentials",JOptionPane.OK_CANCEL_OPTION);

        //only proceed if the user click OK
        if(userChoice == JOptionPane.OK_OPTION){
            //get user input 
            String enteredUsername = userNameField.getText();
            char[] enteredPassword = passwordField.getPassword();

            //setting-up authentication
            Authenticator.setDefault(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(enteredUsername, enteredPassword);
                }
            });
            try{
                URL url = new URL("https://httpbin.org/basic-auth/demoUser/demoPass123");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                int responseCode = connection.getResponseCode();
                if(responseCode == HttpURLConnection.HTTP_OK){
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while((line = reader.readLine())!=null){
                    System.out.println(line);
                    }
                    reader.close();
                }else{
                    System.out.println("Authentication failed with response code: "+ responseCode);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("Login canceled.");
        }
    }
 }
    

