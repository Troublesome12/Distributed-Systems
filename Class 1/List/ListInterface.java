import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ListInterface extends Remote {
    void insertItem(String value) throws RemoteException;

    ArrayList<String> getItems() throws RemoteException;
}
