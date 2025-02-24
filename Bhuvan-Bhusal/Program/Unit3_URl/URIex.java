package Unit3_URl;
import java.net.URI;

public class URIex {
    public static void main(String[] args) {
        URI actualURI = URI.create("https://bhuvanbhusal.com.np/path/name?query=alex#bhusal");
        URI OpaqueURI= URI.create("mailto:alexbhusal@icloud.com");
        URI relativeURIex = URI.create("/path/name");
    }


}
