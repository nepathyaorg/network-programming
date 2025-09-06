
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//sends the request to the server and receives the result from the server
// Compare this snippet from Client.java:

public class CLient {
    public static void main(String[] args) {
       try {
        Registry registry = LocateRegistry.getRegistry("localhost", 9000);
        Calculator calculator = (Calculator) registry.lookup("Multiply");
        int value = calculator.add(60, 10);
        System.out.println("Result is: "+value);

       } catch (Exception e) {
            System.out.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

