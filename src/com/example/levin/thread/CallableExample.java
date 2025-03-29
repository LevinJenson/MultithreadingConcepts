package com.example.levin.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyClassThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Task executed by thread: " + Thread.currentThread().getName());
        return 42;
    }
}

public class CallableExample {
    public static void main(String[] args) {
        // Log the main thread name
        System.out.println("Main thread: " + Thread.currentThread().getName());

        // Create a Single Thread Executor
        ExecutorService executor = Executors.newFixedThreadPool(1);

            // Create an instance of MyClassThread
            MyClassThread thread = new MyClassThread();

            // Submit the task to the executor
            executor.submit(thread);

            // Get and print the result
    }
}
