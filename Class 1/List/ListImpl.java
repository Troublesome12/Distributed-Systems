import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;


public class ListImpl extends UnicastRemoteObject implements ListInterface {
    private ArrayList <String> fruits;

    protected ListImpl() throws RemoteException {
        fruits = new ArrayList<>();
    }

    public void insertItem(String value) throws RemoteException {
        fruits.add(value);
        System.out.println("Added: " + value);
    }

    public ArrayList<String> getItems() throws RemoteException {
        return fruits;
    }
}
