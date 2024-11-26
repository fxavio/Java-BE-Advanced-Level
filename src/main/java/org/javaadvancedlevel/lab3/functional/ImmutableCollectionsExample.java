package org.javaadvancedlevel.lab3.functional;
import java.util.List;

/**
 * Demonstrates how immutable collections prevent concurrency issues.
 */
public class ImmutableCollectionsExample {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C");

        // The list cannot be modified, ensuring thread safety
        Runnable task = () -> list.forEach(System.out::println);

        // Running the task in parallel threads
        new Thread(task).start();
        new Thread(task).start();
    }
}

