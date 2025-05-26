import java.io.*;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SecureSocketClient {
    public static void main(String[] args) {
        String host = "tufohss.edu.np";
        int port = 443; // HTTPS default port

        try {
            // Create SSL socket factory and socket
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket) factory.createSocket(host, port);

            // Start handshake (optional, but recommended)
            sslSocket.startHandshake();

            // Output stream to send data to server
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(sslSocket.getOutputStream())));

            // Input stream to read server response
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(sslSocket.getInputStream()));

            // Send HTTP GET request
            out.println("GET / HTTP/1.1");
            out.println("Host: " + host);
            out.println("Connection: Close");
            out.println(); // blank line to end request headers
            out.flush();

            // Read and print the response line by line
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            // Close streams and socket
            in.close();
            out.close();
            sslSocket.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
