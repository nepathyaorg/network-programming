// To demo encoding and decoding of special characters using URLEncoder class.

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncodeDecode {
    public static void main(String[] args) {
        try {
            // Original query parameters
            String searchTerm = "apple&banana";
            String category = "fruit";
            String priceRange = "100?200";

            // Step 1: Encode the query string
            String encodedSearchTerm = URLEncoder.encode(searchTerm, "UTF-8");
            String encodedCategory = URLEncoder.encode(category, "UTF-8");
            String encodedPriceRange = URLEncoder.encode(priceRange, "UTF-8");

            // Build the full URL with encoded parameters
            String encodedURL = "https://youtube.com/search?q=" + encodedSearchTerm
                    + "&category=" + encodedCategory
                    + "&price=" + encodedPriceRange;

            System.out.println("Encoded URL: " + encodedURL);

            // Step 2: Decode the query string
            String decodedSearchTerm = URLDecoder.decode(encodedSearchTerm, "UTF-8");
            String decodedCategory = URLDecoder.decode(encodedCategory, "UTF-8");
            String decodedPriceRange = URLDecoder.decode(encodedPriceRange, "UTF-8");

            // Print the decoded parameters
            System.out.println("Decoded q: " + decodedSearchTerm);
            System.out.println("Decoded category: " + decodedCategory);
            System.out.println("Decoded price: " + decodedPriceRange);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
