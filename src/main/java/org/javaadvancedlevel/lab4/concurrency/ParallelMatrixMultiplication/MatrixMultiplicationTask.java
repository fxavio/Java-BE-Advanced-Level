package org.javaadvancedlevel.lab4.concurrency.ParallelMatrixMultiplication;

import java.util.concurrent.RecursiveTask;

class MatrixMultiplicationTask extends RecursiveTask<int[][]> {
    private final int[][] matrixA;
    private final int[][] matrixB;
    private final int rowStart;
    private final int colStart;
    private final int size;

    public MatrixMultiplicationTask(int[][] matrixA, int[][] matrixB, int rowStart, int colStart, int size) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.rowStart = rowStart;
        this.colStart = colStart;
        this.size = size;
    }

    @Override
    protected int[][] compute() {
        if (size <= 2) { // Threshold for small matrices
            return multiplySequentially(matrixA, matrixB, rowStart, colStart, size);
        } else {
            int newSize = size / 2;

            MatrixMultiplicationTask topLeft = new MatrixMultiplicationTask(matrixA, matrixB, rowStart, colStart, newSize);
            MatrixMultiplicationTask topRight = new MatrixMultiplicationTask(matrixA, matrixB, rowStart, colStart + newSize, newSize);
            MatrixMultiplicationTask bottomLeft = new MatrixMultiplicationTask(matrixA, matrixB, rowStart + newSize, colStart, newSize);
            MatrixMultiplicationTask bottomRight = new MatrixMultiplicationTask(matrixA, matrixB, rowStart + newSize, colStart + newSize, newSize);

            topLeft.fork();
            topRight.fork();
            bottomLeft.fork();
            int[][] bottomRightResult = bottomRight.compute();

            int[][] topLeftResult = topLeft.join();
            int[][] topRightResult = topRight.join();
            int[][] bottomLeftResult = bottomLeft.join();

            return combineResults(topLeftResult, topRightResult, bottomLeftResult, bottomRightResult, newSize);
        }
    }

    private int[][] multiplySequentially(int[][] matrixA, int[][] matrixB, int rowStart, int colStart, int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] += matrixA[rowStart + i][colStart + k] * matrixB[rowStart + k][colStart + j];
                }
            }
        }
        return result;
    }

    private int[][] combineResults(int[][] topLeft, int[][] topRight, int[][] bottomLeft, int[][] bottomRight, int size) {
        int[][] result = new int[size * 2][size * 2];
        copySubMatrix(topLeft, result, 0, 0);
        copySubMatrix(topRight, result, 0, size);
        copySubMatrix(bottomLeft, result, size, 0);
        copySubMatrix(bottomRight, result, size, size);
        return result;
    }

    private void copySubMatrix(int[][] source, int[][] destination, int rowStart, int colStart) {
        int size = source.length;
        for (int i = 0; i < size; i++) {
            System.arraycopy(source[i], 0, destination[rowStart + i], colStart, size);
        }
    }
}
