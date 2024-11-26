package org.javaadvancedlevel.lab2.mockito;

import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
/**
 * Demonstrates creating and using mock objects with Mockito.
 */
public class MockitoBasicExample {

    interface CalculatorService {
        int add(int a, int b);
    }

    static class MathApplication {
        private final CalculatorService calculatorService;

        MathApplication(CalculatorService calculatorService) {
            this.calculatorService = calculatorService;
        }

        public int performAddition(int a, int b) {
            return calculatorService.add(a, b);
        }
    }

    public static void main(String[] args) {
        // Create a mock of CalculatorService
        CalculatorService calculatorService = Mockito.mock(CalculatorService.class);

        // Define behavior for the mock
        when(calculatorService.add(10, 20)).thenReturn(30);

        // Use the mock in the MathApplication
        MathApplication mathApp = new MathApplication(calculatorService);
        int result = mathApp.performAddition(10, 20);

        System.out.println("Result: " + result); // Should print: Result: 30

        // Verify that the add method was called with specific arguments
        verify(calculatorService).add(10, 20);
    }
}

