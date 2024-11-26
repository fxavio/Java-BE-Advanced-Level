package org.javaadvancedlevel.lab3.functional;
import java.util.List;

/**
 * Demonstrates how immutability ensures thread safety.
 *
 */
public class ImmutabilityExample {
    public static void main(String[] args) {
        List<String> immutableList = List.of("A", "B", "C");
        // Attempting to modify results in an UnsupportedOperationException
        try {
            immutableList.add("D");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify immutable list");
        }
    }
}

