# **UNIT 2**

## 1️⃣ Understanding Different Types of Addresses

Networking uses different types of addresses to uniquely identify devices and services within a network. The key address types are:

### 🔹 **IP Address**

An **Internet Protocol (IP) address** is a unique identifier assigned to a device in a network. There are two versions:

- **IPv4**: 32-bit numeric address (e.g., `192.168.0.1`)
- **IPv6**: 128-bit alphanumeric address (e.g., `2001:db8::ff00:42:8329`)

### 🔹 **Hostname**

A **hostname** is a human-friendly label assigned to a network device. It is mapped to an IP address through DNS.

### 🔹 **Canonical Hostname (FQDN)**

A **Fully Qualified Domain Name (FQDN)** is the complete domain name of a host, indicating its precise location in the DNS hierarchy.

### 📝 **Java Program to Retrieve Different Addresses**

````java
import java.net.*;

public class AddressExample {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            InetAddress remoteHost = InetAddress.getByName("www.google.com");

            System.out.println("Local Host Address: " + localHost.getHostAddress());
            System.out.println("Local Host Name: " + localHost.getHostName());

            System.out.println("Remote Host Address: " + remoteHost.getHostAddress());
            System.out.println("Remote Host Name: " + remoteHost.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

---

## 2️⃣ Difference Between `getHostName()` and `getCanonicalHostName()`
These two methods retrieve hostnames, but they function differently:

### ✅ **`getHostName()`**

*   Returns the simple hostname as recorded in the system or DNS.
*   Might return just the short hostname, not the full domain name.

### ✅ **`getCanonicalHostName()`**

*   Retrieves the **fully qualified domain name (FQDN)**.
*   Ensures the hostname is completely resolved.

### 📝 **Java Program to Compare Hostname Methods**

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

---

## 3️⃣ Checking IPv4 or IPv6 Using `getAddress()`

The `getAddress()` method returns an IP address as a **byte array**. By checking the array length, we can determine the address type:

- **IPv4** → 4 bytes
- **IPv6** → 16 bytes

### 📝 **Java Program to Identify IPv4 or IPv6**

```java
import java.net.*;

public class IPAddressType {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            byte[] ipBytes = address.getAddress();

            if (ipBytes.length == 4) {
                System.out.println("This is an IPv4 address.");
            } else if (ipBytes.length == 16) {
                System.out.println("This is an IPv6 address.");
            } else {
                System.out.println("Unknown address type.");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
````
