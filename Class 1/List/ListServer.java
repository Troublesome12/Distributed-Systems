import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ListServer {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(2000);
            registry.rebind("ListService", new ListImpl());
            System.out.println("ListServer is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
