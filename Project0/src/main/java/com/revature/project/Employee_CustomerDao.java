package com.revature.project;



public interface Employee_CustomerDao {

	public int createCustomer(String name, String sex, String dpb, String address, String phone, double balance) throws Exception;
	public int depositAccount(int id, double d);
	public void depositAccount(int fromid, int toid, double d);
	public int withdrawAccount(int id, double d);
	public void removeAccount(int i);
	public void viewAccount(int id);
}
