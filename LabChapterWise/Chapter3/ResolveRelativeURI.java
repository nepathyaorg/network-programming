import java.net.URI;

public class ResolveRelativeURI {
    public static void main(String[] args) {
        try {
            URI base = new URI("https://www.example.com/folder/");
            URI relative = new URI("file.html");
            URI resolved = base.resolve(relative);

            System.out.println("Resolved URI: " + resolved.toString());
        } catch (Exception e) {
            System.out.println("Relative URI resolve garna error: " + e);
        }
    }
}