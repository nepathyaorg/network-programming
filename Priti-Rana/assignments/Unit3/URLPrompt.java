
import java.net.*;
import java.io.*;
import java.util.*;

public class URLPrompt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        scanner.close();

        try {
            String authString = username + ":" + password;
            String encodedAuth = new String(java.util.Base64.getEncoder().encode(authString.getBytes()));

            URL url = new URL("https://www.example.com/protected");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Authorization", "Basic " + encodedAuth);

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
