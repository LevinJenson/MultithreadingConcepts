package com.example.levin.thread;

class ThreadExample extends Thread {
	@Override
	public void run() {
		
		for(int i=0;i<20;i++) {
			System.out.println("Thread is running: " + Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

public class MyThread {
	public static void main(String[] args) {

		
		System.out.println(Thread.currentThread().getName());
		
		ThreadExample t = new ThreadExample();

		
		t.start();

		System.out.println("Main thread: " + Thread.currentThread().getName());
	}
}
