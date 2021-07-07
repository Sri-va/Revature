package com.day3.revature;

public class Manager {
	public static void main(String[] args) {
		SalaryEmployee se=new SalaryEmployee(1, "Sri","Java", 100000);
		System.out.println(se);
		ContractualEmployee ce=new ContractualEmployee(2, "Vatsan", "Core", 10);
		System.out.println(ce);
		ce.sample();
	}
}
