
package com.example.levin.thread.concurrency.completablefuture;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDetails {

	public static List<String> fetchEmployees() {
		List<String> list = new ArrayList<>();
		try {
			Thread.sleep(10000);
			list.add("Ramu");
			list.add("Somu");
			list.add("vinay");
			list.add("Ragu");
			list.add("Alex");
			list.add("Starlin");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return list;
	}
}
