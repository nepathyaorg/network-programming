import java.net.*;

public class LocalAddress {
    public static void main(String[] args) {
        try {
            // Local machine ko address lina
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("Local Address: " + local.getHostAddress());
        } catch (Exception e) {
            System.out.println("Error aayo: " + e.getMessage());
        }
    }
}
