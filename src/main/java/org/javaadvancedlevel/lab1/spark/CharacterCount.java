package org.javaadvancedlevel.lab1.spark;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Demonstrates a word count program using Apache Spark.
 */
public class CharacterCount {
    public static void main(String[] args) {
        // Initialize SparkSession
        SparkSession spark = SparkSession.builder()
                .appName("CharacterCount")
                .master("local")
                .getOrCreate();

        // Use try-with-resources to ensure JavaSparkContext is closed
        try (JavaSparkContext sc = new JavaSparkContext(spark.sparkContext())) {
            // Load the text file
            JavaRDD<String> lines = sc.textFile("input.txt");

            // Split each line into characters
            JavaRDD<String> characters = lines.flatMap(line -> Arrays.asList(line.split("")).iterator());

            // Count each character
            JavaPairRDD<String, Integer> characterCounts = characters.mapToPair(character -> new Tuple2<>(character, 1))
                    .reduceByKey(Integer::sum);

            // Collect the results
            characterCounts.collect().forEach(tuple -> System.out.println(tuple._1 + ": " + tuple._2));
        }

        // Stop the SparkSession
        spark.stop();
    }
}
