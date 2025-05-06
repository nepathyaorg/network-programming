1. Write a JAVA program to illustrate different types of address.
	Java program that illustrates different types of addresses, including MAC addresses, IP addresses (IPv4 and IPv6), and loopback addresses. The program utilizes Java's InetAddress class from the java.net package to retrieve and display network addresses.
	Program:
	import java.net.*;
	import java.util.*;

public class AddressTypes {
    public static void main(String[] args) {
        try {
            // Get local host IP Address
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Host Address: " + localHost.getHostAddress());
            
            // Get Loopback Address
            InetAddress loopback = InetAddress.getLoopbackAddress();
            System.out.println("Loopback Address: " + loopback.getHostAddress());
            
            // Get All Network Interfaces and their IP Addresses
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                System.out.println("\nNetwork Interface: " + networkInterface.getDisplayName());
                
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    System.out.println("  Address: " + addr.getHostAddress());
                }
                
                // Get MAC Address
                byte[] mac = networkInterface.getHardwareAddress();
                if (mac != null) {
                    System.out.print("  MAC Address: ");
                    StringBuilder macAddress = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        macAddress.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : ""));
                    }
                    System.out.println(macAddress.toString());
                }
            }
            
        } catch (UnknownHostException e) {
            System.err.println("Unknown Host Exception: " + e.getMessage());
        } catch (SocketException e) {
            System.err.println("Socket Exception: " + e.getMessage());
        }
    }
}

2. In what ways `getHostName()` differs from `getCannonicalHostName()`? Write a JAVA program that,
    - Displays both hostname and the cannonical hostname of a domain.
    - Utilizes `getAddress()` to determine if the given address is IPv4 or IPv6.

	Difference between getHostName() and getCanonicalHostName():
	i.getHostName():
	-Returns the hostname of the IP address.
	-May return the IP address itself if the hostname is not resolvable.
	ii.getCanonicalHostName():
	-Attempts to return the Fully Qualified Domain Name (FQDN).
	-Provides a more detailed, resolved hostname compared to getHostName().
	-Performs a DNS lookup, which can be slower.
Program:
import java.net.*;
import java.util.Scanner;

public class HostnameResolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a domain name or IP address: ");
        String input = scanner.nextLine();
        scanner.close();

        try {
            InetAddress inetAddress = InetAddress.getByName(input);
            
            // Display Hostname and Canonical Hostname
            System.out.println("Host Name: " + inetAddress.getHostName());
            System.out.println("Canonical Host Name: " + inetAddress.getCanonicalHostName());

            // Determine if the Address is IPv4 or IPv6
            byte[] addressBytes = inetAddress.getAddress();
            if (addressBytes.length == 4) {
                System.out.println("Address Type: IPv4");
            } else if (addressBytes.length == 16) {
                System.out.println("Address Type: IPv6");
            } else {
                System.out.println("Unknown IP format.");
            }

        } catch (UnknownHostException e) {
            System.err.println("Could not resolve host: " + e.getMessage());
        }
    }
}
	