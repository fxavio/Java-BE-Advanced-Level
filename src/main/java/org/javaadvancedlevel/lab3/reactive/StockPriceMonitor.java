package org.javaadvancedlevel.lab3.reactive;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;
public class StockPriceMonitor {

    /**
     * Simulates fetching stock prices from an API.
     * Emits random price fluctuations for demonstration.
     *
     * @return Observable emitting stock prices
     */
    private static Observable<Double> fetchStockPrice() {
        return Observable.create(emitter -> {
            double price = 100.0; // Initial price
            while (!emitter.isDisposed()) {
                try {
                    // Simulate API delay and random price fluctuation
                    Thread.sleep(1000);
                    price += (Math.random() - 0.5) * 2;
                    emitter.onNext(price);
                } catch (Exception e) {
                    emitter.onError(new RuntimeException("API unavailable!"));
                }
            }
        });
    }

    public static void main(String[] args) {
        /**
         * Observable pipeline to monitor stock prices in real-time:
         * - fetchStockPrice(): Simulates a stock price API.
         * - retry(): Retries up to 3 times if the API fails.
         * - onErrorReturn(): Provides a fallback value in case of failure.
         * - flatMap(): Simulates async processing for each price update.
         * - observeOn(): Observes emissions on a single thread for display.
         */
        fetchStockPrice()
                .retry(3) // Retry up to 3 times if an error occurs
                .onErrorReturn(error -> -1.0) // Fallback value for errors
                .flatMap(price -> simulateProcessing(price)) // Asynchronously process price
                .observeOn(Schedulers.single()) // Observe emissions on a single thread
                .subscribe(
                        StockPriceMonitor::displayPrice, // onNext: Display the price
                        Throwable::printStackTrace,      // onError: Log errors
                        () -> System.out.println("Stream completed!") // onComplete: Notify stream end
                );

        // Keep the application alive to observe the stream
        try {
            TimeUnit.MINUTES.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Simulates asynchronous processing of stock prices, such as calculating percentage change.
     *
     * @param price The current stock price
     * @return Observable emitting processed stock price
     */
    private static Observable<String> simulateProcessing(Double price) {
        return Observable.just(price)
                .delay(500, TimeUnit.MILLISECONDS) // Simulate async delay
                .map(processedPrice -> {
                    if (processedPrice < 0) {
                        return "Fallback: API unavailable, showing default value.";
                    } else {
                        return String.format("Processed Price: $%.2f", processedPrice);
                    }
                });
    }

    /**
     * Displays the stock price in the console.
     *
     * @param message The message to display
     */
    private static void displayPrice(String message) {
        System.out.println(message);
    }
}
