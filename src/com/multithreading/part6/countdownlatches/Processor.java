package com.multithreading.part6.countdownlatches;

import java.util.concurrent.CountDownLatch;

/**
 * Created by andrei.tsikhamirau on 1/2/2017.
 */
public class Processor implements Runnable {

    private CountDownLatch latch;

    public Processor(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println("Started.");

        try {
            Thread.sleep(3000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        latch.countDown();
        System.out.println("Ended.");
    }
}
