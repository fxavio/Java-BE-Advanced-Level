package org.javaadvancedlevel.dynamicproxy;

public class Man implements Person {

    private final String name;
    private final int age;
    private final String city;
    private final String country;

    public Man(String name, int age, String city, String country) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }

    @Override
    public void introduce(String name) {

        System.out.println("Name: " + this.name);
    }
    @Override
    public void sayAge(int age) {
        System.out.println("Age: " + this.age + " years");
    }
    @Override
    public void sayFrom(String city, String country) {
        System.out.println("From: " + this.city + ", " + this.country);
    }
}
