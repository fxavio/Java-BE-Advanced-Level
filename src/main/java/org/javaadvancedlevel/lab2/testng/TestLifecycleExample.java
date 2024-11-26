package org.javaadvancedlevel.lab2.testng;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Demonstrates the use of @BeforeMethod and @AfterMethod annotations in TestNG.
 */
public class TestLifecycleExample {
    /**
     * Setup method executed before each test.
     */
    @BeforeMethod
    public void setup() {
        System.out.println("Setup: Preparing for test execution.");
    }
    /**
     * Cleanup method executed after each test.
     */
    @AfterMethod
    public void teardown() {
        System.out.println("Teardown: Cleaning up after test execution.");
    }
    /**
     * Test case 1.
     */
    @Test
    public void testCase1() {
        System.out.println("Executing Test Case 1");
    }
    /**
     * Test case 2.
     */
    @Test
    public void testCase2() {
        System.out.println("Executing Test Case 2");
    }
}
