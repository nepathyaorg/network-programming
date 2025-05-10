
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlEncodeDecodeDemo {

    public static void main(String[] args) {
        try{
        //4. To demo encoding and decoding of special characters using URLEncoder class.
        //defining parameters with special characters
        String itemName ="phones&charger";
        String itemAddress ="USA";
        String date="2020-01-02?";
        

        //encoding the parameters
        String encodedItemName = URLEncoder.encode(itemName, "UTF-8");
        String encodedItemAddress = URLEncoder.encode(itemAddress, "UTF-8");
        String encodedDate = URLEncoder.encode(date, "UTF-8");


        //constructing with the full URL with encoded parameters
        String fullEncodedUrl = "https://shop.com/product?item=" + encodedItemName +"&address=" + encodedItemAddress + "&date=" +encodedDate;


        System.out.println("Encoded URl: " +fullEncodedUrl);

        //Decode the parameters
        String decodedItemName = URLDecoder.decode(encodedItemName, "UTF-8");
        String decodedItemAddress = URLDecoder.decode(encodedItemAddress, "UTF-8");
        String decodedDate = URLDecoder.decode(encodedDate, "UTF-8");

       //displaying the decoded parameters
       System.out.println("Decoded Item Name is : "+decodedItemName);
       System.out.println("Decoded Item Address is : " +decodedItemAddress);
       System.out.println("Decoded Date is: "+decodedDate);

    

        }catch(UnsupportedEncodingException ex){
           ex.printStackTrace();

        }
    }
    
}
