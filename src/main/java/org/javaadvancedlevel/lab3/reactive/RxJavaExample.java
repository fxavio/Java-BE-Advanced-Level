package org.javaadvancedlevel.lab3.reactive;
import io.reactivex.rxjava3.core.Observable;
public class RxJavaExample {
    public static void main(String[] args) {
        /*
        Create Observables: Represent data streams.
        Transform with Operators: Modify or filter data streams.
        Subscribe: Listen for emitted values and handle them
         */
        /*
        The following code snippet demonstrates how to create an Observable from a list of items,
        filter items that start with "A", convert each item to uppercase,
        and subscribe to the Observable to print the filtered and transformed items.
         */
        Observable<String> observable = Observable.just("Apple", "Banana", "Orange", "Apricot", "Mango");

        observable
                .map(String::toUpperCase)
                .filter(fruit -> fruit.startsWith("A"))
                .subscribe(
                        System.out::println,    // onNext
                        Throwable::printStackTrace,  // onError
                        () -> System.out.println("Completed!") // onComplete
                );
    }
}

