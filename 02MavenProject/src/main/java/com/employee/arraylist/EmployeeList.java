package com.employee.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeList{
	public static void main(String[] args) {
		/*ArrayList<Employee> emplist=new ArrayList<>();
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		for(int i=0;i<n;i++) {
			int id=scan.nextInt();
			scan.nextLine();
			String name=scan.nextLine();
			double salary=scan.nextDouble();
			emplist.add(i,new Employee(id,name,salary));
		}
		for(int i=0;i<n;i++) {
			System.out.println(emplist.get(i).toString());
		}
		scan.close();*/
		Employee emp1=new Employee(1, "Sriva", 100000);
		Employee emp2=new Employee(1, "Sriva", 100000);
		if(emp1.equals(emp2) && emp1.hashCode()==emp2.hashCode())
			System.out.print("Yes");
	}
}
