package Nisha_Bhattarai.Programs.Unit3;

import java.net.URLDecoder;
import java.net.URLEncoder;
// - To demo encoding and decoding of special characters using `URLEncoder` class.

public class Program4 {
    public static void main(String[] args) {
        try {
            String name = "Hello world@";
            String encoder = URLEncoder.encode(name, "UTF-8");
            System.out.println("Encoding Text" + encoder);
            String Decoder = URLDecoder.decode(name, "UTF-8");
            System.out.println("Decoding text" + Decoder);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

}
