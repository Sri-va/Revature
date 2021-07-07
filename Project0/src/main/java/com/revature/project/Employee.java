package com.revature.project;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.jupiter.api.Tag;

@Tag("Employ")
public class Employee implements EmployeeDAO{

	protected String name,password;
	private static final Logger logger=LogManager.getLogger(Employee.class.getName());
	public Employee(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	


	@Test
	@Override
	public void create(Customer customer, CustomerDBUtils db) {
			try {

			//System.out.println(customer.name+" "+customer.sex+" "+customer.phone+" "+customer.balance);
			db.createCustomer(customer.name, customer.sex, customer.dob, customer.address, customer.phone, customer.balance);
			}catch(Exception e) {
				logger.entry();
				logger.error("Error caught at creating");
			}	
	}

	@Override
	public String login(String name, String password, EmployeeDBUtils db) {
		// TODO Auto-generated method stub
		//return DBUtils.checkLogin();
		if(this.name.equals(name) && this.password.equals(password))
			return "Login successful";
		
		return "Incorrect credentials";
	}

	@Override
	public void viewCustomer(int id, CustomerDBUtils db) {
		
		db.viewAccount(id);
	}

	@Override
	public void removeaccount(int i, CustomerDBUtils db) {
		
		db.removeAccount(i);
	}

	@Override
	public void depositCustomer(int id, double amount, CustomerDBUtils db) {
		
		if(db.depositAccount(id, amount)!=-1) {
	
			System.out.println("Amount deposited : "+ amount);
			viewCustomer(id, db);
		}
		
		
	}
	
	@Override
	public void depositCustomer(int fromid, int toid, double amount, CustomerDBUtils db) {
		
		//db.depositAccount(fromid, toid, amount);
		if(db.withdrawAccount(fromid, amount)!=-1 && db.depositAccount(toid, amount) !=-1)
			db.viewAccount(fromid);
		
	}

	@Override
	public void withdrawCustomer(int withdraw_id, double amountdraw, CustomerDBUtils db) {
		
		if(db.withdrawAccount(withdraw_id, amountdraw)!=-1) {
			System.out.println("Amount withdrawn : "+ amountdraw);
			db.viewAccount(withdraw_id);
		}
	}

	@Override
	public void viewTransactionLogs(CustomerDBUtils db) {
		
		db.viewTransactionLogs();
	}
	
	
	
}
