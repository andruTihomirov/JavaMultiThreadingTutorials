package com.multithreading.part12.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by andrei.tsikhamirau on 1/3/2017.
 */
public class App {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i = 0; i < 200; i++) {
            executor.submit(() -> Connection.getInstance().connect());
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
