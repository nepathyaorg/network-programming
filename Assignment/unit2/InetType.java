package unit2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetType {

   public InetType() {
   }

   public static void main(String[] var0) {
      try {
         InetAddress var1 = InetAddress.getByName("instagram.com");
         System.out.println("Instagram:");
         System.out.println("Host Name: " + var1.getHostName());
         System.out.println("Canonical Host Name: " + var1.getCanonicalHostName());
         System.out.println("IP Address: " + var1.getHostAddress());
         System.out.println();
         InetAddress var2 = InetAddress.getLocalHost();
         System.out.println("Localhost:");
         System.out.println("Host Name: " + var2.getHostName());
         System.out.println("Canonical Host Name: " + var2.getCanonicalHostName());
         System.out.println("IP Address: " + var2.getHostAddress());
      } catch (UnknownHostException var3) {
         System.out.println("An error occurred: " + var3.getMessage());
      }

   }

}
