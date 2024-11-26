package org.javaadvancedlevel.lab5.spark;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Demonstrates a simple recommendation engine setup using Apache Spark.
 */
public class RecommendationEngine {

    public static void main(String[] args) {
        // Spark configuration
        SparkConf conf = new SparkConf().setAppName("RecommendationEngine").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // Sample dataset of user-item interactions
        JavaPairRDD<String, String> userInteractions = sc.parallelizePairs(Arrays.asList(
                new Tuple2<>("User1", "ItemA"),
                new Tuple2<>("User2", "ItemB"),
                new Tuple2<>("User1", "ItemC"),
                new Tuple2<>("User3", "ItemA"),
                new Tuple2<>("User2", "ItemA")
        ));

        // Group by item and recommend items viewed by other users
        JavaPairRDD<String, Iterable<String>> recommendations = userInteractions
                .mapToPair(Tuple2::swap)
                .groupByKey();

        // Print recommendations
        recommendations.foreach(data -> {
            System.out.println("Item: " + data._1 + " -> Recommended Users: " + data._2);
        });

        sc.close();
    }
}

