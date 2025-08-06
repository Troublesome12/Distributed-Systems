import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            CalculatorImpl obj = new CalculatorImpl();
            Registry registry = LocateRegistry.createRegistry(2000);
            registry.rebind("CalculatorService", obj);
            System.out.println("CalculatorServer is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
