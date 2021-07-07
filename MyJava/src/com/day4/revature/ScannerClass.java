package com.day4.revature;

import java.util.Scanner;

public class ScannerClass {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int num1=scan.nextInt();
		int num2=scan.nextInt();
		System.out.println(num1/num2);
		scan.close();
	}
}
