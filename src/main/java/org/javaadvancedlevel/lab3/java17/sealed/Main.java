package org.javaadvancedlevel.lab3.java17.sealed;

class Main {
    public static void main(String[] args) {
        Shape shape = new Circle();
        System.out.println("Shape type: " + shape.getClass().getSimpleName());
    }
}
