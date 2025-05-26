
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//UnicastRemoteObject is a class that provides the functionality to export an object so that it can accept incoming calls from clients. It is a subclass of java.rmi.server.RemoteServer and implements the Remote interface.
// It is used to create a remote object that can be accessed by clients over the network. The class provides methods for exporting and unexporting the object, as well as for managing the object's lifecycle.
public class CalculatorRemote extends UnicastRemoteObject implements Calculator{
    //constructor
    public CalculatorRemote() throws RemoteException {
        super();
    }
    
    @Override
    public int add(int a, int b){
        return a + b;
    }
    
}
