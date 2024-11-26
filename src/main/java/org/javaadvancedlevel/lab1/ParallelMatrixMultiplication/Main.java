package org.javaadvancedlevel.lab1.ParallelMatrixMultiplication;

import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        // Example matrices
        int[][] matrixA = {{1, 2}, {3, 4}};
        int[][] matrixB = {{5, 6}, {7, 8}};

        // Matrix dimensions
        int size = matrixA.length;

        // Create ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Create task
        MatrixMultiplicationTask task = new MatrixMultiplicationTask(matrixA, matrixB, 0, 0, size);

        // Invoke task
        int[][] result = pool.invoke(task);

        // Print result
        System.out.println("Resultant Matrix:");
        printMatrix(result);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

