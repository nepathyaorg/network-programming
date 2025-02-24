package Programs;

//given the host name, find the ip address
import java.net.*;

public class InetAddressExample {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.example.com");
            System.out.println("Address: " + address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
//