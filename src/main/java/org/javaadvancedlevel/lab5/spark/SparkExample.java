package org.javaadvancedlevel.lab5.spark;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.Arrays;

/**
 * Demonstrates Apache Spark's parallel processing capabilities.
 *
 */
public class SparkExample {

    public static void main(String[] args) {
        // Spark configuration
        SparkConf conf = new SparkConf().setAppName("SparkExample").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // Sample dataset
        JavaRDD<Integer> numbers = sc.parallelize(Arrays.asList(1, 2, 3, 4, 5, 6));

        // Parallel processing: filter even numbers
        JavaRDD<Integer> evenNumbers = numbers.filter(num -> num % 2 == 0);

        // Collect and print results
        System.out.println("Even Numbers: " + evenNumbers.collect());

        sc.close();
    }
}
