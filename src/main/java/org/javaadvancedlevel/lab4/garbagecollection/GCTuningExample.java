package org.javaadvancedlevel.lab4.garbagecollection;
/**
 * Demonstrates JVM options for GC tuning.
 */
public class GCTuningExample {

    public static void main(String[] args) {
        // Simulate workload
        for (int i = 0; i < 10_000; i++) {
            new String("Temporary Object " + i);
        }

        System.out.println("GC Tuning Example. Monitor JVM GC logs.");
    }
}

