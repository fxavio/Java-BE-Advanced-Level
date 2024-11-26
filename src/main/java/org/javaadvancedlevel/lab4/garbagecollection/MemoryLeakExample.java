package org.javaadvancedlevel.lab4.garbagecollection;
import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates a memory leak scenario due to lingering references.
 */
public class MemoryLeakExample {

    static class LeakyContainer {
        private final List<String> container = new ArrayList<>();

        void add(String value) {
            container.add(value);
        }

        void remove(int index) {
            // Doesn't remove the reference, causing a memory leak
            container.set(index, null);
        }
    }

    public static void main(String[] args) {
        LeakyContainer leakyContainer = new LeakyContainer();
        for (int i = 0; i < 100_000; i++) {
            leakyContainer.add("Data " + i);
        }

        leakyContainer.remove(0); // Lingering reference
        System.gc();
    }
}

