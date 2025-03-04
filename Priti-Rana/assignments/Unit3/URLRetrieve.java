
import java.net.*;
import java.io.*;

public class URLRetrieve {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.wikipedia.org/");
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
