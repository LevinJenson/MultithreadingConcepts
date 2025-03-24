package com.galaxe.levin.thread;

public class ThreadLifecycleDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			try {
				System.out.println(Thread.currentThread().getName() + " is RUNNING");

				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + " is awake and RUNNING again");

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + " has TERMINATED");
		},"First-Thread");

		Thread thread2 = new Thread(() -> {
			try {
				System.out.println(Thread.currentThread().getName() + " is RUNNING");

				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + " is awake and RUNNING again");

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + " has TERMINATED");
		},"Second-Thread");
		
		System.out.println("Thread created (NEW)");
		thread.start();
		thread2.start();
		
		
		
		
		thread.join();
		thread2.join();
		
		
		thread.sleep(10000);
		
		
		System.out.println("Main Thread got Terminated- "+ Thread.currentThread().getName());

	}
}
