package org.javaadvancedlevel.lab2.designPatterns.singleton;
public class Singleton {
    private static Singleton instance;
    private final String name;
    private final String email;
    private final int age;
    private final String address;

    private Singleton() {
        this.name = "John Doe";
        this.email = "john.doe@example.com";
        this.age = 30;
        this.address = "123 St,Rwanda";
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Name: " + name + "\nEmail: " + email + "\nAge: " + age + "\nAddress: " + address);
    }


    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage();
    }
}

