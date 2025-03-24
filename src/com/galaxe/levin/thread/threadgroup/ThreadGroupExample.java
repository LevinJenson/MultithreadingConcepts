package com.galaxe.levin.thread.threadgroup;

class JobDone implements Runnable {

	@Override
	public void run() {

		try {
			System.out.println("This Job is executed by - " + Thread.currentThread().getName());
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class ThreadGroupExample {

	public static void main(String[] args) {

		ThreadGroup group = new ThreadGroup("Group-Thread");

		Thread t1 = new Thread(group, new JobDone(), "Child-Thread-1");
		Thread t2 = new Thread(group, new JobDone(), "Child-Thread-2");
		Thread t3 = new Thread(group, new JobDone(), "Child-Thread-3");

		t1.start();
		t2.start();
		t3.start();


		try {
			Thread.sleep(3000);
			System.out.println("Executing the main thread");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
