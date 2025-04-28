import java.net.*;

public class LocalIPHost {
    public static void main(String[] args) {
        try {
            // Local machine ko IP ra Hostname print garne
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("IP Address: " + local.getHostAddress());
            System.out.println("Host Name: " + local.getHostName());
        } catch (Exception e) {
            System.out.println("Error aayo: " + e.getMessage());
        }
    }
}
