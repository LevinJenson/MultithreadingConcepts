package com.galaxe.levin.thread.atomicvariables;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderExample {
	public static void main(String[] args) throws InterruptedException {
		LongAdder longAdder = new LongAdder();

		// Create a thread pool
		ExecutorService executor = Executors.newFixedThreadPool(10);

		// Simulate multiple threads updating the counter
		for (int i = 0; i < 1000; i++) {
			executor.submit(() -> {
				longAdder.add(1);
			}

			);
		}

		// Shutdown the executor and wait for tasks to complete
//		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.MINUTES);

		// Get the final sum
		System.out.println("Final Count: " + longAdder.sum());
	}
}
