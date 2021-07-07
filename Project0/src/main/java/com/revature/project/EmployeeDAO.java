package com.revature.project;

public interface EmployeeDAO {

	public String login(String name, String password, EmployeeDBUtils db);
	public void create(Customer customer, CustomerDBUtils db);
	public void depositCustomer(int id, double amount, CustomerDBUtils db);
	public void depositCustomer(int fromid, int toid, double amount, CustomerDBUtils db);
	public void withdrawCustomer(int withdraw_id, double amountdraw, CustomerDBUtils db);
	public void viewCustomer(int id, CustomerDBUtils db);
	public void removeaccount(int i, CustomerDBUtils db);
	public void viewTransactionLogs(CustomerDBUtils db);
}
