package com.galaxe.levin.thread;

class ThreadEx implements Runnable{

	@Override
	public void run() {
		System.out.println("This is the Thread call "+ Thread.currentThread().getName());
		
	}
	
}

public class RunnableExample{

	public static void main(String[] args) throws InterruptedException {
		
	    Thread t1 = new Thread(new ThreadEx());
	    t1.start();
	    t1.join();
		System.out.println("Thread Ends");
	}
}
