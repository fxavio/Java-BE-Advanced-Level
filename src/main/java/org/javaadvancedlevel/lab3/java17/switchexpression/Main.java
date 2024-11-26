package org.javaadvancedlevel.lab3.java17.switchexpression;

/**
 * Demonstrates the compact and expressive syntax of switch expressions.
 */
public class Main {
    public static void main(String[] args) {
        String day = "MONDAY";
        int result = switch (day) {
            case "MONDAY", "TUESDAY" -> 1; // Grouped cases
            case "WEDNESDAY" -> 2;
            default -> 0; // Default case
        };
        System.out.println("Result: " + result); // Prints: Result: 1
    }
}

