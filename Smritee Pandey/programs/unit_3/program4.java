package programs.unit_3;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class program4 {
    public static void main(String[] args) {
        try {
            String name ="This string$has$ampersands";
            String encoder=URLEncoder.encode(name,"UTF-8");
            System.out.println("Encoded text : "+encoder);
            String Decoder=URLDecoder.decode(name, "UTF-8");
            System.out.println("Decoded text :"+Decoder);


            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        
       





    }
}
