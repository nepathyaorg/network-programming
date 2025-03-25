package Unit3_URl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLcreation{
    public static void main(String[] args) throws IOException {

        URL  url1 = new URL("https://www.bhuvanbhusal.com.np");
        URLConnection urlConnection= url1.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String line;
        while((line=in.readLine())!=null){
            System.out.println(line);
        }


        URL  url2 = new URL("https://www.bhuvanbhusal.com.np");
        Object content = url2.getContent();
        System.out.println("content Class: "+content.getClass().getName());
        }
    }

