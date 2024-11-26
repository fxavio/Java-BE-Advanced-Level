package org.javaadvancedlevel.lab2.mockito;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
/**
 * Demonstrates mocking static methods with Mockito.
 */
public class MockitoStaticExample {
    static class UtilityClass {
        public static String getGreeting() {
            return "Hello, World!";
        }
    }
    public static void main(String[] args) {
        // Mock static methods of UtilityClass
        try (MockedStatic<UtilityClass> mockedStatic = Mockito.mockStatic(UtilityClass.class)) {
            // Define behavior for the static method
            mockedStatic.when(UtilityClass::getGreeting).thenReturn("Mocked Greeting");

            // Call the static method and verify behavior
            String greeting = UtilityClass.getGreeting();
            System.out.println("Greeting: " + greeting); // Should print: Greeting: Mocked Greeting

            // Verify the static method call
            mockedStatic.verify(UtilityClass::getGreeting);
        }
    }
}

