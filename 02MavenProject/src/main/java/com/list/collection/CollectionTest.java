package com.list.collection;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionTest {
	
	public static void main(String[] args) {
		ArrayList friends = new ArrayList();
		friends.add("Abhishek");
		friends.add("Sahil");
		friends.add("Karan");
		friends.add("Rahul");
		friends.add("Jeevisha");

		Collections.sort(friends);
	}	
}
