package com.galaxe.levin.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockExample {
	private final ReentrantLock lock = new ReentrantLock();

	public void doWork() {
		lock.lock(); // Acquire the lock
		try {
			System.out.println(Thread.currentThread().getName() + " is working.");
		} finally {
			lock.unlock(); // Release the lock
			System.out.println("Unlocking the Thread - "+  Thread.currentThread().getName());
		}
	}

	public static void main(String[] args) {
		ReentrantLockExample example = new ReentrantLockExample();
		Thread t1 = new Thread(() -> {

			example.doWork();
		});
		Thread t2 = new Thread(() -> {

			example.doWork();
		});
		
		t1.start();
		t2.start();
	}
}
