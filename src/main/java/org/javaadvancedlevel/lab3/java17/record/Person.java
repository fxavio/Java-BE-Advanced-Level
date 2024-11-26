package org.javaadvancedlevel.lab3.java17.record;

/**
 * A record to represent a Person with a name and age.
 * Records automatically generate:
 * - Constructor
 * - equals(), hashCode()
 * - toString()
 */
public record Person(String name, int age) {
}

