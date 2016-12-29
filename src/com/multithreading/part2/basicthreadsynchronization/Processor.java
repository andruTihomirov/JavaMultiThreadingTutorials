package com.multithreading.part2.basicthreadsynchronization;

/**
 * Created by andrei.tsikhamirau on 12/29/2016.
 */
public class Processor extends Thread {

    private volatile boolean running = true;

    public void run() {
        while(running) {
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }

}
