package org.javaadvancedlevel.lab2.designPatterns.strategyPattern;

public class PremiumUserStrategy implements UserStrategy {
    public void showUserInfo(String name, String email, int age, String address) {
        System.out.println("Premium User - Name: " + name + ", Email: " + email + ", Age: " + age + ", Address: " + address);
    }
}
