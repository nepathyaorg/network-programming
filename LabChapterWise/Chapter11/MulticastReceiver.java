// MulticastReceiver.java
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {
    public static void main(String[] args) {
        final int PORT = 4446; // Use the same port as sender
        final String MULTICAST_GROUP = "230.0.0.0"; // A valid multicast IP

        try {
            // Join the multicast group
            MulticastSocket socket = new MulticastSocket(PORT);
            InetAddress group = InetAddress.getByName(MULTICAST_GROUP);

            socket.joinGroup(group);
            System.out.println("Joined multicast group. Listening for messages...");

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Wait for a message (blocks until data is received)
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());

            System.out.println("Received multicast message: " + received);

            socket.leaveGroup(group);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
