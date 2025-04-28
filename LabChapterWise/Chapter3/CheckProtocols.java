import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

public class CheckProtocols {
    public static void main(String[] args) {
        List<String> protocols = Arrays.asList("http", "https", "ftp", "file", "mailto");

        for (String protocol : protocols) {
            try {
                URLConnection connection = new java.net.URL(protocol + "://test.com").openConnection();
                System.out.println(protocol + " is supported.");
            } catch (Exception e) {
                System.out.println(protocol + " is NOT supported.");
            }
        }
    }
}