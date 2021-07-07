package com.revature.project;


import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class BankingApplication {
	
	private static final Logger logger=LogManager.getLogger(BankingApplication.class);
	
	public static void main(String[] args) {
		
		System.out.println("Enter your choice");
		Scanner scan=new Scanner(System.in);
		int n=0;
		
		while(n!=3) {
			
			Customer c;
			System.out.println("1. Employee 2. Customer 3.Exit");
			n=scan.nextInt();
			
			switch(n) {
			
			case 1: 
				{
					System.out.println("Employee");
					logger.info("Entering db");
					CustomerDBUtils db=new CustomerDBUtils();
					int ch=0;
					Employee emp=null;
					while(ch!=5) {
						System.out.println("--------------------------------------------------------------------------------");
						System.out.println("1.Login 2. View user account details 3. Transaction logs 4.Remove account 5.Exit");
						ch=scan.nextInt();						
						switch(ch) {
						
						case 1:
							
							EmployeeDBUtils empdb=new EmployeeDBUtils();
							System.out.println("Enter username");
							String user=scan.next();
							System.out.println("Enter password");
							String password=scan.next();
							System.out.println(empdb.checkLogin(user,password));
							emp=new Employee(user, password);
							//System.out.println(e.login("Sri", "Sri13"));
							break;
							
						case 2:
							
							if(emp==null) {
								System.out.println("Login first...");
								break;
							}
							System.out.println("Enter your id");
							int id=scan.nextInt();
							emp.viewCustomer(id, db);
							break;
							
						case 3:
							
							if(emp==null) {
								System.out.println("Login first...");
								break;
							}
							//e.viewTransactionLogs(db);
							emp.viewTransactionLogs(db);
							break;
							
							
						case 4:
							
							if(emp==null) {
								System.out.println("Login first...");
								break;
							}
							System.out.println("Enter your id");
							int getid=scan.nextInt();
							emp.removeaccount(getid, db);
							break;
							
						case 5:
							break;
						}
					}
					break;
				}
			case 2: Employee e=new Employee("Sri", "Sri123");
					System.out.println("--------------------------------------------------------------------------------");
					System.out.println("Customer");
					logger.info("Entering db");
					CustomerDBUtils db=new CustomerDBUtils();
					int x=0;
					
					while(x!=6) {
						
						System.out.println("1.Create 2. View account details 3. Deposit 4.Deposit to another account 5.Withdraw 6.Exit");
						x=scan.nextInt();
						switch(x) {
						
						case 1:
							
							System.out.println("Enter your name");
							scan.nextLine();
							String name=scan.nextLine();
							System.out.println("Enter your sex");
							String sex=scan.nextLine();
							System.out.println("Enter your dob");
							String dob=scan.nextLine();
							System.out.println("Enter your address");
							String address=scan.nextLine();
							System.out.println("Enter your phonenum");
							String phonenum=scan.nextLine();
							System.out.println("Minimum balance to be maintained : Rs 500");
							System.out.println("Enter the amount");
							double balance=scan.nextDouble();
							c=new Customer(name, sex, dob, address, phonenum, balance);
							e.create(c, db);
							break;
							
						case 2:
							
							System.out.println("Enter your id");
							int id=scan.nextInt();
							db.viewAccount(id);
							break;
							
						case 3:
							
							System.out.println("Enter your id");
							int deposit_id=scan.nextInt();
							System.out.println("Enter the amount");
							double d=scan.nextDouble();
							e.depositCustomer(deposit_id, d, db);
							break;
							
						case 4:
							
							System.out.println("Enter your id");
							int fromid=scan.nextInt();
							System.out.println("Enter the amount");
							int amount=scan.nextInt();
							System.out.println("Enter the id to be transferred");
							int toid=scan.nextInt();
							e.depositCustomer(fromid, toid, amount, db);
							break;
							
						case 5:
							
							System.out.println("Enter your id");
							int withdraw_id=scan.nextInt();
							System.out.println("Enter the amount");
							double withdraw_amount=scan.nextDouble();
							e.withdrawCustomer(withdraw_id, withdraw_amount, db);
							break;
							
						case 6:
							break;
						}
						
					}
			break;
			
			case 3:
				logger.info("Exitng");
				scan.close();
				System.exit(0);
			}
		}
	}


}
