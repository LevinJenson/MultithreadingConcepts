package com.example.levin.thread.atomicvariables;

class Counter {
    private  int count = 0;

    public void increment() {
        count++;  // Not thread-safe
    }

    public int getCount() {
        return count;
    }
}

public class WithoutAutomicVariable {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // Output will vary due to race conditions
        System.out.println("Final Count: " + counter.getCount());
    }
}
