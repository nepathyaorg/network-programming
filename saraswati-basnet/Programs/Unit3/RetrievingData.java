import java.io.*;
import java.net.*;
public class RetrievingData {

    public static void main(String[] args) {
        
        try {
            //2. To retrieve data from a URL
            URL url = new URL("https://www.wikipedia.org");
            
            //open a connection
            URLConnection connection = url.openConnection();

            //Create a reader 
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));


            //read and print the webpage content line by line
            String dataLine;

            //display
            System.out.println("Content of the WebPage: \n");
            while((dataLine = reader.readLine())!=null){
                System.out.println(dataLine);
            }

            
          reader.close();  
        } catch (IOException e) {
        }

    }
    
}
