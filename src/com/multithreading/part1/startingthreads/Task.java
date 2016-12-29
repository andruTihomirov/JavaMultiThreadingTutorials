package com.multithreading.part1.startingthreads;

/**
 * Created by andrei.tsikhamirau on 12/29/2016.
 */
public class Task {

    public void perform() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Hello " + i);
            try {
                Thread.sleep(100);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
