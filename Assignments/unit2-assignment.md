Networking in Java allows communication between devices over a network. The `InetAddress` class is used to handle IP addresses, hostnames, and different types of network addresses.

### 1. Write a JAVA program to illustrate different types of address.
---
```java
import java.net.*;

public class AddressTypes {
    public static void main(String[] args) {
        try {
            // Loopback Address (khudlai nai represent garne address)
            InetAddress loopback = InetAddress.getLoopbackAddress();
            System.out.println("Loopback Address: " + loopback);

            // Localhost Address (yaha ko computer ko address)
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Localhost Address: " + localHost);

            // Google ko IP address fetch garne
            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println("Google Address: " + google);
        } catch (UnknownHostException e) {
            System.out.println("Address khojna sakiyena: " + e.getMessage());
        }
    }
}
```

---

### 2. Difference Between getHostName() and getCanonicalHostName().

- `getHostName()`: Domain name dincha tara sabai case ma accurate hudaina.
- `getCanonicalHostName()`: Fully qualified domain name dincha, jasle DNS resolution garcha.

JAVA Program to Display Hostname, Canonical Hostname & Address Type

```java
import java.net.*;

public class HostNameExample {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            
            // Hostname ra Canonical hostname display garne
            System.out.println("Hostname: " + address.getHostName());
            System.out.println("Canonical Hostname: " + address.getCanonicalHostName());

            // Address type check garne IPv4 ho ki IPv6
            byte[] ip = address.getAddress();
            if (ip.length == 4) {
                System.out.println("IPv4 Address");
            } else if (ip.length == 16) {
                System.out.println("IPv6 Address");
            }
        } catch (UnknownHostException e) {
            System.out.println("Host khojna sakiyena: " + e.getMessage());
        }
    }
}
```
