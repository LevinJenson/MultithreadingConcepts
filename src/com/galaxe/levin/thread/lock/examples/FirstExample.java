package com.galaxe.levin.thread.lock.examples;

import java.util.List;

import com.galaxe.levin.thread.concurrency.completablefuture.EmployeeDetails;

import java.util.Arrays;

public class FirstExample {

    public static void main(String[] args) {
    	
    	
    	
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Character> letters = Arrays.asList('A', 'B', 'C', 'D', 'E');

        Object lockingObject = new Object();

        Thread numberThread = new Thread(() -> {
            for (Integer number : numbers) {
                synchronized (lockingObject) {
                    System.out.print(number + ", ");
                    try {
                    	lockingObject.notify(); 
                    	lockingObject.wait();  
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread letterThread = new Thread(() -> {
            for (Character letter : letters) {
                synchronized (lockingObject) {
                    System.out.print(letter + ", "); 
                    try {
                    	lockingObject.notify();
                    	lockingObject.wait(); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        numberThread.start();
        letterThread.start();

        try {
            numberThread.join();
            letterThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

