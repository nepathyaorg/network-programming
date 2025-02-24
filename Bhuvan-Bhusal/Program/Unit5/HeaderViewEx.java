package Unit5;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HeaderViewEx {
    public static void main(String[] args) {
        String url= "https://www.youtube.com/";
        try{
            URL url1 = new URL(url);
            URLConnection uc = url1.openConnection();
            System.out.println("Content Type "+uc.getContentType());

            if(uc.getContentEncoding() != null){
                System.out.println("Content-Encoding"+uc.getContentEncoding());
            }else{
                System.out.println("Content-Encoding not set");
            }
            if (uc.getDate() != 0){
                System.out.println("Date "+uc.getDate());
            }
            if (uc.getLastModified() != 0){
                System.out.println("Last-Modified"+uc.getLastModified());
            }
            if (uc.getExpiration() != 0){
                System.out.println("Expiration"+uc.getExpiration());
            }
            if(uc.getContentLength() != -1){
                System.out.println("Content-Length"+uc.getContentLength());
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
