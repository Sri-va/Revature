package com.example.threads;

class ThreadTwo implements Runnable {

	 

    public void run() {
        synchronized (String.class) {
             //synchronized (Integer.class) {
            System.out.println(Thread.currentThread().getName() + " - Got lock on String.class");
            synchronized (Integer.class) {
                 //synchronized (String.class) {
                System.out.println(Thread.currentThread().getName() + " - Got lock on Integer.class");
            }
        }

 

    }
}
