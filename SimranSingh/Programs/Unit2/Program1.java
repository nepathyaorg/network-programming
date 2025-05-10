//Write a JAVA program to illustrate different types of address.

import java.net.*;

public class Program1 {
    public static void main(String[] args) {
        try {
           
            InetAddress loopback = InetAddress.getLoopbackAddress();
            System.out.println("Loopback Address: " + loopback.getHostAddress());

            InetAddress localHost = InetAddress.getByName("127.0.0.1");
            System.out.println("Localhost Address: " + localHost.getHostAddress());

   
            InetAddress myAddress = InetAddress.getLocalHost();
            System.out.println("My Machine IP Address: " + myAddress.getHostAddress());

            InetAddress broadcast = InetAddress.getByName("255.255.255.255");
            System.out.println("Broadcast Address: " + broadcast.getHostAddress());

            InetAddress multicast = InetAddress.getByName("224.0.0.1");
            System.out.println("Multicast Address: " + multicast.getHostAddress());

        } catch (UnknownHostException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
