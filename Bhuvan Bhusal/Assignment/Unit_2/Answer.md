Question1: Write a JAVA program to illustrate different types of address.

Answer:
``` java
import java.io.IOException;
import java.net.InetAddress;

public class IPadd {
public static void main(String[] args) {
try{
InetAddress address = InetAddress.getByName("127.0.0.1");
// To check ip is localAddress or Not
if(address.isAnyLocalAddress()){
System.out.println(address+" is any local address");
}

            // To check ip is LoopBackAddress or Not
            if(address.isLoopbackAddress()){
                System.out.println(address+" is loopback address");
            }

            // To check ip is LinkLocalAddress or Not
            if(address.isLinkLocalAddress()){
                System.out.println(address+" is link local address");
            }

            // To check the ip is reachable  or not
            if(address.isReachable(5)){
                System.out.println(address+" is reachable");
            }else{
                System.out.println(address+" is not reachable");
            }

            // To check ip is SiteLocalAddress or Not
            if(address.isSiteLocalAddress()){
                System.out.println(address+" is site local address");
            }else {
                System.out.println(address+" is a global site address");
            }

            // To check ip is Unicast or Multicast
            if(address.isMulticastAddress()){
                if(address.isMCGlobal()){
                    System.out.println(address+" is multicast address");
                } else if (address.isMCOrgLocal()) {
                    System.out.println(address+" is multicast address");
                } else if (address.isMCSiteLocal()) {
                    System.out.println(address+" is multicast address");
                } else if (address.isMCLinkLocal()) {
                    System.out.println(address+" is multicast address");
                } else if (address.isMCNodeLocal()) {
                    System.out.println(address+" is multicast address");
                }else{
                    System.out.println(address+" is unknown multicast local address");
                }
            }else {
                System.out.println(address+" is a unicast address");
            }

            // TO handle the Exception
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
```

-------------------------------------------------------------------------------------

Question 2: In what ways getHostName() differs from getCannonicalHostName()? Write a JAVA program that,
#Displays both hostname and the cannonical hostname of a domain.
#Utilizes getAddress() to determine if the given address is IPv4 or IPv6.

Answer:

Output Form:

getHostName() gives the short or simple name.
getCanonicalHostName() gives the fully qualified domain name (FQDN), if available.

DNS Lookup:

getHostName() may return just a simple or local name without performing a DNS lookup.
getCanonicalHostName() performs a DNS lookup to get the full domain name, which can involve a reverse DNS lookup.

###########<-----Java program----->##################
```java
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDEMO {
public static void main(String[] args) throws UnknownHostException {

// To get IP, CNAME of the given Host
String Hname = "bhuvanbhusal.com.np";

        InetAddress iName= InetAddress.getByName(Hname);

        String hostname = iName.getHostName();

        String ip = iName.getHostAddress();

        String Cname = iName.getCanonicalHostName();

        System.out.println("The Host Name is: "+hostname);

        System.out.println("The Ip Address is: "+ip);

        System.out.println("The CNAME is: "+Cname+"\n");


        // TO check the given IP is IPV4 or Ipv6
        byte[] hostAddress =lAddress.getAddress();
        if(hostAddress.length == 6) {
            System.out.println("IP address is IPv6 address");
        }
        else if(hostAddress.length == 4) {
            System.out.println("IP address is IPv4 address");
        }
        else{
            System.out.println("Invalid Ip Address");
        }
    }

}
```
