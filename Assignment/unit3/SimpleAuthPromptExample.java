package unit3;

import java.net.*;
import java.io.*;
import java.util.Base64;
import java.util.Scanner;

public class SimpleAuthPromptExample {
    public static void main(String[] args) {
        try {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            URL url = new URL("https://www.anotherexample.com/secure-page");

            URLConnection connection = url.openConnection();

            String userCredentials = username + ":" + password;
            String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));

            connection.setRequestProperty("Authorization", basicAuth);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
