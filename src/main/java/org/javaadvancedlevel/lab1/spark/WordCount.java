package org.javaadvancedlevel.lab1.spark;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import java.util.Arrays;
public class WordCount {
    public static void main(String[] args) {
        // Initialize SparkSession
        SparkSession spark = SparkSession.builder()
                .appName("WordCount")
                .master("local")
                .getOrCreate();

        // Use try-with-resources to ensure JavaSparkContext is closed
        try (JavaSparkContext sc = new JavaSparkContext(spark.sparkContext())) {
            // Load the text file
            JavaRDD<String> lines = sc.textFile("input.txt");

            // Split each line into words
            JavaRDD<String> words = lines.flatMap(line -> Arrays.asList(line.split(" ")).iterator());

            // Count each word
            JavaPairRDD<String, Integer> wordCounts = words.mapToPair(word -> new Tuple2<>(word, 1))
                    .reduceByKey(Integer::sum);

            // Collect the results
            wordCounts.collect().forEach(tuple -> System.out.println(tuple._1 + ": " + tuple._2));
        }

        // Stop the SparkSession
        spark.stop();
    }
}