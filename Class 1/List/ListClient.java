import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ListClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 2000);
            ListInterface stub = (ListInterface) registry.lookup("ListService");
            stub.insertItem("Orange");
            System.out.println("Current Items: " + stub.getItems());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
