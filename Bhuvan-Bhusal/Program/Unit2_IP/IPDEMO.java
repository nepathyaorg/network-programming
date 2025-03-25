package Unit2_IP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDEMO {
    public static void main(String[] args) throws UnknownHostException {

//        To get IP, CNAME of the given Host
        String Hname = "bhuvanbhusal.com.np";
        InetAddress iName= InetAddress.getByName(Hname);
        String hostname = iName.getHostName();
        String ip = iName.getHostAddress();
        String Cname = iName.getCanonicalHostName();
        System.out.println("The Host Name is: "+hostname);
        System.out.println("The Ip Address is: "+ip);
        System.out.println("The CNAME is: "+Cname+"\n");

        // TO get the machine LocalHost IP
        InetAddress lAddress = InetAddress.getLocalHost();
        System.out.println("The LocalHost Address is: "+lAddress);

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
