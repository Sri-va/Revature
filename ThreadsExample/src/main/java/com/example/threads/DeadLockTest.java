package com.example.threads;

public class DeadLockTest {
    public static void main(String[] args) {
        new Thread(new ThreadOne(), "ThreadOne").start();
        new Thread(new ThreadTwo(), "ThreadTwo").start();
    }
}


