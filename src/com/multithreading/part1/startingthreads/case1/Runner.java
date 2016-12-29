package com.multithreading.part1.startingthreads.case1;

import com.multithreading.part1.startingthreads.Task;

/**
 * Created by andrei.tsikhamirau on 12/29/2016.
 */
public class Runner extends Thread {

    public void run() {
        new Task().perform();
    }
}
