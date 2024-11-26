package org.javaadvancedlevel.lab5.flink;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * Demonstrates Apache Flink's batch processing capabilities with a word count example.
 *
 */
public class FlinkWordCountExample {

    public static void main(String[] args) throws Exception {
        // Create the Flink execution environment
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        // Sample dataset containing lines of text
        DataSet<String> text = env.fromElements(
                "Apache Flink is a framework and distributed processing engine",
                "Flink provides data-source and data-sink connectors",
                "Flink supports batch and stream processing"
        );

        // Split each line into words and count them
        DataSet<Tuple2<String, Integer>> wordCounts = text
                .flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
                    @Override
                    public void flatMap(String line, Collector<Tuple2<String, Integer>> out) {
                        // Split the line into words
                        for (String word : line.split(" ")) {
                            // Emit each word with a count of 1
                            out.collect(new Tuple2<>(word, 1));
                        }
                    }
                })
                // Group by the word (Tuple2 field 0) and sum the counts (Tuple2 field 1)
                .groupBy(0)
                .sum(1);

        // Print the word counts to the console
        wordCounts.print();
    }
}