package org.javaadvancedlevel.dynamicproxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        // Create an instance of Man
        Man m1 = new Man("Xavier1", 30, "Kigali", "Rwanda");
        Man m2 = new Man("Xavier2", 30, "Kigali", "Rwanda");

        PersonInvocationHandler handler = new PersonInvocationHandler(m1);
        Person proxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler);
        proxy.introduce("Xavier");
        proxy.sayAge(30);
        proxy.sayFrom("Kigali", "Rwanda");

        PersonInvocationHandler handler2 = new PersonInvocationHandler(m2);
        Person proxy2 = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, handler2);
        proxy2.introduce("Xavier");
        proxy2.sayAge(30);
        proxy2.sayFrom("Kigali", "Rwanda");
    }
}