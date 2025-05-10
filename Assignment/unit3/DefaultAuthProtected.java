package unit3;

import java.net.*;
import java.io.*;
import java.util.Base64;

public class DefaultAuthProtected {
    public static void main(String[] args) throws Exception {

        URL url = new URL("https://another-example.com/secure-page");

        URLConnection connection = url.openConnection();

        String userCredentials = "newuser:newpassword";
        String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
        connection.setRequestProperty("Authorization", basicAuth);

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
    }
}
