import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyChallenge {

    // This HashMap simulates a server's shared, in-memory data store.
    private static final Map<String, Integer> serverData = new HashMap<>();

    // Lock to protect access to serverData
    private static final Lock lock = new ReentrantLock();

    public static void processUpdate(String recordId) {
        lock.lock(); // acquire the lock
        try {
            Integer currentValue = serverData.get(recordId);
            if (currentValue == null) {
                serverData.put(recordId, 1);
            } else {
                serverData.put(recordId, currentValue + 1);
            }
        } finally {
            lock.unlock(); // ensure the lock is always released
        }
    }


    public static void main(String[] args) throws InterruptedException {
        // Use a thread pool to simulate 1000 concurrent update operations.
        ExecutorService executor = Executors.newFixedThreadPool(100);
        String recordId = "station_123";

        // Submit 1000 tasks to update the same piece of data.
        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> processUpdate(recordId));
        }

        // Wait for all tasks to complete.
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        // What is the final value? It should be 1000.
        System.out.println("Final update count for " + recordId + ": " + serverData.get(recordId));
    }
}
