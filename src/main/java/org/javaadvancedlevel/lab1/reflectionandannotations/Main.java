package org.javaadvancedlevel.lab1.reflectionandannotations;
import java.lang.reflect.Method;
public class Main {
    public static void main(String[] args) throws NoSuchMethodException{
        Method method = MyClass.class.getMethod("myMethod");

        if (method.isAnnotationPresent(MethodInfo.class)) {
            MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
            System.out.println("Method Author: " + methodInfo.author());
            System.out.println("Method Version: " + methodInfo.version());
        } else {
            System.out.println("Annotation not present");
        }

    }
}
