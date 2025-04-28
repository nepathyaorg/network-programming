import java.net.*;

public class CheckIPType {
    public static void main(String[] args) {
        try {
            // InetAddress object banaune (example: google.com ko lagi)
            InetAddress address = InetAddress.getByName("google.com");

            // Address ko type check garne
            if (address instanceof Inet4Address) {
                System.out.println("Yo IPv4 address ho: " + address.getHostAddress());
            } else if (address instanceof Inet6Address) {
                System.out.println("Yo IPv6 address ho: " + address.getHostAddress());
            } else {
                System.out.println("Unknown address type: " + address.getHostAddress());
            }
        } catch (Exception e) {
            System.out.println("Error aayo: " + e.getMessage());
        }
    }
}
