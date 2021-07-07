package com.example.threads;

class ThreadOne implements Runnable {



	   public void run() {
	       synchronized (Integer.class) {
	           System.out.println(Thread.currentThread().getName() + " - Got lock on Integer.class");



	           synchronized (String.class) {
	               System.out.println(Thread.currentThread().getName() + " - Got lock on String.class");
	           }
	       }
	   }
	}