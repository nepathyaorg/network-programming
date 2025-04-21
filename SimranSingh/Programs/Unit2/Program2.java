//Write a JAVA program that
//Displays both hostname and the cannonical hostname of a domain.
//Utilizes getAddress() to determine if the given address is IPv4 or IPv6.

import java.net.*;

public class Program2 {
    public static void main(String[] args) {
        try {
            
            String domain = "google.com";

            InetAddress address = InetAddress.getByName(domain);
          
            System.out.println("Host Name: " + address.getHostName());
            System.out.println("Canonical Host Name: " + address.getCanonicalHostName());

            byte[] ipBytes = address.getAddress();
            if (ipBytes.length == 4) {
                System.out.println("IP Type: IPv4");
            } else if (ipBytes.length == 16) {
                System.out.println("IP Type: IPv6");
            } else {
                System.out.println("Unknown IP Type");
            }

        } catch (UnknownHostException e) {
            System.out.println("Error: Unable to resolve the hostname.");
        }
    }
}
