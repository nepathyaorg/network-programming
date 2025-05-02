import java.io.*;
import java.net.*;

import java.util.logging.*;

public class Server {
    
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    static {
        try {
            // FileHandler to save logs in a file (server.log)
            FileHandler fileHandler = new FileHandler("server.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(Level.ALL);
            logger.addHandler(fileHandler);

            logger.setLevel(Level.ALL);  // Set log level to ALL
        } catch (IOException e) {
            logger.severe("Failed to create log file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        logger.config("Server starting on port 5050...");

        try (ServerSocket serverSocket = new ServerSocket(5050)) {
            logger.info("Server started. Waiting for clients...");

            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

                    logger.info("Client connected: " + socket.getInetAddress());

                    // Read product request
                    String productName = input.readLine();
                    double price = Double.parseDouble(input.readLine());
                    logger.fine("Received product request: " + productName + " | Price: $" + price);

                    // Read payment amount
                    double payment = Double.parseDouble(input.readLine());
                    logger.finer("Processing payment: $" + payment);

                    // Process order
                    if (payment >= price) {
                        output.println("Payment Successful. Order confirmed.");
                        logger.info("Payment successful for " + productName + ". Amount paid: $" + payment);
                    } else {
                        output.println("Payment Failed. Insufficient amount.");
                        logger.warning("Payment failed for " + productName + ". Paid: $" + payment);
                    }

                    logger.finest("Transaction complete for: " + productName);

                } catch (Exception e) {
                    logger.severe("Error processing client request: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            logger.severe("Server error: " + e.getMessage());
        }
    }
}
