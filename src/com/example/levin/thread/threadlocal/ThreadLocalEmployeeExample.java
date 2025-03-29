package com.example.levin.thread.threadlocal;

public class ThreadLocalEmployeeExample {
	
	private static ThreadLocal<Employee> threadLocalEmployee = ThreadLocal
			.withInitial(() -> new Employee("Default", "HR"));
	
//	Employee employeeOld = new Employee("Default", "HR");

	public static void main(String[] args) {
		Runnable task = () -> {
			// Each thread gets its own Employee instance
			Employee employee = threadLocalEmployee.get();
			employee.setDepartment(Thread.currentThread().getName() + " Dept");

			System.out.println(Thread.currentThread().getName() + " updated Employee: " + employee);

			// Remove the Employee instance to avoid memory leaks
			threadLocalEmployee.remove();
		};

		// Start multiple threads
		Thread thread1 = new Thread(task, "Thread-1");
		Thread thread2 = new Thread(task, "Thread-2");

		thread1.start();
		thread2.start();
	}
}
