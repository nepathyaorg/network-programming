package Programs;

//Find the IP address of the local machine

import java.net.*;

public class LocalIPAddress {
    public static void main(String[] args) {
        try {
            // Get the InetAddress object for the local machine
            InetAddress localAddress = InetAddress.getLocalHost();
            
            // Retrieve and print the local IP address and hostname
            System.out.println("Local Host Name: " + localAddress.getHostName());
            System.out.println("Local IP Address: " + localAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
