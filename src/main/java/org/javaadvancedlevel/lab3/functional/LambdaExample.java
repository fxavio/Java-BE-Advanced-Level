package org.javaadvancedlevel.lab3.functional;
import java.util.List;
/**
 * Demonstrates how Lambdas simplify code for functional interfaces.
 */
public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        // Using a lambda expression
        names.forEach(name -> System.out.println("Hello, " + name));
    }
}
