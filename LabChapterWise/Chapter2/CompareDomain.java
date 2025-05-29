import java.net.*;

public class CompareDomain {
    public static void main(String[] args) {
        try {
            // Getting IP addresses of both domains
            InetAddress addr1 = InetAddress.getByName("www.ibiblio.org");
            InetAddress addr2 = InetAddress.getByName("helios.ibiblio.org");

            // Displaying the resolved IP addresses
            System.out.println("IP Address of www.ibiblio.org: " + addr1.getHostAddress());
            System.out.println("IP Address of helios.ibiblio.org: " + addr2.getHostAddress());

            // Comparing the IP addresses
            if (addr1.equals(addr2)) {
                System.out.println("Both domain names point to the same address.");
            } else {
                System.out.println("The domain names point to different addresses.");
            }
        } catch (UnknownHostException e) {
            System.out.println("Error: Unable to resolve host - " + e.getMessage());
        }
    }
}
