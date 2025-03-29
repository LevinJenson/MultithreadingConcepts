package com.example.levin.thread.lock;

class ReentrantExample {
    public synchronized void methodA() {
    	
        System.out.println(Thread.currentThread().getName() + " acquired lock for methodA");
        System.out.println(Thread.currentThread().getName() + " is in methodA");
        methodB();
        System.out.println(Thread.currentThread().getName() + " released lock for methodA");
        
    }

    public synchronized void methodB() {
        System.out.println(Thread.currentThread().getName() + " acquired lock for methodB");
        System.out.println(Thread.currentThread().getName() + " is in methodB");
        System.out.println(Thread.currentThread().getName() + " released lock for methodB");
    }

    public static void main(String[] args) {
    	
        ReentrantExample example = new ReentrantExample();

        Thread t1 = new Thread(() -> example.methodA(), "Thread-1");
        t1.start();
    }
}

