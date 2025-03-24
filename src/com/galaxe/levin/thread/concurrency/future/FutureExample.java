package com.galaxe.levin.thread.concurrency.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newSingleThreadExecutor();

		Future<String> future = executor.submit(() -> {
			Thread.sleep(2000);
			return "Task Completed!";
		});

		System.out.println("Task submitted. Doing other work...");

		// Blocking call to get result
		String result = future.get();
		System.out.println("Result: " + result);

		executor.shutdown();
	}
}
