package org.javaadvancedlevel.lab1.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Demonstrates the usage of the Fork/Join Framework to sum an array of integers.
 */
public class ForkJoinExample extends RecursiveTask<Integer> {
    private final int threshold = 10; // Threshold for splitting tasks
    private final int[] data; // Array of data to be summed
    private final int start; // Start index of the data array
    private final int end; // End index of the data array

    public ForkJoinExample(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        // If the task is small enough, compute directly
        if (end - start < threshold) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += data[i];
            }
            return sum;
        } else {
            // Split the task into two subtasks
            int mid = (start + end) / 2;
            ForkJoinExample leftTask = new ForkJoinExample(data, start, mid);
            ForkJoinExample rightTask = new ForkJoinExample(data, mid, end);
            leftTask.fork(); // Fork the left task
            int rightResult = rightTask.compute(); // Compute the right task
            int leftResult = leftTask.join(); // Join the left task
            return leftResult + rightResult; // Combine the results
        }
    }

    public static void main(String[] args) {
        int[] data = new int[100];
        for (int i = 0; i < data.length; i++) {
            data[i] = i + 1; // Initialize the array with values 1 to 100
        }
        ForkJoinPool pool = new ForkJoinPool(); // Create a ForkJoinPool
        ForkJoinExample task = new ForkJoinExample(data, 0, data.length); // Create the main task
        int result = pool.invoke(task); // Invoke the task
        System.out.println("Sum: " + result); // Print the result
    }
}