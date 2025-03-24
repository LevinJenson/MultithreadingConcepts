package com.galaxe.levin.thread.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class runAsyncExample {

	ExecutorService executor = Executors.newFixedThreadPool(2);
	
	public Void saveDetails() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {

			@Override
			public void run() {
				System.out.println("Entering the thread..... " + Thread.currentThread().getName());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Execution ended " + Thread.currentThread().getName());

			}

		});

		return future.get();
	}

	public Void saveDetailsWithLamda() throws InterruptedException, ExecutionException {
		CompletableFuture<Void> future = CompletableFuture.runAsync(

				() -> {
					System.out.println("Entering the thread..... " + Thread.currentThread().getName());
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Execution ended " + Thread.currentThread().getName());

				},executor);

		return future.get();
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		runAsyncExample example = new runAsyncExample();
		example.saveDetails();
		
//		example.saveDetailsWithLamda();

	}
}
