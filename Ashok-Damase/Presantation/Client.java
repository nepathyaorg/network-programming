import java.io.*;
import java.net.*;
import java.util.logging.*;

public class Client {
    
    private static final Logger logger = Logger.getLogger(Client.class.getName());

    static {
        try {
            // FileHandler to save logs in a file (client.log)
            FileHandler fileHandler = new FileHandler("client.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.ALL);
            logger.addHandler(fileHandler);

            logger.setLevel(Level.ALL);  // Set log level to ALL
        } catch (IOException e) {
            logger.severe("Failed to create log file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5050);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

            logger.config("Connected to the server.");

            // Automatically sending order details (No user input)
            String productName = "Laptop";
            double price = 800.0;
            double payment = 800.0; // Correct payment

            output.println(productName);
            output.println(price);
            output.println(payment);

            logger.fine("Sent order: " + productName + " | Price: $" + price);
            logger.finer("Sent payment: $" + payment);

            // Receiving server response
            String response = input.readLine();
            logger.info("Server Response: " + response);
            System.out.println("Server: " + response);

        } catch (IOException e) {
            logger.severe("Client error: " + e.getMessage());
        }
    }
}
