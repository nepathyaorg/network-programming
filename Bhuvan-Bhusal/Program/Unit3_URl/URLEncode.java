package Unit3_URl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String serachTerm= "alex&bhusal AKA Bhuvan";
        String category = "name";
        String priceRange= "100?200";

        String encodedSearchTerm= URLEncoder.encode(serachTerm,"UTF-8");
        String encodedCategory= URLEncoder.encode(category,"UTF-8");
        String encodedPriceRange= URLEncoder.encode(priceRange,"UTF-8");

        String encodedURL= "https://bhuvanbhusal.com.np/search?q="+encodedSearchTerm+"&category="+encodedCategory+"&price="+encodedPriceRange;
        System.out.println(encodedURL);

        String decodeSearchTerm= URLDecoder.decode(encodedSearchTerm,"UTF-8");
        String decodeCategory = URLDecoder.decode(encodedCategory,"UTF-8");
        String decodePriceRange = URLDecoder.decode(encodedPriceRange,"UTF-8");

        System.out.println("Decoded Search Term: "+decodeSearchTerm);
        System.out.println("Decoded Category: "+decodeCategory);
        System.out.println("Decoded Price Range: "+decodePriceRange);
    }
}
