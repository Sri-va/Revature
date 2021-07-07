package com.day3.revature;

public class SalaryEmployee extends Employee implements Taxes{
	 double salary;
	 public SalaryEmployee(int id, String name, String dept,double salary) {
		 super(id,name,dept);
		 this.salary=salary;
	 }
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return super.toString()+"SalaryEmployee [salary=" + salary + getTaxes() + "]";
	}
	@Override
	public String getTaxes() {
		// TODO Auto-generated method stub
		return "Taxes= 10%";
		
	}


}
