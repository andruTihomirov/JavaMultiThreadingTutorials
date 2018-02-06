package com.multithreading.part7.producerconsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by andrei.tsikhamirau on 1/2/2017.
 */
public class App {

    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                producer();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                consumer();
            } catch(InterruptedException e) {
                e.printStackTrace();
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
    }

    private static void producer() throws InterruptedException {
        Random random = new Random();
        while(true) {
            Integer value = random.nextInt(100);
            queue.put(value);
            System.out.println("Put value: " + value + "; Queue size is: " + queue.size());
        }
    }

    private static void consumer() throws InterruptedException {
        Random random = new Random();
        while(true) {
            Thread.sleep(100);
            if(random.nextInt(10) == 0) {
                Integer value = queue.take();
                System.out.println("Taken value: " + value + "; Queue size is: " + queue.size());
            }
        }
    }
}
