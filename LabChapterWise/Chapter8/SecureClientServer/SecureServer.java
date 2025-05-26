import java.io.*;
import java.security.KeyStore;
import javax.net.ssl.*;

public class SecureServer {
    public static void main(String[] args) throws Exception {
        char[] password = "password".toCharArray();

        // Load keystore
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream("serverkeystore.jks"), password);

        // Initialize KeyManagerFactory
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, password);

        // Set up SSL context
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(kmf.getKeyManagers(), null, null);

        SSLServerSocketFactory ssf = sc.getServerSocketFactory();
        SSLServerSocket serverSocket = (SSLServerSocket) ssf.createServerSocket(12345);

        System.out.println("Secure Server started on port 12345...");

        while (true) {
            SSLSocket socket = (SSLSocket) serverSocket.accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello from secure server!");
            socket.close();
        }
    }
}
