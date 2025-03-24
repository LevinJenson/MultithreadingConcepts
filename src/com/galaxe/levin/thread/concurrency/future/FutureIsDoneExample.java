package com.galaxe.levin.thread.concurrency.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureIsDoneExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        

        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(2000);
            return 42;
        });

        while (!future.isDone()) {
            System.out.println("Task is still running...");
            Thread.sleep(500);
        }

        System.out.println("Task completed! Result: " + future.get());

        executor.shutdown();
    }
}