package Nisha_Bhattarai.Programs.Unit3;

import java.net.URI;
import java.net.URL;

// - To illustrate important methods of URL class.
public class Program1 {
    public static void main(String[] args) {
        try {
            URL urlAddress = new URI("https://youtube.com/videos?av=5#sectionHeader").toURL();
            System.out.println("Port" + urlAddress.getPort());
            System.out.println("Default Port" + urlAddress.getDefaultPort());

            System.out.println("Host: " + urlAddress.getHost());
            System.out.println("File" + urlAddress.getFile());
            System.out.println("Protocol: " + urlAddress.getProtocol());
            System.out.println("Path " + urlAddress.getPath());
            System.out.println("Query " + urlAddress.getQuery());
            System.out.println("Reference " + urlAddress.getRef());

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
