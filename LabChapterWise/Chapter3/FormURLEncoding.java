import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class FormURLEncoding {
    public static void main(String[] args) {
        try {
            String name = "Ram Bahadur";
            String location = "Nepal Kathmandu";

            String encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8);
            String encodedLocation = URLEncoder.encode(location, StandardCharsets.UTF_8);

            System.out.println("Encoded form data:");
            System.out.println("name=" + encodedName + "&location=" + encodedLocation);
        } catch (Exception e) {
            System.out.println("Form URL encoding garna error: " + e);
        }
    }
}