package com.multithreading.part5.threadpools;

/**
 * Created by andrei.tsikhamirau on 12/29/2016.
 */
public class Processor implements Runnable {

    private int id;

    public Processor(int id) {
        this.id = id;
    }

    public void run() {
        System.out.println("Starting: " + id);

        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed: " + id);
    }

}
