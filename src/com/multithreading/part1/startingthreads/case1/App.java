package com.multithreading.part1.startingthreads.case1;

/**
 * Created by andrei.tsikhamirau on 12/29/2016.
 */
public class App {

    public static void main(String[] args) {
        Runner runner1 = new Runner();
        runner1.start();

        Runner runner2 = new Runner();
        runner2.start();
    }
}
