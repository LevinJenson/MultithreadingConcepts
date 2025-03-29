package com.example.levin.thread.priority;

class PriorityThread extends Thread {
	public PriorityThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(getName() + " is running with priority " + getPriority());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(getName() + " interrupted.");
			}
		}
		System.out.println(getName() + " finished.");
	}
}

public class ThreadPriorityExample {
	public static void main(String[] args) {

		PriorityThread thread1 = new PriorityThread("Low Priority Thread");
		PriorityThread thread2 = new PriorityThread("Normal Priority Thread");
		PriorityThread thread3 = new PriorityThread("High Priority Thread");

		// Setting priorities
		
		
		thread1.setPriority(Thread.MAX_PRIORITY);
		thread2.setPriority(Thread.MAX_PRIORITY);
		thread3.setPriority(Thread.MAX_PRIORITY);
		// Starting threads
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
}
