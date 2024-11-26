package org.javaadvancedlevel.lab5.flink;


import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;

/**
 * Demonstrates Apache Flink's batch processing capabilities.
 */
public class FlinkExample {

    public static void main(String[] args) throws Exception {
        // Flink execution environment
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // Sample dataset
        DataSet<Integer> numbers = env.fromElements(1, 2, 3, 4, 5, 6);

        // Filter even numbers
        DataSet<Integer> evenNumbers = numbers.filter(num -> num % 2 == 0);

        // Print results
        evenNumbers.print();
    }
}

