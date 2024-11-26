package org.javaadvancedlevel.lab3.java17.sealed;

/**
 * A sealed class representing a shape, allowing only specific subclasses.
 */
public sealed class Shape permits Circle, Rectangle {
}

