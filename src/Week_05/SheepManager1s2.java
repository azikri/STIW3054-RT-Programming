package Week_05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger; // New

public class SheepManager1s2 {

//    private int sheepCount = 0;
    private AtomicInteger sheepCount = new AtomicInteger(0);

    private void incrementAndReport() {
        synchronized(this){
//        System.out.print((++sheepCount) + " ");
        System.out.print(sheepCount.incrementAndGet() + " ");
        }
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            SheepManager1s2 manager = new SheepManager1s2();
            for (int i = 0; i < 10; i++) {
                service.submit(() -> manager.incrementAndReport());
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}
