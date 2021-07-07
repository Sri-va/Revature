package com.list.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class CollectionSet {

	public static void main(String[] args) {
		HashSet<String> hs=new HashSet<>();
		TreeSet<String> ts=new TreeSet<>();
		LinkedHashSet<String> lhs=new LinkedHashSet<>();
		
		hs.add("hi");
		hs.add("hello");
		ts.add("hi");
		ts.add("hello");
		lhs.add("hello");
		lhs.add("hell");
		System.out.println(hs);
		System.out.println(ts);
		System.out.println(lhs);
	}
}
