package com.lambdaexpression;

public class RunnableLambdaTest {
    public static void main(String[] args) {
        
          Runnable r2 = () -> {   // lambda expression
             System.out.println("Runnable with Lambda Expression");
          };
        
          new Thread(r2).start();
       }
}
