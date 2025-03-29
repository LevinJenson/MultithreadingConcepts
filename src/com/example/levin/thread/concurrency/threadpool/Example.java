package com.example.levin.thread.concurrency.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Example {

	public static void main(String[] args) {

//		using newFixedThreadPool(int nThreads)
//		ExecutorService executor = Executors.newFixedThreadPool(3);
//
//		for (int i = 0; i < 5; i++) {
//		    executor.submit(() -> {
//		    	try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		        System.out.println("Task executed by: " + Thread.currentThread().getName());
//		    });
//		}
//		executor.shutdown();

//		using newCachedThreadPool()

//		ExecutorService executor = Executors.newCachedThreadPool();
//
//		for (int i = 0; i < 5; i++) {
//		    executor.submit(() -> {
//		        System.out.println("Task executed by: " + Thread.currentThread().getName());
//		    });
//		}
//		executor.shutdown();

//		using newSingleThreadExecutor()

//		ExecutorService executor = Executors.newSingleThreadExecutor();
//
//		for (int i = 0; i < 5; i++) {
//		    executor.submit(() -> {
//		    	try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		        System.out.println("Task executed by: " + Thread.currentThread().getName());
//		    });
//		}
//		executor.shutdown();

//using newScheduledThreadPool(int corePoolSize)

		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

		scheduler.schedule(() -> {
			System.out.println("Task executed after 3 seconds: " + Thread.currentThread().getName());
		}, 2, TimeUnit.SECONDS);

		scheduler.shutdown();

	}
}
