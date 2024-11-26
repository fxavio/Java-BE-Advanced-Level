package org.javaadvancedlevel.lab1.forkjoin;
import java.util.concurrent.RecursiveTask;
class Fibonacci extends RecursiveTask<Integer> {
    final int n;
    Fibonacci(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }

        Fibonacci fibNMinus1 = new Fibonacci(n - 1);
        fibNMinus1.fork();

        Fibonacci fibNMinus2 = new Fibonacci(n - 2);
        int resultNMinus2 = fibNMinus2.compute();
        int resultNMinus1 = fibNMinus1.join();

        return resultNMinus1 + resultNMinus2;
    }
}
