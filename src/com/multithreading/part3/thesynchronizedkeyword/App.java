package com.multithreading.part3.thesynchronizedkeyword;

/**
 * Created by andrei.tsikhamirau on 12/29/2016.
 */
public class App {

    private volatile int count = 0;

    public static void main(String[] args) {
        new App().doWork();
    }

    public void doWork() {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                perform();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                perform();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is: " + count);
    }

    private synchronized void increment() {
        count++;
    }

    private void perform() {
        for(int i = 0; i < 10000; i++) {
            increment();
        }
    }
}
