package com.multithreading.part9.lowlevelsynchronization;

/**
 * Created by andrei.tsikhamirau on 1/2/2017.
 */
public class App {

    public static void main(String[] args) throws InterruptedException {

        final Processor processor = new Processor();

        Thread thread1 = new Thread(() -> {
            try {
                processor.produce();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                processor.consume();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }
}
