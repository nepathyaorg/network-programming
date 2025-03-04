
import java.net.*;
import java.io.*;

public class URLEncoderDecoder {
    public static void main(String[] args) {
        try {
            String original = "Hello World! @ # $ &";
            String encoded = URLEncoder.encode(original, "UTF-8");
            String decoded = URLDecoder.decode(encoded, "UTF-8");

            System.out.println("Original: " + original);
            System.out.println("Encoded: " + encoded);
            System.out.println("Decoded: " + decoded);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    
}
