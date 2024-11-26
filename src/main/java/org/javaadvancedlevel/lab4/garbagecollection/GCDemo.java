package org.javaadvancedlevel.lab4.garbagecollection;

/**
 * Demonstrates the basics of Garbage Collection in Java.
 */
public class GCDemo {

    static class SampleObject {
        private final int id;

        SampleObject(int id) {
            this.id = id;
            System.out.println("Created object with id: " + id);
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("Finalized object with id: " + id);
        }
    }

    public static void main(String[] args) {
        SampleObject obj1 = new SampleObject(1);
        SampleObject obj2 = new SampleObject(2);

        obj1 = null; // Eligible for GC
        obj2 = null; // Eligible for GC

        System.gc(); // Requesting Garbage Collection
        System.out.println("GC requested.");
    }
}

