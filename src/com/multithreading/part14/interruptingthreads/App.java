package com.multithreading.part14.interruptingthreads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by andrei.tsikhamirau on 1/4/2017.
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting ....");

        ExecutorService executor = Executors.newCachedThreadPool();

        Future<?> future = executor.submit(new Callable<Object>() {
            public Void call() throws Exception {
                Random random = new Random();
                for(int i = 0; i < 1E8; i++) {
                    if(Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted!");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }
                return null;
            }
        });

        executor.shutdown();

        Thread.sleep(500);
        executor.shutdownNow();

        future.cancel(true);

        executor.awaitTermination(1, TimeUnit.DAYS);

        System.out.println("Finished.");
    }
}
