// UDPServer.java
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9876);
            byte[] receiveBuffer = new byte[1024];

            System.out.println("Server is running and waiting for data...");

            // Receive packet
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            serverSocket.receive(receivePacket);
            String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Client says: " + clientMessage);

            // Send response
            String reply = "Message received: " + clientMessage;
            byte[] sendBuffer = reply.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(
                sendBuffer,
                sendBuffer.length,
                receivePacket.getAddress(),
                receivePacket.getPort()
            );
            serverSocket.send(sendPacket);

            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
