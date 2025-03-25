package Unit2_IP;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class netIterface {
    public static void main(String[] args) throws SocketException, UnknownHostException {

        Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
        while (netInterfaces.hasMoreElements()) {
            NetworkInterface netInterface = netInterfaces.nextElement();
            System.out.println(netInterface);
        }
        System.out.println("\n");

        String Host = "127.0.0.1";
        InetAddress local= InetAddress.getByName(Host);
        NetworkInterface netInterface = NetworkInterface.getByInetAddress(local);
        if(netInterface==null){
            System.out.println("No network interface found");
        }else{
            System.out.println("Network interface found with name "+netInterface.getName());
        }

    }
}
