import java.net.InetAddress;
import java.net.UnknownHostException;
public class program1 {
    public static void main(String[] args){
    try{ 
        //Define the domain name
        //String domainName ="www.instagram.com";

        String domainName ="wikipedia.org";

        //getting the InetAddress object from above given domain name
        InetAddress address = InetAddress.getByName(domainName);

        String hostName=address.getHostName();
        String canonicalName =address.getCanonicalHostName(); 

        System.out.println("Host name is : " + hostName);
        System.out.println("Canonical HostName is: " +canonicalName);

        //get the IPaddress as a byte array
        byte[] ipBytes = address.getAddress();

        //checking the length of the byte to determine if the address is Ipv4 or Ip6

        if(ipBytes.length == 4){
            System.out.println("The adddress is IPv4.");
        }else if(ipBytes.length == 16){
            System.out.println("The address is IPv6.");
        }else{
            System.out.println("Unknown IP address ");
        }

    }catch(UnknownHostException exception){
        System.out.println("Unknown Host: " + exception.getMessage());
    }

    }
    
}
