package com.list.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example1 {

	public static void main(String[] args) {
		ArrayList<Integer> arr=new ArrayList<>();
		for(int i=0;i<10;i++)
			arr.add(i+1);
		int sum=0;
		  Stream<Integer> stream = arr.stream();
	        List<Integer> evenNumbersList = stream.filter(i -> i%2 == 0)
	                                               .collect(Collectors.toList());
	        System.out.print(evenNumbersList);
	}
}
