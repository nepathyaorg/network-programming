package Unit5;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ArbitaryHdr {
    public static void main(String[] args) {
        String url= "https://www.youtube.com/";
        try{
            URL url1 = new URL(url);
            URLConnection uc = url1.openConnection();
            for(int i=1;;i++){
                String line= uc.getHeaderField(i);
                if(line==null){
                    break;
                }
                System.out.println(line);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
