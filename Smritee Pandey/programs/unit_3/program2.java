package programs.unit_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class program2 {
    public static void main(String[] args) {
        try {
            URL url = new URI("https://www.wikipedia.org/").toURL();
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}

