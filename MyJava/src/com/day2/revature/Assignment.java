package com.day2.revature;

import java.util.Scanner;

public class Assignment {
  
	public static void main(String[] args) {
		int i=0;
		System.out.println("Odd numbers");
		do {
			if(i%2==1)
				System.out.print(i+" ");
		i++;
		}while(i<50);
		System.out.println();
		System.out.println("Alphabets");
		int j=0;
		do {
				System.out.print((char)(j+97)+" ");
		j++;
		}while(j<26);
		System.out.println();
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the nth factorial");
		int n=scan.nextInt();
		System.out.println("n Factorial : "+new Factorial().factorial(5));
		System.out.println("Enter the text");
		scan.nextLine();
		String str=scan.nextLine();
		System.out.println("Number of Vowels : "+new Vowels().countVowels(str));
		while(true) {
			System.out.println("Different statements based on user's input");
			String m=scan.nextLine();
			System.out.println(new Move().play(m));
			}
		
	}
}
