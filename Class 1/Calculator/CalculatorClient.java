import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 2000);
            CalculatorInterface stub = (CalculatorInterface) registry.lookup("CalculatorService");

            System.out.println("Add: " + stub.add(9, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
