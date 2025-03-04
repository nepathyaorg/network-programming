
import java.io.*;
import java.net.*;

public class AuthDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://username:password@www.example.com/protected");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

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
