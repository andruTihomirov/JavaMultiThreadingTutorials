package com.multithreading.part10.reentrantlocks;

/**
 * Created by andrei.tsikhamirau on 1/3/2017.
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        final Runner runner = new Runner();

        Thread thread1 = new Thread(() -> {
            try {
                runner.firstThread();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                runner.secondThread();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finished();
    }
}
