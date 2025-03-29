package com.example.levin.thread.sync;

class Clock {
	static int count;

	public synchronized void increment() {
		count++;
	}
}

public class SynchronisedExample {

	public static void main(String[] args) throws InterruptedException {

		Clock clock = new Clock();

		Thread t1 = new Thread(() -> {

			for (int i = 0; i < 1000; i++) {
				clock.increment();
			}

		});

		Thread t2 = new Thread(() -> {

			for (int i = 0; i < 1000; i++) {
				clock.increment();
			}

		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Program Ends: "+ clock.count);
	}
}
