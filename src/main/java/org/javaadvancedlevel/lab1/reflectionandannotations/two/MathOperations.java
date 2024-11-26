package org.javaadvancedlevel.lab1.reflectionandannotations.two;

/**
 * Class containing math operations.
 */
class MathOperations {
    /**
     * Method to calculate the factorial of a number.
     *
     * @param n The number for which factorial is calculated
     * @return The factorial of the input number
     */
    @ParameterValidation(min = 0)
    public static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }
}
