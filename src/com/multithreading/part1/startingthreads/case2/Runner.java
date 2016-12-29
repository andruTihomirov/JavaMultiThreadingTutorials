package com.multithreading.part1.startingthreads.case2;

import com.multithreading.part1.startingthreads.Task;

/**
 * Created by andrei.tsikhamirau on 12/29/2016.
 */
public class Runner implements Runnable {

    public void run() {
        new Task().perform();
    }
}
