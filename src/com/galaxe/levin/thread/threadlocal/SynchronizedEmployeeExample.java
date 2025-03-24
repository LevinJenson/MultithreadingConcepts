package com.galaxe.levin.thread.threadlocal;

public class SynchronizedEmployeeExample {
	// Shared Employee object (common for all threads)
	private static Employee employee = new Employee("Default", "HR");

	public static void main(String[] args) {
		Runnable task = () -> {
			synchronized (SynchronizedEmployeeExample.class) {
				// Update the Employee object in a synchronized block
				employee.setDepartment(Thread.currentThread().getName() + " Dept");

				System.out.println(Thread.currentThread().getName() + " updated Employee: " + employee);
			}
		};

		// Start multiple threads
		Thread thread1 = new Thread(task, "Thread-1");
		Thread thread2 = new Thread(task, "Thread-2");

		thread1.start();
		thread2.start();
	}
}
