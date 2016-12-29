package com.multithreading.part2.basicthreadsynchronization;

import java.util.Scanner;

/**
 * Created by andrei.tsikhamirau on 12/29/2016.
 */
public class App {

    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.start();

        System.out.println("Press return to stop...");
        Scanner scanner = new Scanner(System.in);

         scanner.nextLine();

        processor.shutdown();
    }
}
