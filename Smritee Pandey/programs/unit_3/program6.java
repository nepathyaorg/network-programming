package programs.unit_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Scanner;

public class program6 {
    public static void main(String[] args) {
        
    
Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the username: ");
        String username = scanner.nextLine();

        System.out.print("Enter the password: ");
        String password = scanner.nextLine();

        scanner.close();

        try {
            URL url = new URL("https://your-protected-site.com");

            String userpass = username + ":" + password;
            String basicAuth = "Basic " + Base64.getEncoder().encodeToString(userpass.getBytes());

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
     
}}

