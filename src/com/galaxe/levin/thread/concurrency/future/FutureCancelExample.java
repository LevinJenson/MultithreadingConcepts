package com.galaxe.levin.thread.concurrency.future;

import java.util.concurrent.*;

//public class FutureCancelExample {
//    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//
//        Future<String> future = executor.submit(() -> {
//            Thread.sleep(5000);
//            return "Task Completed!";
//        });
//
//        Thread.sleep(1000);
//        boolean isCancelled = future.cancel(true); // Attempt to cancel the task
//        System.out.println("Task cancelled: " + isCancelled);
//
//        executor.shutdown();
//    }
//}

import java.util.concurrent.*;

public class FutureCancelExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<String> future = executor.submit(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Running task iteration: " + i);
                    Thread.sleep(1000); 
                    
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Task was interrupted! Exiting...");
                        return "Cancelled";
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Task interrupted during sleep!");
                return "Cancelled";
            }
            return "Task Completed!";
        });

        Thread.sleep(3000); // Let the task run for 3 seconds
        System.out.println("Attempting to cancel the task...");

        
        future.cancel(true);

        System.out.println("Task cancelled: " + future.isCancelled());
        System.out.println("Task done: " + future.isDone());

        executor.shutdown();
    }
}
