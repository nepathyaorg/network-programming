import java.net.MalformedURLException;

import java.net.URL;

public class Program1{
public static void main(String[] args){
    try{
            //Example of URL
            URL url = new URL("https://www.facebook.com:3000/docs/resource.html?query=java#section");

            //Display various URL components
            System.out.println("Full URL:" +url);
            System.out.println("Protocol:" +url.getProtocol()); //https
            System.out.println("Host:" + url.getPort()); //3000
            System.out.println("Default Port:" + url.getDefaultPort()); //443(for https
            System.out.println("File:" + url.getFile()); //docs/resources.htmlquery.java
            System.out.println("Path" +url.getPath()); //docs/resources.html
            System.out.println("Query:" +url.getQuery()); //query=java
            System.out.println("Ref (Fragment):" + url.getRef()); //section
        }catch(MalformedURLException e){
            System.err.println("Invalid URL" + e.getMessage());
        }
}
}