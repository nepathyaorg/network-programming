package Unit2_IP;

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
