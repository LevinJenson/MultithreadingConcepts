package com.example.levin.thread.sync;

public class SynchronisedClass {
	private String name;
	private String department;

	public SynchronisedClass(String name, String department) {
		this.name = name;
		this.department = department;
	}

	// Synchronized setter
	public synchronized void setDepartment(String department) {
		this.department = department;
		System.out.println(Thread.currentThread().getName() + " set department: " + department);
	}

	// Synchronized getter
	public synchronized String getDepartment() {
		return department;
	}

	@Override
	public  String toString() {
		return "SynchronisedClass [name=" + name + ", department=" + department + "]";
	}
}
