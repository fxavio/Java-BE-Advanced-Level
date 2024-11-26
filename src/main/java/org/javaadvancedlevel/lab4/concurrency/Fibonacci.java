package org.javaadvancedlevel.lab4.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Integer> {
    private final int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        // Base cases: Fibonacci of 0 or 1 is the number itself
        if (n <= 1) {
            return n;
        }

        // Create tasks for Fibonacci(n-1) and Fibonacci(n-2)
        Fibonacci fibNMinus1 = new Fibonacci(n - 1);
        Fibonacci fibNMinus2 = new Fibonacci(n - 2);

        // Fork tasks for Fibonacci(n-1) and Fibonacci(n-2)
        fibNMinus1.fork();
        fibNMinus2.fork();

        // Wait for and obtain results from the tasks for Fibonacci(n-1) and Fibonacci(n-2)
        int resultNMinus1 = fibNMinus1.join();
        int resultNMinus2 = fibNMinus2.join();

        // Combine the results and return Fibonacci(n)
        return resultNMinus1 + resultNMinus2;
    }

    public static void main(String[] args) {
        // Create a ForkJoinPool to manage tasks
        ForkJoinPool pool = new ForkJoinPool();

        // Define the Fibonacci number to calculate
        int number = 20; // Adjust this number as needed

        // Create a task to calculate the Fibonacci number
        Fibonacci task = new Fibonacci(number);

        // Invoke the task and obtain the result
        int result = pool.invoke(task);

        // Print the result
        System.out.println("Fibonacci of " + number + " is: " + result);
    }
}
