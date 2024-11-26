package org.javaadvancedlevel.lab2.testng;
import org.testng.annotations.Test;
/**
 * Demonstrates dependency testing using TestNG.
 */
public class DependencyExampleTest {

    /**
     * Test that must pass before dependent tests are executed.
     */
    @Test
    public void initialTest() {
        System.out.println("Initial test executed.");
    }

    /**
     * Test that depends on the initialTest.
     */
    @Test(dependsOnMethods = "initialTest")
    public void dependentTest() {
        System.out.println("Dependent test executed.");
    }
}

