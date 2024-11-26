package org.javaadvancedlevel.lab5.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class CustomerData {
    public static void main(String[] args) {
        // Initialize SparkSession
        SparkSession spark = SparkSession.builder()
                .appName("CustomerDataExample")
                .master("local[*]") // Use all available cores
                .getOrCreate();

        // Read the CSV file into a DataFrame
        Dataset<Row> df = spark.read()
                .option("header", "true")
                .option("inferSchema", "true")
                //                .csv("customers.csv");
                .csv("C:\\Users\\PC\\OneDrive\\Desktop\\customers-2000000.csv");   //this file is too large to load in the github repository



        // Check if DataFrame is empty
        if (df.isEmpty()) {
            System.err.println("DataFrame is empty. Please check the input file.");
            spark.stop();
            System.exit(1);
        }

        // Show the contents of the DataFrame
//        df.show();

        // Register the DataFrame as a temporary view
        df.createOrReplaceTempView("customers");

        // Run a SQL query to select specific columns
        Dataset<Row> results = spark.sql(
                "SELECT `Index`, `Customer Id`, `First Name`, `Last Name`, `Company`, `City`, `Country`, `Email` " +
                        "FROM customers WHERE `Country` = 'Rwanda'");

        // Show all rows of the results
        results.show();

        // Stop the SparkSession
        spark.stop();
    }
}

//--add-opens java.base/sun.nio.ch=ALL-UNNAMED
