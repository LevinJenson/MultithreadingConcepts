package com.galaxe.levin.thread.learning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsLearn {
	public static void main(String[] args) {

//		Example :1: Find the maximum value in the List<Integer>.
		List<Integer> intValues = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 6);
		Optional<Integer> maxvalue = intValues.stream().max(Integer::compareTo);
		System.out.println(maxvalue.get());

//		Example: 2: Find employee with higest salary.
		List<Staff> employees = Arrays.asList(new Staff("John", 50000), new Staff("Jane", 60000),
				new Staff("Mark", 55000), new Staff("Sophia", 75000), new Staff("Alex", 40000));

		Optional<Staff> staff = employees.stream().max(Comparator.comparingDouble(Staff::getSalary));
		System.out.println(staff.get());

//		Example:3: Given List<String>, Return String concatenating all Strings of List.

		List<String> words = Arrays.asList("apple", "banana", "cherry");
		String concatinatedString = words.stream().collect(Collectors.joining(","));
		System.out.println(concatinatedString);

//		Example:4: Group List<Integer> by their evenness. (even or odd)

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		Map<Boolean, List<Integer>> out = numbers.stream().collect(Collectors.groupingBy(n -> n % 2 == 0));
		System.out.println(out);
		
		
//		Example:5:  Given List<Employee>, Group them by Designation.
		
		List<Staff> staffs = Arrays.asList(
	            new Staff("Alice", "Developer"),
	            new Staff("Bob", "Manager"),
	            new Staff("Charlie", "Developer"),
	            new Staff("David", "Manager"),
	            new Staff("Eve", "Designer")
	        );

		Map<String, List<Staff>> output = staffs.stream().collect(Collectors.groupingBy(Staff::getDesignition));
				
		System.out.println(output);
		
//		Example:6:  Given List<String>, Count the number of Strings that have length greater than 4
		
		List<String> wordss = Arrays.asList("apple", "banana", "kiwi", "cherry");
		long count = wordss.stream().filter(value -> value.length() > 4)
				.count();
		System.out.println(count);
		
		
//		Example:7: Sort a List<String> in reverse alphabetical order.
		List<String> sortedWords = wordss.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(sortedWords);
		
//		Example:8: Check if all elements in a List<Integer> are positive.
		
		boolean isPositive = numbers.stream().allMatch(n -> n>0);
		System.out.println(isPositive);
		
//		Example:9: How to sort List<Employee> by salary
		List<Staff> sortedEmployees= employees.stream().sorted(Comparator.comparing(Staff::getSalary).reversed()).toList();
		System.out.println(sortedEmployees);
	}

}
