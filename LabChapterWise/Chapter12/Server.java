
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//also called skeleton(Deprecated) but used in older version of java: receives request from stubs
//sends the result back to the client
public class Server {
    public static void main(String[] args) {
        try{
            CalculatorRemote objCalculatorRemote = new CalculatorRemote();
            Registry registry = LocateRegistry.createRegistry(9000);
            registry.bind("Multiply", objCalculatorRemote);
            System.out.println("Server is ready to accept requests...");
        }catch (Exception e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
