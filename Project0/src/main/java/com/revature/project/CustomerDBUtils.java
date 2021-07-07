package com.revature.project;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;



public class CustomerDBUtils implements Employee_CustomerDao {

	//private int user_id;
	//private String emp_name,password;
	protected double balance;
	protected String name,sex,phone,url,user,pass;
	protected Connection conn;
	private static final Logger logger=LogManager.getLogger(BankingApplication.class.getName());
	
	CustomerDBUtils() {
		FileReader file;
		try {
			file = new FileReader("src/main/resources/db.properties");
			Properties props=new Properties();
			props.load(file);
			this. url=props.getProperty("url");
			this.user=props.getProperty("user");
			this.pass=props.getProperty("password");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		try{
			
			Class.forName("org.postgresql.Driver");
			this.conn=DriverManager.getConnection(url,user,pass);
			System.out.println("Connected to Customer DB");
			
		}catch(Exception e) {
			
			logger.trace("Connection failed {}", conn);
		}
	}
	 
	
	@Override
	public int createCustomer(String name, String sex, String dob, String address, String phone, double balance) throws Exception {
		
		String query="INSERT INTO customer (name,sex,dob,address,phone,balance) VALUES (?,?,?,?,?,?)";
		
		PreparedStatement preps=this.conn.prepareStatement(query);
		preps.setString(1, name);
		preps.setString(2, sex);
		preps.setString(3, dob);
		preps.setString(4, address);
		preps.setString(5, phone);
		preps.setDouble(6, balance);
		int status = preps.executeUpdate();
		String getID="select * from customer order by id desc limit 1";
		PreparedStatement prepsid=this.conn.prepareStatement(getID);
		ResultSet res=prepsid.executeQuery();
		while(res.next())
			System.out.println("Account created. Your id is : "+res.getInt(1));
		
		//viewAccount(id);
		return status;
	}

	@Test
	@Override
	public int depositAccount(int id, double d) {
		
		double currentbalance=getBalance(id);
		boolean flag=false;
		
		
		String query="UPDATE customer SET balance = ? WHERE id = ?";
		
		try {
		
			ResultSet res=checkAccount(id);
			
			while(res.next()) {
				currentbalance= res.getDouble("balance");
				flag=true;
			}
			
			if(!flag)
				return -1;
			PreparedStatement preps=this.conn.prepareStatement(query);
			preps.setDouble(1, currentbalance+d);
			preps.setInt(2, id);
			preps.executeUpdate();
			
			
			TransactionLogs(id, "deposit");
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 1;
	}
	
	@Override
	public void depositAccount(int fromid, int toid, double d) {
		
		withdrawAccount(fromid, d);
		double currentbalance=getBalance(toid);
		String query="UPDATE customer SET balance = ? WHERE id = ?";
		
		try {
			
			PreparedStatement preps=this.conn.prepareStatement(query);
			preps.setDouble(1, currentbalance+d);
			preps.setInt(2, toid);
			preps.executeUpdate();	
			TransactionLogs(toid, "deposit");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	@Override
	public int withdrawAccount(int id, double d) {
		
		double currentbalance=getBalance(id);
		
		if(currentbalance-d <500) {
			rejectTransaction();
			return -1;
		}
		
		String query="UPDATE customer SET balance = ? WHERE id = ?";
		
		try {
			
			PreparedStatement preps=this.conn.prepareStatement(query);
			preps.setDouble(1, currentbalance-d);
			preps.setInt(2, id);
			int check=preps.executeUpdate();
			
			if(check==0)
				return -1;
			TransactionLogs(id, "withdraw");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 1;
	}
	
	public void rejectTransaction() {
		System.out.println("Rejected because of insufficient balance");
	}
	
	
	private double getBalance(int id) {
		
		ResultSet res=checkAccount(id);
		try {
			while(res.next())
				return res.getDouble("balance");
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return -1;
	}

	@Override
	public void viewAccount(int id) {

		ResultSet res=checkAccount(id);
		try {
			boolean flag=false;
			
			while(res.next()) {
				System.out.println("ID : "+res.getInt("id")+" Accountholder name:"+res.getString("name")+
						" Sex: "+res.getString("sex")+" Date of Birth: "+res.getString("dob")+" Address :"
						+res.getString("address")+" Phone number: "+res.getString("phone")+" Balance: "+
						res.getDouble("balance"));
				flag=true;
			}
			if(!flag)
				System.out.println("Incorrect id");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.fatal("Failed to fetch from db");
		}
		
	}
	
	@Override
	public void removeAccount(int i) {
		
		String query="DELETE FROM customer WHERE id = ?";
		try {
			PreparedStatement preps=this.conn.prepareStatement(query);
			preps.setInt(1, i);
			int row=preps.executeUpdate();
			if(row==0)
				System.out.println("Not found");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ResultSet checkAccount(int id) {
		String query="SELECT * FROM CUSTOMER WHERE ID ="+id;
		PreparedStatement st;
		try {
			
			st = this.conn.prepareStatement(query);
			ResultSet res=st.executeQuery();
			//System.out.println(res.getFetchSize());
			return res;
			
		} catch (SQLException e) {
			logger.fatal("Failed fetching from db");
		}
		
		return null;
	}
	

	public void TransactionLogs(int id, String type) {
		
		try {
			CallableStatement callst=this.conn.prepareCall("call customerlog(?,?)");
			callst.setInt(1, id);
			callst.setString(2, type);
			callst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void viewTransactionLogs() {
		String query="select * from transactionlogs";
		try {
			PreparedStatement preps=this.conn.prepareStatement(query);
			ResultSet res=preps.executeQuery();
			while(res.next()) {
				System.out.println("Transaction id: "+res.getInt(1)+" Account id: "+res.getInt(2)+" Timestamp: "+
			res.getTimestamp(3)+" Transaction type: "+res.getString(4)+" Account name: "+res.getString(6)+" Sex: "
						+res.getString(7)+" DOB: "+res.getString(8)+" Address: "+res.getString(9)+" Phone: "+
			res.getString(10)+" Balance: "+res.getDouble(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}	