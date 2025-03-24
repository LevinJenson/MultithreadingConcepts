package com.galaxe.levin.thread.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Simulate fetching user details asynchronously
        CompletableFuture<String> fetchUserDetails = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching user details...");
            // Simulate a delay (e.g., network call)
            sleep(10000);
            return "User123";
        });

        // Process user details (e.g., convert to uppercase)
        CompletableFuture<String> processUserDetails = fetchUserDetails.thenApply(user -> {
            System.out.println("Processing user details...");
            return user.toUpperCase();
        });

        // Simulate fetching user orders asynchronously
        CompletableFuture<Integer> fetchUserOrders = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching user orders...");
            // Simulate a delay (e.g., network call)
            sleep(1500);
            return 5; // Number of orders
        });

        // Combine results from both tasks
        CompletableFuture<String> combinedResult = processUserDetails.thenCombine(fetchUserOrders, (user, orders) -> {
            System.out.println("Combining results...");
            return user + " has " + orders + " orders.";
        });

        // Handle exceptions
        CompletableFuture<String> resultWithExceptionHandling = combinedResult.exceptionally(ex -> {
            System.out.println("Exception occurred: " + ex.getMessage());
            return "Default User has 0 orders.";
        });

        // Final action (e.g., print the result)
        resultWithExceptionHandling.thenAccept(result -> {
            System.out.println("Final Result: " + result);
        });

        // Wait for the final result (for demonstration purposes)
        resultWithExceptionHandling.get();
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted", e);
        }
    }
}