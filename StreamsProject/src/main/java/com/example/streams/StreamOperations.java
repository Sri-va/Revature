package com.example.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOperations {
    public static void main(String[] args) {

 

        // build a List of strings
        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

 

        // The filter() method accepts a Predicate to filter all elements of the stream.
        // This operation is intermediate which enables us to call another stream
        // operation
        memberNames.stream().filter((s) -> s.startsWith("A"))
                // .forEach(System.out::println);
                .forEach(x -> System.out.println(x));

 

        // The map() intermediate operation converts each element in the stream into
        // another object via the given function.
        // The following example converts each string into an UPPERCASE string.
        memberNames.stream().filter((s) -> s.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);

 

        // The sorted() method is an intermediate operation that returns a sorted view
        // of the stream.
        // The elements in the stream are sorted in natural order unless we pass a
        // custom Comparator.
        memberNames.stream().sorted().map(String::toUpperCase).forEach(System.out::println);

 

        // The collect() method is used to receive elements from a steam and store them
        // in a collection.
        List<String> memNamesInUppercase = memberNames.stream().sorted().map(String::toUpperCase)
                .collect(Collectors.toList());

 

        System.out.print(memNamesInUppercase);
        System.out.println();
//The anyMatch() will return true once a condition passed as predicate satisfies. 
//Once a matching value is found, no more elements will be processed in the stream.
        boolean matched = memberNames.stream().anyMatch((s) -> s.startsWith("A"));

 

        System.out.println(matched);

 

//The findFirst() method will return the first element from the stream and then it will not process any more elements.
        String firstMatchedName = memberNames.stream().filter((s) -> s.startsWith("X")) // exception if not found
                .findFirst().get();

 

        System.out.println(firstMatchedName);
    }
}