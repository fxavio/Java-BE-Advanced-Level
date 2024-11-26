package org.javaadvancedlevel.lab3.java17;

/**
 * Sealed Class Example - Controls inheritance.
 */
sealed class Vehicle permits Car, Truck {}

final class Car extends Vehicle {}
final class Truck extends Vehicle {}

/**
 * Abstract Class Example - Open for extension.
 */
abstract class Animal {
    abstract void sound();
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow!");
    }
}


//print the result
public class Differences {
    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        System.out.println(vehicle.getClass().getSimpleName());
        Truck truck = new Truck();
        System.out.println(truck.getClass().getSimpleName());

        Animal animal = new Dog();
        animal.sound();
        Animal cat = new Cat();
        cat.sound();
    }

}