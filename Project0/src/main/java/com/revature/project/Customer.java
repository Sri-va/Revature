package com.revature.project;



import org.junit.jupiter.api.Tag;

@Tag("Custom")
public class Customer{
	
	public String name,sex,phone,address,dob;
	protected double balance;
	private int id;
	
	public Customer(String name, String sex, String dob, String address, String phonenum, double balance) {
		this.name = name;
		this.sex = sex;
		this.address=address;
		this.dob=dob;
		this.balance = balance;
		this.phone=phonenum;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setId(int i) {		
		this.id=i;
	}
	
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

		

}