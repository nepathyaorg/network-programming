import java.io.*;
import java.net.*;

public class SimpleSocketServer {
    public static void main(String[] args) {
        int port = 5000;  // Server will listen on this port

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for client connection on port " + port);

            Socket clientSocket = serverSocket.accept(); // Accept client connection
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read message from client
            String message = in.readLine();
            System.out.println("Received from client: " + message);

            // Send response to client
            out.println("Message received: " + message);

            // Close client connection
            clientSocket.close();
            System.out.println("Client connection closed.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
