package org.javaadvancedlevel.lab3.functional;
import java.util.stream.IntStream;

/**
 * Demonstrates parallel streams for concurrent processing.
 */
public class ParallelStreamsExample {
    public static void main(String[] args) {
        // Regular stream
        System.out.println("Regular Stream:");
        IntStream.range(1, 10).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Parallel stream
        System.out.println("Parallel Stream:");
        IntStream.range(1, 10).parallel().forEach(n -> System.out.print(n + " "));
    }
}
