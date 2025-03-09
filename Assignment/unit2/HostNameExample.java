package unit2;

import java.net.*;

public class HostNameExample {
    public static void main(String[] args) {
        try {

            String domain = "www.instagram.com";

            InetAddress inetAddress = InetAddress.getByName(domain);

            String hostName = inetAddress.getHostName();
            String canonicalHostName = inetAddress.getCanonicalHostName();
            System.out.println("HostName: " + hostName);
            System.out.println("Canonical HostName: " + canonicalHostName);

            byte[] address = inetAddress.getAddress();
            if (address.length == 4) {
                System.out.println("The address is IPv4.");
            } else if (address.length == 16) {
                System.out.println("The address is IPv6.");
            } else {
                System.out.println("Unknown address type.");
            }

        } catch (UnknownHostException e) {
            System.out.println("Unable to resolve domain name.");
        }
    }
}
