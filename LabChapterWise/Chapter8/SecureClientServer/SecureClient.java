import java.io.*;
import java.security.KeyStore;
import javax.net.ssl.*;

public class SecureClient {
    public static void main(String[] args) throws Exception {
        char[] password = "password".toCharArray();

        // Set system properties to point to the truststore file containing server cert or CA cert
        System.setProperty("javax.net.ssl.trustStore", "clienttruststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "password");

        // Load the truststore file (this step is optional if you want to create SSLContext manually)
        KeyStore ts = KeyStore.getInstance("JKS");
        try (FileInputStream fis = new FileInputStream("clienttruststore.jks")) {
            ts.load(fis, password);
        }

        // Initialize TrustManagerFactory with the truststore
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(ts);

        // Set up SSL context using the trust managers from the truststore
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, tmf.getTrustManagers(), null);

        // Create SSLSocketFactory from SSL context
        SSLSocketFactory ssf = sc.getSocketFactory();

        // Create an SSL socket connected to the server
        try (SSLSocket socket = (SSLSocket) ssf.createSocket("localhost", 12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Read response from server
            String response = in.readLine();
            System.out.println("Message from Server: " + response);
        }
    }
}
