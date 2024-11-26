package org.javaadvancedlevel.lab1.JavaMemoryModel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        final Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Thread interrupted while waiting for completion", e);
            Thread.currentThread().interrupt(); // Restore interrupted status
        }

        System.out.println("Final count: " + counter.getCount());
    }
}
