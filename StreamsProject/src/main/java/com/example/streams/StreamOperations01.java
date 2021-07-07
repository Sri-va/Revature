package com.example.streams;

import java.util.stream.Stream;

public class StreamOperations01 {
    private static Employee[] arrayOfEmps = {
            new Employee(1, "Jeff Bezos", 100000.0),
            new Employee(2, "Bill Gates", 200000.0),
            new Employee(3, "Mark Zuckerberg", 300000.0)
        };
   
    public static void main(String[] args) {
        Stream<Employee> empStream=Stream.of(arrayOfEmps);
        //empStream.forEach(e->System.out.println(e));
        //empStream.filter((emp)->emp.getName().startsWith("B")).forEach(System.out::println);
        Stream.of(10,20,22,12,14).reduce((x,y)->x+y).ifPresent(System.out::println);
}
}
