import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {

        // Instance of InetAddress given hostname
        InetAddress instanceByName = InetAddress.getByName(args[0]);

        String hostname = instanceByName.getHostName();
        String hostAddress = instanceByName.getHostAddress();
        String cannonicalHostName = instanceByName.getCanonicalHostName();

        System.out.println(hostname);
        System.out.println(hostAddress);
        System.out.println(cannonicalHostName);

        // Instance of localhost InetAddress
        InetAddress localInstance = InetAddress.getLocalHost();
        System.out.println(localInstance.getHostAddress());
        System.out.println(localInstance.getHostName());

        // Checking byte length to determine v4 or v6 address
        byte[] hostAdressBytes = instanceByName.getAddress();
        if (hostAdressBytes.length == 4) {
            System.out.println("This is IPv4 address");
        } else if(hostAdressBytes.length == 6){
            System.out.println("The address is IPv6");
        }
        else{
            System.out.println("Not a valid IP address");
        }

        } catch (UnknownHostException e) {
            System.out.println("Could not find the host");
        }
    }
}
