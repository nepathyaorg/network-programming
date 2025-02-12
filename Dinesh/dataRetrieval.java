import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class dataRetrieval {
    public static void main(String[] args){
        try {
            URL myURL = new URL("https://www.facebook.com/");

            URLConnection connection = myURL.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            System.out.println("--- Page Content ---");
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
