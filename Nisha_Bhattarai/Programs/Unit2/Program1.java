package Nisha_Bhattarai.Programs.Unit2;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;

//  In what ways `getHostName()` differs from `getCannonicalHostName()`? Write a JAVA program that,
// - Displays both hostname and the cannonical hostname of a domain.
// - Utilizes `getAddress()` to determine if the given address is IPv4 or IPv6
public class Program1 {
   public static void main(String[] args) {
      try {
         InetAddress address = InetAddress.getByName("www.youtube.com");
         System.out.println("Canonical Hostname: " + address.getCanonicalHostName());
         System.out.println("HostName: " + address.getHostName());
         // System.out.println(address.getAddress());
         byte[] add = address.getAddress();
         if (add.length == 4) {
            System.out.println("It is IPV4 address");

         } else if (add.length == 16) {
            System.out.println("It is IPV6 address");
         } else {
            System.out.println("Unknown IP format.");
         }

      } catch (Exception e) {
         // TODO: handle exception
         System.out.println("Error" + e.getMessage());

      }

   }
}
