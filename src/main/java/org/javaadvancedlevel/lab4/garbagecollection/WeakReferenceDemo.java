package org.javaadvancedlevel.lab4.garbagecollection;
import java.lang.ref.WeakReference;
/**
 * Demonstrates the use of WeakReferences to prevent memory leaks.
 */
public class WeakReferenceDemo {

    static class LargeObject {
        private final String data;

        LargeObject(String data) {
            this.data = data;
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("Finalized LargeObject: " + data);
        }
    }

    public static void main(String[] args) {
        LargeObject strongRef = new LargeObject("Important Data");

        // Weak Reference to the same object
        WeakReference<LargeObject> weakRef = new WeakReference<>(strongRef);

        System.out.println("Before nulling strong reference:");
        System.out.println("Weak Ref points to: " + weakRef.get());

        // Remove strong reference
        strongRef = null;
        System.gc();

        System.out.println("After GC:");
        System.out.println("Weak Ref points to: " + weakRef.get());
    }
}

