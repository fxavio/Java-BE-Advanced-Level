package org.javaadvancedlevel.lab3.functional;
import java.util.List;

/**
 * Demonstrates how lambdas improve stream readability.
 */
public class LambdaInStreamsExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");

        // Print uppercase names using a stream and lambda
        names.stream()
                .map(name -> name.toUpperCase()) // Convert to uppercase
                .forEach(System.out::println);  // Print each name
    }
}

