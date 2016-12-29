package com.multithreading.part4.multiplelocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by andrei.tsikhamirau on 12/29/2016.
 */
public class Worker {

    private Random random = new Random();

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<Integer>();
    private List<Integer> list2 = new ArrayList<Integer>();

    public void stageOne() {
        perform(list1, lock1);
    }

    public void stageTwo() {
        perform(list2, lock2);
    }

    public void process() {
        for(int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public void work() {
        System.out.println("Starting...");
        long start = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                process();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                process();
            }
        });
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("Time take: " + (end - start));
        System.out.println("List1: " + list1.size() + "; List2: " + list2.size());
    }

    private void perform(List<Integer> list, Object lock) {
        synchronized(lock) {
            try {
                Thread.sleep(1);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            list.add(random.nextInt(100));
        }
    }
}
