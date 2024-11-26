package org.javaadvancedlevel.lab2.testng;



import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Demonstrates how TestNG differs from JUnit.
 */
public class TestNGExample {

    /**
     * A basic test using TestNG.
     */
    @Test
    public void additionTest() {
        int result = 2 + 3;
        Assert.assertEquals(result, 5, "Addition result should be 5");
    }
}

