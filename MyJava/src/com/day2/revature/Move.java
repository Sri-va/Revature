package com.day2.revature;

public class Move {

	public String play(String m) {
		switch(m) {
		case "1":	return "Moving Right";
		case "2":	return "Moving Left";
		case "3":	return "Moving Up";
		case "4":	return "Moving Down";
		case "q": 	System.out.println("Exiting");
					System.exit(0);
		
		default: return "Try again";
		}
	}

}
