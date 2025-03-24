package com.galaxe.levin.thread.priority;

class Monitor extends Thread {

	@Override
	public void run() {
//		while (!interrupted()) {
//			try {
//				System.out.println("Logging Event - " + System.currentTimeMillis());
//				sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		for(int i =0;i<20;i++) {
			System.out.println("Logging Event - " + System.currentTimeMillis());
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class DaemonThread {

	public static void main(String[] args) {
		
		Monitor daemonThread = new Monitor();
		daemonThread.setDaemon(true);
		daemonThread.start();
		
		
//		try {
//			Thread.sleep(5000);
			System.out.println("Shutting down.......");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

	}
}
