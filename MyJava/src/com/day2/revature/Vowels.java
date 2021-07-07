package com.day2.revature;

public class Vowels {

	public int countVowels(String str) {
		int count=0;
		for(int i=0;i<str.length();i++) {
			switch(str.charAt(i)) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					count++;
					break;
			}
		}
		return count;	
	}

}
