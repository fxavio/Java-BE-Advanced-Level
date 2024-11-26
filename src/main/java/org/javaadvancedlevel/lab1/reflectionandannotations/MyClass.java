package org.javaadvancedlevel.lab1.reflectionandannotations;

class MyClass {
    @MethodInfo(author = "John Doe", version = 1)
    public void myMethod() {
        System.out.println("Hello");
    }
}
