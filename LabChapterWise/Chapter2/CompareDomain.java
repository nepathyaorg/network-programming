import java.net.*;

public class CompareDomain {
    public static void main(String[] args) {
        try {
            // Duita domain ko IP address khojne
            InetAddress addr1 = InetAddress.getByName("www.google.com");
            InetAddress addr2 = InetAddress.getByName("www.youtube.com");

            // Address compare garne
            if (addr1.equals(addr2)) {
                System.out.println("Domain haru same address ma point cha.");
            } else {
                System.out.println("Domain haru different address ma chha.");
            }
        } catch (Exception e) {
            System.out.println("Error aayo: " + e.getMessage());
        }
    }
}
