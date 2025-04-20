# Write a JAVA program to illustrate different types of address.

```java
import java.net.*;

public class DifferentAddressTypes {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Host Address: " + localHost.getHostAddress());
            InetAddress loopback = InetAddress.getLoopbackAddress();
            System.out.println("Loopback Address: " + loopback.getHostAddress());

            InetAddress anyLocal = InetAddress.getByName("0.0.0.0");
            System.out.println("Any Local Address: " + anyLocal.getHostAddress());
            InetAddress linkLocal = InetAddress.getByName("169.254.1.1");
            System.out.println("Link-local Address: " + linkLocal.getHostAddress());
            System.out.println("Is Link Local? " + linkLocal.isLinkLocalAddress());

            InetAddress siteLocal = InetAddress.getByName("10.0.0.25");
            System.out.println("Site-local Address: " + siteLocal.getHostAddress());
            System.out.println("Is Site Local? " + siteLocal.isSiteLocalAddress());

            InetAddress mcNodeLocal = InetAddress.getByName("224.0.0.1");
            System.out.println("Multicast Node-Local: " + mcNodeLocal.getHostAddress());
            InetAddress mcLinkLocal = InetAddress.getByName("224.0.0.252");
            System.out.println("Multicast Link-Local: " + mcLinkLocal.getHostAddress());

            InetAddress mcSiteLocal = InetAddress.getByName("239.255.0.1");
            System.out.println("Multicast Site-Local: " + mcSiteLocal.getHostAddress());
            InetAddress mcOrgLocal = InetAddress.getByName("239.192.1.1");
            System.out.println("Multicast Org-Local: " + mcOrgLocal.getHostAddress());

            InetAddress mcGlobal = InetAddress.getByName("233.1.1.1");
            System.out.println("Multicast Global: " + mcGlobal.getHostAddress());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

```

# In what ways `getHostName()` differs from `getCannonicalHostName()`?

`getHostName():` This method returns the hostname of the computer. It could be a short name or alias. Sometimes, it might just return the IP address if it can’t figure out the actual hostname.

`getCanonicalHostName():` This method always gives the full, official name of the domain. It makes sure to return the complete address, which is usually the full domain name, not a shortened version.

**Write a JAVA program that,Displays both hostname and the cannonical hostname of a domain. and utilizes `getAddress()` to determine if the given address is IPv4 or IPv6.**

```java
import java.net.*;

public class DomainAddressInfo {
    public static void main(String[] args) {
        try {
            InetAddress domainAddress = InetAddress.getByName("www.microsoft.com");

            String hostName = domainAddress.getHostName();
            String canonicalHostName = domainAddress.getCanonicalHostName();

            System.out.println("Host Name: " + hostName);
            System.out.println("Canonical Host Name: " + canonicalHostName);

            byte[] ipAddress = domainAddress.getAddress();
            String ip = InetAddress.getByAddress(ipAddress).getHostAddress();
            System.out.println("IP Address: " + ip);

            if (ipAddress.length == 4) {
                System.out.println("This is an IPv4 address.");
            } else if (ipAddress.length == 16) {
                System.out.println("This is an IPv6 address.");
            }

        } catch (UnknownHostException e) {
            System.out.println("Host not found: " + e.getMessage());
        }
    }
}
```
