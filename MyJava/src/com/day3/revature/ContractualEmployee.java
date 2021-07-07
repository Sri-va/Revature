package com.day3.revature;

public class ContractualEmployee extends Employee {
	private int hours;

	public ContractualEmployee(int id, String name, String dept, int hours) {
		super(id, name, dept);
		this.hours = hours;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
	public void sample() {
		super.sample();
	}
	@Override
	public String toString() {
		return super.toString()+" ContractualEmployee [hours=" + hours + "]";
	}

	@Override
	public String getAllowances() {
		// TODO Auto-generated method stub
		return super.getAllowances();
	}
	
}
