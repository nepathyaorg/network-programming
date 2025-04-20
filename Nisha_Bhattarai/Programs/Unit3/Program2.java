package Nisha_Bhattarai.Programs.Unit3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
//- To retrieve data from a URL. Use different URL than used in the program that I demoed in the class.

public class Program2 {
    public static void main(String[] args) {
        try {
            URL url = new URI("https://www.wikipedia.org/").toURL();
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (Exception e) {
            System.out.println("Error retrieving data: " + e.getMessage());
        }
    }
}
