package com.example.streams;

import java.util.stream.Stream;

public class CreateStream02 {
    private static Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
        };
   
    public static void main(String[] args) {
        Stream<Employee> empStream=Stream.of(arrayOfEmps);
        empStream.forEach(e->System.out.println(e));
       
       
       
       
    }
}
