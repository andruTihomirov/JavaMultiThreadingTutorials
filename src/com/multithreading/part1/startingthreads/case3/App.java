package com.multithreading.part1.startingthreads.case3;

import com.multithreading.part1.startingthreads.Task;

/**
 * Created by andrei.tsikhamirau on 12/29/2016.
 */
public class App {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                new Task().perform();
            }
        });
        thread.start();
    }
}
