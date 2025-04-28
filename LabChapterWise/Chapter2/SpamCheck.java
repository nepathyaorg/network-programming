import java.net.*;

public class SpamCheck {
    public static void main(String[] args) {
        try {
            // Domain name ko address khojne
            InetAddress address = InetAddress.getByName("www.google.com");

            // Hostname spamchaina bhane reply garne
            if (!address.isAnyLocalAddress()) {
                System.out.println("Yo spam address huna sakcha!");
            } else {
                System.out.println("Yo safe address ho.");
            }
        } catch (Exception e) {
            System.out.println("Error aayo: " + e.getMessage());
        }
    }
}
