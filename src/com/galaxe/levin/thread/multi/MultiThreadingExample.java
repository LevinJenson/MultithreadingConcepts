package com.galaxe.levin.thread.multi;

class Clock {
	static int count;

	public void incrementCount() {
		count++;
	}
}

class Thread1 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			Clock clock = new Clock();
			clock.incrementCount();
		}
	}

}

class Thread2 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i <1000; i++) {
			Clock clock = new Clock();
			clock.incrementCount();
		}
	}

}

public class MultiThreadingExample {

	public static void main(String[] args) throws InterruptedException {
		
		Clock clock = new Clock();

		Thread t1 = new Thread1();
		Thread t2 = new Thread2();
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Thread Ends" + clock.count);
	}
}
