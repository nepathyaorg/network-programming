package unit3;

import java.net.*;
import java.io.UnsupportedEncodingException;

public class URLEncoderExample {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String originalString = "Java is awesome! Let's test encoding: <>{}[]|\\";

        String encodedString = URLEncoder.encode(originalString, "UTF-8");
        System.out.println("Encoded String: " + encodedString);

        String decodedString = URLDecoder.decode(encodedString, "UTF-8");
        System.out.println("Decoded String: " + decodedString);
    }
}
