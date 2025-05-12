# Networking in Java

Networking in Java allows communication between devices over a network. The `InetAddress` class is used to handle IP addresses, hostnames, and different types of network addresses.

---

## 1. Write a JAVA program to illustrate different types of address.

### Program Code

```java
import java.net.*;

public class AddressTypes {
    public static void main(String[] args) {
        try {
            // Loopback Address (address representing the local machine)
            InetAddress loopback = InetAddress.getLoopbackAddress();
            System.out.println("Loopback Address: " + loopback);

            // Localhost Address (the local computer's address)
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Localhost Address: " + localHost);

            // Fetching Google's IP address
            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println("Google Address: " + google);
        } catch (UnknownHostException e) {
            System.out.println("Could not resolve address: " + e.getMessage());
        }
    }
}
```

## 2. Difference Between `getHostName()` and `getCanonicalHostName`

- **`getHostName()`**: Returns the domain name of the host. However, it may not always be accurate in all cases, and it may return the IP address itself if DNS resolution fails.

- **`getCanonicalHostName()`**: Returns the fully qualified domain name (FQDN) of the host. This method ensures accurate DNS resolution and may return the IP address if the canonical name cannot be resolved.

### JAVA Program to Display Hostname, Canonical Hostname & Address Type

```java
import java.net.*;

public class HostNameExample {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");

            // Display the Hostname and Canonical Hostname
            System.out.println("Hostname: " + address.getHostName());
            System.out.println("Canonical Hostname: " + address.getCanonicalHostName());

            // Check the address type: whether it's IPv4 or IPv6
            byte[] ip = address.getAddress();
            if (ip.length == 4) {
                System.out.println("IPv4 Address");
            } else if (ip.length == 16) {
                System.out.println("IPv6 Address");
            }
        } catch (UnknownHostException e) {
            System.out.println("Could not resolve host: " + e.getMessage());
        }
    }
}
```
