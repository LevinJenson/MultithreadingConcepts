package com.galaxe.levin.thread;

public class MutualRecursionExample {
    public static void methodA() {
        methodB(); // Calls methodB
    }

    public static void methodB() {
        methodA(); // Calls methodA
    }

    public static void main(String[] args) {
        methodA(); 
    }
}



