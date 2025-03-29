package com.example.levin.thread.learning;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Practicing {
	
	public static void main(String[] args) {
		
//		int [] nums = {2, 7, 9, 3, 1};
//		int oddEvent =0;
//		int evenEvent=0;
//				
//		for(int i =0; i< nums.length;i++) {
//			if(i%2==0) {
//				oddEvent+=nums[i];
//			}else {
//				evenEvent+=nums[i];
//			}
//		}
//		int hughestCollectedAmount = oddEvent >evenEvent ?oddEvent : evenEvent;
//		System.out.println(hughestCollectedAmount);
		int[] nums = {2, 7, 9, 3, 1};
		int answer = rob(nums);
		System.out.println(answer);
//		streams();
				
	}
	
//	nums = {5, 1, 1, 5}
	
	
	private static int rob(int[] nums) {
		
		if(nums == null || nums.length ==0)
			return 0;
		if (nums.length == 1) 
			return nums[0];
		
		int prev2 = nums[0];
		int prev1 = Math.max(nums[0], nums[1]);
		
		for (int i=2;i<nums.length;i++) {
			int current = Math.max(prev1, prev2+nums[i]);
			prev2 = prev1;
			prev1= current;
		}
				
		
		return prev1;
		
	}
	
	private static void streams() {
		List<Integer> nums = Arrays.asList(1,2,3,4,5,5,6,7,7,7);
		
//		Map<Integer, Long> result = nums.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
//        	System.out.println(result);
		
		
//		boolean isPrimeNumberfounded = nums.stream().anyMatch(this::isPrime);
		
//		List<String> strings = Arrays
//	              .asList("apple", "banana", "cherry", "date", "grapefruit");
//		
//		Optional<String> longestString = strings.stream().sorted().max(Comparator.comparingInt(String::length));
//        	
        	
        	
        	
	}

	private static  boolean isPrime(int num) {
		
		if(num <= 1)
			return false;
		
		for (int i =0; i<=Math.sqrt(num);i++) {
			if (num %i ==0) {
				return false;
			}
		}
		
		return true;
		
	}
}
