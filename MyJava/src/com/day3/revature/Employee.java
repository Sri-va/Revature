package com.day3.revature;

public abstract class Employee {
	private int id;
	private String name,dept;
	public String getAllowances() {
		return " Allowances= Hotels";
	}
	public Employee(int id, String name, String dept) {
		this.id = id;
		this.name = name;
		this.dept = dept;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void sample() {
		System.out.println("Sample");
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + getAllowances()+ "]";
	}
	
}
