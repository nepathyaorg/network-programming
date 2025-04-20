package Nisha_Bhattarai.Programs.Unit2;

import java.net.InetAddress;

// 1. Write a JAVA program to illustrate different types of address.
public class Program2 {
    public static void main(String[] args) {
        try {
            // Resolve the IP address of the given domain
            InetAddress address = InetAddress.getByName("www.youtube.com");

            System.out.println("Resolved Address: " + address);

            if (address.isAnyLocalAddress()) {
                System.out.println("It is a wildcard address.");
            }
            if (address.isLoopbackAddress()) {
                System.out.println("It is a localhost (loopback) address.");
            }
            if (address.isLinkLocalAddress()) {
                System.out.println("It is a link-local address.");
            } else if (address.isSiteLocalAddress()) {
                System.out.println("It is a site-local address.");
            } else {
                System.out.println("It is a global address.");
            }

            // Check if it is a multicast address
            if (address.isMulticastAddress()) {
                System.out.println("It is a multicast address.");
                if (address.isMCGlobal()) {
                    System.out.println("It is a global multicast address.");
                } else if (address.isMCOrgLocal()) {
                    System.out.println("It is an organization multicast address.");
                } else if (address.isMCLinkLocal()) {
                    System.out.println("It is subnet wise muticast address");
                }
            }

        } catch (Exception e) {
            System.err.println("Error resolving the address: " + e.getMessage());
        }
    }
}
