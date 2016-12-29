package com.multithreading.part1.startingthreads.case2;

/**
 * Created by andrei.tsikhamirau on 12/29/2016.
 */
public class App {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runner());
        thread1.start();
    }
}
