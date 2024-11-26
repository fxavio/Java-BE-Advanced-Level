package org.javaadvancedlevel.lab2.designPatterns.strategyPattern;

public class UserContext {
    private UserStrategy strategy;

    public void setStrategy(UserStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(String name, String email, int age, String address) {
        strategy.showUserInfo(name, email, age, address);
    }

    public static void main(String[] args) {
        UserContext context = new UserContext();

        context.setStrategy(new BasicUserStrategy());
        context.executeStrategy("Alice", "alice@example.com", 25, "456 Another St");

        context.setStrategy(new PremiumUserStrategy());
        context.executeStrategy("Bob", "bob@example.com", 35, "789 Another St");
    }
}
