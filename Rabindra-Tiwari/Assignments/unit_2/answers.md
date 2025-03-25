# **UNIT 2**

## 1. Different Types of Addresses

In networking, different types of addresses are used to identify devices and services on a network. The following types are commonly used:

- **IP Address**: A unique identifier assigned to each device on a network. It can be IPv4 (32-bit) or IPv6 (128-bit).
- **Hostname**: A human-readable label assigned to a device that is connected to a network. It can be mapped to an IP address.
- **Canonical Hostname**: The fully qualified domain name (FQDN) of a host, which specifies its exact location in the DNS hierarchy.

### Java Program to Illustrate Different Types of Addresses

```java
import java.net.*;

public class AddressExample {
    public static void main(String[] args) {
        try {
            InetAddress localAddress = InetAddress.getLocalHost();
            InetAddress googleAddress = InetAddress.getByName("www.google.com");

            System.out.println("Local Host Address: " + localAddress.getHostAddress());
            System.out.println("Local Host Name: " + localAddress.getHostName());

            System.out.println("Google Address: " + googleAddress.getHostAddress());
            System.out.println("Google Host Name: " + googleAddress.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 2. Difference Between `getHostName()` and `getCanonicalHostName()`

The methods `getHostName()` and `getCanonicalHostName()` are used to retrieve the hostname of a device, but they differ in their approach:

- **`getHostName()`**: This method returns the hostname as it was provided in the system or DNS configuration. It may not be fully qualified and might return just the short name of the host.
- **`getCanonicalHostName()`**: This method returns the fully qualified domain name (FQDN) of the host. It ensures that the host name is fully qualified, even if the host name is just a short name.

### Java Program to Display Both Hostname and Canonical Hostname

```java
import java.net.*;

public class HostNameExample {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");

            System.out.println("Hostname: " + address.getHostName());
            System.out.println("Canonical Hostname: " + address.getCanonicalHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 3. Determining IPv4 or IPv6 Address Using `getAddress()`

The `getAddress()` method in Java returns the raw IP address as a byte array. By checking the length of the byte array, we can determine whether the address is IPv4 or IPv6:

- **IPv4**: A 4-byte address.
- **IPv6**: A 16-byte address.

### Java Program to Determine If the Address is IPv4 or IPv6

```java
import java.net.*;

public class IPAddressType {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            byte[] ipAddress = address.getAddress();

            if (ipAddress.length == 4) {
                System.out.println("The address is IPv4");
            } else if (ipAddress.length == 16) {
                System.out.println("The address is IPv6");
            } else {
                System.out.println("Unknown address type");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
```
