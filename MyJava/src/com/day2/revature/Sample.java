package com.day2.revature;

import java.util.Scanner;

public class Sample {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		
		switch(n) {
		case 1:
			System.out.print("enter s1");
			String str1=scan.nextLine();
			
			System.out.println("enter s2");
			String str2=scan.nextLine();
//			System.out.println("enter s3");
//			String str3=scan.nextLine();
//			System.out.print("enter s4");
//			String str4=scan.nextLine();
			scan.nextLine();
			System.out.print("enter int");
			int i=scan.nextInt();
			System.out.println(str1+" "+str2+" "+" "+i);
		}
		
	}
}
