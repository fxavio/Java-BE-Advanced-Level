package org.javaadvancedlevel.lab3.functional;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Demonstrates how the Streams API simplifies collection processing.
 */
public class StreamProcessingExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Filter even numbers and compute their squares
        List<Integer> squaresOfEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0) // Keep only even numbers
                .map(n -> n * n)         // Square each number
                .collect(Collectors.toList());

        System.out.println(squaresOfEvenNumbers); // Prints: [4, 16]
    }
}
