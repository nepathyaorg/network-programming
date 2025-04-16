package programs.unit_2;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class program1{
    public static void main(String[] args) {
        try{
            InetAddress iaddress = InetAddress.getByName("224.1.1.1");
            if(iaddress.isAnyLocalAddress()){
                System.out.println(iaddress+"is a local address.");
            }
            if(iaddress.isLoopbackAddress()){
                System.out.println(iaddress+"is loopback address.");
            }
            if(iaddress.isLinkLocalAddress()){
                System.out.println(iaddress+"is a link-local address.");
            }else if(iaddress.isSiteLocalAddress()){
                System.out.println(iaddress+"is a site-local address.");
            }else{
                System.out.println(iaddress+"is a global address.");
            }
            // multicast network
            if(iaddress.isMulticastAddress()){
                if(iaddress.isMCGlobal()){
                    System.out.println(iaddress+"is a global multicast address.");
                }else if(iaddress.isMCOrgLocal()){
                    System.out.println(iaddress+"is a organizational wide multicast address.");
                }else if(iaddress.isMCSiteLocal()){
                    System.out.println(iaddress+"is a site wide multicast address.");
                }else if(iaddress.isMCLinkLocal()){
                    System.out.println(iaddress+"is a subnet wide multicast address.");
                }else if(iaddress.isMCNodeLocal()){
                    System.out.println(iaddress+"is an interface-local multicast address.");
                }else{
                    System.out.println(iaddress+"is a unicast address.");
                }
            }

        }catch(UnknownHostException e){
            System.out.println("could not resolve."+args[0]);
        }
        
    }
}
