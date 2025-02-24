package Programs;
//check the version of the ip Address (IPV2 and IPV6)

import java.net.*;

public class IPversion {
    public static void main(String[] args) {
        try {
            // Specify the IP address (Replace with any valid IP address)
            String ipAddress = "192.168.1.1"; // Example IPv4
            // String ipAddress = "2001:db8::ff00:42:8329"; // Example IPv6
            
            // Get the InetAddress object for the given IP address
            InetAddress address = InetAddress.getByName(ipAddress);
            
            // Check if the IP address is IPv4 or IPv6
            if (address instanceof Inet4Address) {
                System.out.println("The IP address " + ipAddress + " is IPv4.");
            } else if (address instanceof Inet6Address) {
                System.out.println("The IP address " + ipAddress + " is IPv6.");
            } else {
                System.out.println("The IP address " + ipAddress + " is of unknown type.");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
