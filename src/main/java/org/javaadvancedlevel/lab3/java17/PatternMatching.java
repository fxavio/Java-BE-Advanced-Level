package org.javaadvancedlevel.lab3.java17;

/**
 * The `PatternMatching` class demonstrates the use of pattern matching with switch expressions in Java.
 * Pattern matching allows you to conditionally execute code based on the type of an object, simplifying type checks and casting.
 *
 * In this example:
 * 1. An `Object` named `obj` is initialized with a `String` value "Hello".
 * 2. A switch expression checks the type of `obj`:
 *    - If `obj` is an `Integer`, it binds the value to `i` and returns "Integer: " followed by the integer value.
 *    - If `obj` is a `String`, it binds the value to `s` and returns "String: " followed by the string value.
 *    - If `obj` is of any other type, it returns "Unknown type".
 * 3. The result of the switch expression is printed, which in this case will be "String: Hello" since `obj` is a `String`.
 */
public class PatternMatching {
    public static void main(String[] args) {
        /*
         * Pattern matching with switch expressions
         */
        Object obj = "Hello";
        Object obj2 = 45;

        String result = switch (obj) {
            case Integer i -> "Integer: " + i;
            case String s -> "String: " + s;
            default -> "Unknown type";
        };

        System.out.println(result); // Prints: String: Hello
    }
}