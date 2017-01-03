package com.multithreading.part11.deadlock;

/**
 * Created by andrei.tsikhamirau on 1/3/2017.
 */
public class Account {

    private int balance = 10000;

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public static void transfer(Account acc1, Account acc2, int amount) {
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }

    public int getBalance() {
        return balance;
    }
}
