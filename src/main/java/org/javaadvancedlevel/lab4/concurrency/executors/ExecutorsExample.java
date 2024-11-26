package org.javaadvancedlevel.lab4.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * The example demonstrates how to create and manage a pool of threads using the Executors framework.
 * The example creates a fixed thread pool with 4 threads and submits 10 tasks to the executor.
 * It then initiates an orderly shutdown of the executor and waits for all tasks to complete.
 * If the tasks do not complete within 60 seconds, the example forces a shutdown of the executor.
 * If the current thread is interrupted, the example also forces a shutdown of the executor.
 */
public class ExecutorsExample {
    public static void main(String[] args) {
        // Create a fixed thread pool with 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Submit 10 tasks to the executor
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executor.submit(() -> {
                System.out.println("Task " + index + " is running on " + Thread.currentThread().getName());
            });
        }

        // Initiate an orderly shutdown of the executor
        executor.shutdown();
        try {
            // Wait for all tasks to complete or timeout after 60 seconds
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                // Force shutdown if tasks did not complete in time
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            // Force shutdown if the current thread is interrupted
            executor.shutdownNow();
        }
    }
}