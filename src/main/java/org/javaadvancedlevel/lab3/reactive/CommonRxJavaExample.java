package org.javaadvancedlevel.lab3.reactive;

import io.reactivex.rxjava3.core.Observable;

public class CommonRxJavaExample {
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
                .map(String::toUpperCase) // Convert each item to uppercase
                .filter(fruit -> fruit.startsWith("A")) // Filter items that start with "A"
                .subscribe(
                        item -> System.out.println("map & filter: " + item),    // onNext: Print each item
                        Throwable::printStackTrace,  // onError: Print stack trace if error occurs
                        () -> System.out.println("Completed!") // onComplete: Print "Completed!" when done
                );

        // Additional RxJava operator examples

        // flatMap()
        Observable<String> flatMapObservable = Observable.just("Apple", "Banana", "Orange");
        flatMapObservable
                .flatMap(fruit -> Observable.fromArray(fruit.split(""))) // Split each item into characters and flatten
                .subscribe(item -> System.out.println("flatMap: " + item)); // Print each character

        // scan()
        Observable<Integer> scanObservable = Observable.just(1, 2, 3, 4, 5);
        scanObservable
                .scan((sum, item) -> sum + item) // Cumulatively sum the items
                .subscribe(item -> System.out.println("scan: " + item)); // Print each cumulative sum

        // distinct()
        Observable<Integer> distinctObservable = Observable.just(1, 2, 2, 3, 4, 4, 5);
        distinctObservable
                .distinct() // Suppress duplicate items
                .subscribe(item -> System.out.println("distinct: " + item)); // Print each distinct item

        // take(n)
        Observable<Integer> takeObservable = Observable.just(1, 2, 3, 4, 5);
        takeObservable
                .take(3) // Emit only the first 3 items
                .subscribe(item -> System.out.println("take: " + item)); // Print each item

        // merge()
        Observable<String> mergeObservable1 = Observable.just("Apple", "Banana");
        Observable<String> mergeObservable2 = Observable.just("Orange", "Grape");
        Observable.merge(mergeObservable1, mergeObservable2) // Combine multiple Observables into one
                .subscribe(item -> System.out.println("merge: " + item)); // Print each item

        // zip()
        Observable<String> zipObservable1 = Observable.just("Apple", "Banana");
        Observable<String> zipObservable2 = Observable.just("Orange", "Grape");
        Observable.zip(zipObservable1, zipObservable2, (item1, item2) -> item1 + " & " + item2) // Combine items from multiple Observables
                .subscribe(item -> System.out.println("zip: " + item)); // Print each combined item

        // combineLatest()
        Observable<String> combineLatestObservable1 = Observable.just("Apple", "Banana");
        Observable<String> combineLatestObservable2 = Observable.just("Orange", "Grape");
        Observable.combineLatest(combineLatestObservable1, combineLatestObservable2, (item1, item2) -> item1 + " & " + item2) // Emit items based on the latest emitted values
                .subscribe(item -> System.out.println("combineLatest: " + item)); // Print each combined item

        // onErrorReturn()
        Observable<Integer> onErrorReturnObservable = Observable.just(1, 2, 0, 4)
                .map(item -> 10 / item) // Perform division
                .onErrorReturn(e -> -1); // Provide fallback value when error occurs
        onErrorReturnObservable.subscribe(item -> System.out.println("onErrorReturn: " + item)); // Print each item or fallback value

        // retry()
        Observable<Integer> retryObservable = Observable.just(1, 2, 0, 4)
                .filter(item -> item != 0) // Filter out zero values
                .map(item -> 10 / item) // Perform division
                .retry(2); // Retry the operation upon failure
        retryObservable.subscribe(item -> System.out.println("retry: " + item), Throwable::printStackTrace); // Print each item or error stack trace

        // delay()
        Observable<String> delayObservable = Observable.just("Apple", "Banana", "Orange");
        delayObservable
                .delay(1, java.util.concurrent.TimeUnit.SECONDS) // Delay the emission of items by 1 second
                .subscribe(item -> System.out.println("delay: " + item)); // Print each item

        // subscribeOn()
        Observable<String> subscribeOnObservable = Observable.just("Apple", "Banana", "Orange");
        subscribeOnObservable
                .subscribeOn(io.reactivex.rxjava3.schedulers.Schedulers.io()) // Specify the thread to perform work on
                .subscribe(item -> System.out.println("subscribeOn: " + item)); // Print each item

        // observeOn()
        Observable<String> observeOnObservable = Observable.just("Apple", "Banana", "Orange");
        observeOnObservable
                .observeOn(io.reactivex.rxjava3.schedulers.Schedulers.computation()) // Specify the thread for observing emissions
                .subscribe(item -> System.out.println("observeOn: " + item)); // Print each item
    }
}