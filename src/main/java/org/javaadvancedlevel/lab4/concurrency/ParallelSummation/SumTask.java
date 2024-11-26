package org.javaadvancedlevel.lab4.concurrency.ParallelSummation;


import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 1000; // Threshold for array length

    private final int[] array;
    private final int start;
    private final int end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // Base case: Calculate sum directly for small arrays
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // Split the array into two halves
            int mid = start + (end - start) / 2;

            // Create subtasks for each half
            SumTask leftTask = new SumTask(array, start, mid);
            SumTask rightTask = new SumTask(array, mid, end);

            // Fork subtasks
            leftTask.fork();
            rightTask.fork();

            // Wait for and obtain results from subtasks
            long leftResult = leftTask.join();
            long rightResult = rightTask.join();

            // Return the sum of the results
            return leftResult + rightResult;
        }
    }
}


