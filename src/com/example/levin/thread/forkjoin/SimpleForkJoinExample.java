package com.example.levin.thread.forkjoin;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class SimpleForkJoinExample {

	// A task that calculates the sum of an array
	static class SumTask extends RecursiveTask<Integer> {
		private int[] numbers; // The array
		private int start; // Starting index
		private int end; // Ending index

		// Constructor
		public SumTask(int[] numbers, int start, int end) {
			this.numbers = numbers;
			this.start = start;
			this.end = end;
		}

		@Override
		protected Integer compute() {
			// If the task size is small enough, calculate the sum directly
			if (end - start <= 5) { // Base case: small tasks
				int sum = 0;
				for (int i = start; i < end; i++) {
					sum += numbers[i];
				}
				System.out.println("Call came to if block " + Thread.currentThread().getName());
				return sum;
			} else {
				System.out.println("Call came to else block "+  Thread.currentThread().getName());
				// Split the task into two smaller tasks
				int mid = (start + end) / 2;
				SumTask leftTask = new SumTask(numbers, start, mid);
				System.out.println("Sperated the left part " + Thread.currentThread().getName());
				SumTask rightTask = new SumTask(numbers, mid, end);

				// Fork the left task to execute it in parallel
				leftTask.fork();

				// Compute the right task and join the left task's result
				int rightResult = rightTask.compute();
				int leftResult = leftTask.join();

				// Combine the results
				return leftResult + rightResult;
			}
		}
	}

	public static void main(String[] args) {
		// Create an array of numbers
		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// Create a ForkJoinPool
		ForkJoinPool pool = new ForkJoinPool();

		// Create a task to calculate the sum of the array
		SumTask task = new SumTask(numbers, 0, numbers.length);

		// Submit the task to the ForkJoinPool and get the result
		int result = pool.invoke(task);

		// Print the result
		System.out.println("Sum of the array: " + result);
	}
}
