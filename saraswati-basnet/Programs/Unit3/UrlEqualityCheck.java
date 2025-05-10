import java.net.MalformedURLException;
import java.net.URL;

public class UrlEqualityCheck{
    public static void main(String[] args) {

        try {
            //3. To check equality of URLs. Describe the use cases for equals() and sameFile() methods.
            URL firstUrl = new URL("https://www.testsite.org/about.html#intro");
            URL secondUrl = new URL("https://www.testsite.org/about.html#team");

            //equals()-> compare the entire URL including the fragment
            System.out.println("Using equals: " + "firstUrl.equals(secondUrl) " + firstUrl.equals(secondUrl) );

            //sameFile()->ignores the fragment
            System.out.println("Using sameFile: " + "firstUrl.sameFile(secondUrl) "+ firstUrl.sameFile(secondUrl) );
           
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + e.getMessage());
        }
        

    }
}