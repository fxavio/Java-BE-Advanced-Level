package org.javaadvancedlevel.lab5.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkSqlExample {
    public static void main(String[] args) {
        /*
            * The following code snippet demonstrates how to read a CSV file into a DataFrame,
            *  show the contents of the DataFrame, register the DataFrame as a temporary view,
            * run a SQL query on the DataFrame, and show the results of the SQL query.
            * The SparkSession is used to create the DataFrame and run the SQL query.
            * The DataFrame is created by reading the CSV file using the read() method of SparkSession.
            * The show() method is used to display the contents of the DataFrame.
            * The createOrReplaceTempView() method is used to register the DataFrame as a temporary view.
            * The sql() method is used to run a SQL query on the DataFrame and the results are displayed using the show() method.

         */

        // Initialize SparkSession
        SparkSession spark = SparkSession.builder()
                .appName("SparkSqlExample")
                .master("local")
                .getOrCreate();

        // Read the CSV file into a DataFrame
        Dataset<Row> df = spark.read()
                .option("header", "true")
                .option("inferSchema", "true")
                .csv("sample.csv");

        // Check if DataFrame is empty
        if (df.isEmpty()) {
            System.err.println("DataFrame is empty. Please check the input file.");
            spark.stop();
            System.exit(1);
        }

        // Show the contents of the DataFrame
        df.show();

        // Register the DataFrame as a temporary view
        df.createOrReplaceTempView("people");

        // Run a SQL query
        Dataset<Row> results = spark.sql("SELECT name, age FROM people WHERE age > 35");

        // Show the results of the SQL query
        results.show();
        // Stop the SparkSession
        spark.stop();
    }
}