## 1. Java Program to Illustrate Different Types of Address

```java
import java.net.InetAddress;
import java.net.UnknownHostException;

public class AdressTypesDemo {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please pass in the IP address to identify the type.");
            System.exit(0);
        }

        try {
            InetAddress address = InetAddress.getByName(args[0]);

            if (address.isAnyLocalAddress()) {
                System.out.println(address + " is a wildcard address.");
            }
            if (address.isLoopbackAddress()) {
                System.out.println(address + " is loopback address.");
            }
            if (address.isLinkLocalAddress()) {
                System.out.println(address + " is a link-local address.");
            } else if (address.isSiteLocalAddress()) {
                System.out.println(address + " is a site-local address.");
            } else {
                System.out.println(address + " is a global address.");
            }
            if (address.isMulticastAddress()) {
                if (address.isMCGlobal()) {
                    System.out.println(address + " is a global multicast address.");
                } else if (address.isMCOrgLocal()) {
                    System.out.println(address + " is an organization wide multicast address.");
                } else if (address.isMCSiteLocal()) {
                    System.out.println(address + " is a site wide multicast address.");
                } else if (address.isMCLinkLocal()) {
                    System.out.println(address + " is a subnet wide multicast address.");
                } else if (address.isMCNodeLocal()) {
                    System.out.println(address + " is an interface-local multicast address.");
                } else {
                    System.out.println(address + " is an unknown multicast address type.");
                }
            } else {
                System.out.println(address + " is a unicast address.");
            }
        } catch (UnknownHostException e) {
            System.err.println("Could not resolve " + args[0]);
        }
    }
}
```

---

## 2. Difference Between `getHostName()` and `getCanonicalHostName()`

| Method                 | Description |
|------------------------|-------------|
| `getHostName()`        | Returns the host name associated with the IP address, usually via reverse DNS lookup. If unresolved, it may return the IP address itself. |
| `getCanonicalHostName()` | Returns the fully qualified domain name (FQDN). Tries to resolve canonical name using DNS. May return the IP address if not resolvable. |

---

## ✅ Java Program

This program:
- Displays both the hostname and canonical hostname of a given domain.
- Uses `getAddress()` to check if the IP is IPv4 or IPv6.

```java
import java.net.*;

public class HostNameDemo {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a domain name or IP address as a command-line argument.");
            return;
        }

        try {
            InetAddress address = InetAddress.getByName(args[0]);

            System.out.println("Host Name: " + address.getHostName());
            System.out.println("Canonical Host Name: " + address.getCanonicalHostName());

            byte[] ipBytes = address.getAddress();

            if (ipBytes.length == 4) {
                System.out.println("The given address is IPv4.");
            } else if (ipBytes.length == 16) {
                System.out.println("The given address is IPv6.");
            } else {
                System.out.println("Unknown IP address format.");
            }

        } catch (UnknownHostException e) {
            System.out.println("Error: Could not resolve host - " + args[0]);
        }
    }
}
