package com.example.levin.thread.volatileExample;

class Counter {
    private volatile boolean running = true;  // Declare as volatile

    public void stop() {
        running = false;  // Thread 2 updates this value
    }

    public void run() {
        while (running) {  // Thread 1 sees the updated value
            System.out.println("It is running");
        }
        System.out.println("Stopped!");
    }
}

public class VolatileExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(counter::run);
        thread1.start();

        Thread.sleep(1000);  // Allow thread1 to start and run

        Thread thread2 = new Thread(counter::stop);
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

