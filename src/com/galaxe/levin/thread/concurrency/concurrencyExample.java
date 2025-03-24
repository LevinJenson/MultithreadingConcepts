package com.galaxe.levin.thread.concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class concurrencyExample {

	public static void main(String[] args) {

		ExecutorService executors = Executors.newFixedThreadPool(2);

		Runnable task1 = () -> {

			System.out.println("This is the task-1 " + Thread.currentThread().getName()+" at " + LocalDateTime.now());
		};

		Runnable task2 = () -> {

			System.out.println("This is the task-2 " + Thread.currentThread().getName() + " at " + LocalDateTime.now());
		};
		
		
		
		executors.submit(task1);
		executors.submit(task2);
		
		executors.shutdown();
	}
}
