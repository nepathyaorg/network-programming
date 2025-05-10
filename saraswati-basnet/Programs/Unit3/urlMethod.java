import java.net.*;

public class urlMethod{
    public static void main(String[] args) {
        try {
            //1) Illustrating important methods of URL class
            //example of URL

            URL url = new URL("https://www.example.edu:80/courses/CS101/intro.html?semester=fall&year=2025#schedule");


            //displaying URL components
            System.out.println("Full URl:" +url);
            System.out.println("Protocol: " +url.getProtocol());
            System.out.println("Host: "+url.getHost());
            System.out.println("Port:" +url.getPort());
            System.out.println("Default Port: "+url.getDefaultPort());
            System.out.println("File: " +url.getFile());
            System.out.println("Path: "+url.getPath());
            System.out.println("Query: "+url.getQuery());
            System.out.println("Fragment(Ref): "+url.getRef());


            
        }catch(MalformedURLException e) {
            System.out.println("Invalid URL: " + e.getMessage());
        }
        
         
    }
    
}
