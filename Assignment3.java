package com.day3.revature;

public class Assignment {

	public static int randomNumber() {
		return (int)(Math.random()*49+1);
	}
	public static float[] square(int a, int b, int c, int d) {
		float[] arr=new float[4];
		arr[0]=a*a;
		arr[1]=b*b;
		arr[2]=c*c;
		arr[3]=d*d;
		
		return arr;
	}
	public static void displayArray(int a, int b, int c, int d) {
		float arr[]=square(a,b,c,d);
		for(int i=0;i<4;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static String findFirstWord(String str1, String str2) {
		
		if(str1.compareTo(str2)>0)
			return str2;
		else
			return str1;
	}
	public static double getPi() {
		return Math.PI;
	}
	
	public static char[] getAlphabetArray(){
		char[] arr=new char[26];
		for(int i=0;i<26;i++)
			arr[i]=(char)(97+i);
		return arr;
	}
	public static void displayAlphabets() {
		char alpha[]=getAlphabetArray();
		for(int i=0;i<26;i++)
			System.out.print(alpha[i]+" ");
	}
	public static void main(String[] args) {
		System.out.println("1- "+randomNumber());
		System.out.print("2- ");
		displayArray(2,3,4,5);
		System.out.println("3- "+findFirstWord("Rip", "Soap"));
		System.out.println("4- "+getPi());
		System.out.print("5- ");
		displayAlphabets();
		
	}
}
