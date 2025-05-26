import java.io.*;
import java.net.*;

public class SimpleSocketClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // or IP address of the server
        int port = 5000;  // port number the server is listening on

        try (Socket socket = new Socket(serverAddress, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to server at " + serverAddress + ":" + port);

            // Read user input and send to server
            System.out.print("Enter message to send: ");
            String message = userInput.readLine();
            out.println(message);

            // Read and print server response
            String response = in.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
