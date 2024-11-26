package org.javaadvancedlevel.lab1.reflectionandannotations.two;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Class demonstrating parameter validation using annotations and reflection.
 */
public class ValidationExample {
    /**
     * Main method to demonstrate parameter validation.
     *
     * @param args Command line arguments (not used)
     * @throws NoSuchMethodException      If the specified method does not exist
     * @throws IllegalAccessException     If access to the method is denied
     * @throws InvocationTargetException If an error occurs while invoking the method
     */
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // Get the method to be validated
        Method method = MathOperations.class.getMethod("factorial", int.class);

        // Validate method-level annotation
        if (method.isAnnotationPresent(ParameterValidation.class)) {
            ParameterValidation methodAnnotation = method.getAnnotation(ParameterValidation.class);
            System.out.println("Method validation: min = " + methodAnnotation.min() + ", max = " + methodAnnotation.max());
        }

        // Validate parameter-level annotation
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            if (parameter.isAnnotationPresent(ParameterValidation.class)) {
                ParameterValidation parameterAnnotation = parameter.getAnnotation(ParameterValidation.class);
                // Since there's no direct method to get the default value of a parameter,
                // this code assumes that the parameter is an int and initializes it to 0.
                int value = 0;
                if (value < parameterAnnotation.min() || value > parameterAnnotation.max()) {
                    throw new IllegalArgumentException("Parameter out of range: " + parameter.getName());
                }
            }
        }

        // Invoke the method
        int result = (int) method.invoke(null, 5);
        System.out.println("Factorial of 5 is: " + result);
    }
}

