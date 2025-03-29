package com.example.levin.thread.concurrency.completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class suppyAsyncDemo {

	public List<String> getAllEmployeeDetails() throws InterruptedException, ExecutionException {
		CompletableFuture<List<String>> employeesList = CompletableFuture.supplyAsync(() -> {
			System.out.println("Thread Name " + Thread.currentThread().getName());
			return EmployeeDetails.fetchEmployees();

		});
		return employeesList.get();

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		suppyAsyncDemo demo = new suppyAsyncDemo();
		List<String> employees = demo.getAllEmployeeDetails();
		employees.stream().forEach(System.out::println);
	}
}
