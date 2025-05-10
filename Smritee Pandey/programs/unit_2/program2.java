package programs.unit_2;
import java.net.InetAddress;
public class program2 {
    public static void main(String[] args) {
        try{
        InetAddress inetaddressins = InetAddress.getByName("facebook.com");
        String hostname=inetaddressins.getHostName();
        String hostaddress = inetaddressins.getHostAddress();
        String canonicalhostname = inetaddressins.getCanonicalHostName();
        System.out.println(hostname);
        System.out.println(hostaddress);
        System.out.println(canonicalhostname);  
        // localhost 
        InetAddress addressins = InetAddress.getLocalHost();
        String localhost = addressins.getHostName();
        String localhostaddress = addressins.getHostAddress();
        System.out.println(localhost);
        System.out.println(localhostaddress);
        byte[] hfjsk = inetaddressins.getAddress();
        System.out.println(hfjsk);
        if(hfjsk.length==4){
            System.out.println("ipv4");
        }
        else if(hfjsk.length==6){
            System.out.println("ipv6");
        }
        else{
            System.out.println("invalid input.");
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}