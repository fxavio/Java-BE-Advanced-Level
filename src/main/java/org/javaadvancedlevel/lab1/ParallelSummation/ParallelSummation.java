package org.javaadvancedlevel.lab1.ParallelSummation;

import java.util.concurrent.ForkJoinPool;

public class ParallelSummation {
    public static void main(String[] args) {
        // Create a large array with sample data
        int[] array = new int[10000]; // Adjust the array size and contents as needed
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1; // Sample data
        }

        // Create a ForkJoinPool to manage tasks
        ForkJoinPool pool = new ForkJoinPool();

        // Create a SumTask for the entire array
        SumTask task = new SumTask(array, 0, array.length);

        // Submit the task to the ForkJoinPool and get the final sum
        long result = pool.invoke(task);

        // Print the final sum
        System.out.println("Sum of the array: " + result);
    }
}
