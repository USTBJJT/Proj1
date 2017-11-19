/**
 * ATMWebService_adminSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
package ustb.edu.cn.atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ATMWebService_adminSkeleton java skeleton for the axisService
 */
public class AccountManage {

	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/mydb";
	public static final String DBUSER = "root";
	public static final String DBPASS = "root";
	public static String[] bank={"ICBC","BOC"};
	public static String[] branch={"Beijing","Shanghai"};
	

	/**
	 * Auto generated method signature
	 * 
	 * @param manageAccountRequest
	 */

	private AccountManage() {

	}

	private static volatile AccountManage instance = null;

	/*
	 */
	public static synchronized AccountManage getInstance() {
		if (instance == null)
			instance = new AccountManage();
		return instance;
	}
	
	
	/**
	 * 添加Account
	 * @param accountID
	 */
	public void insertAccount(String accountID){
		try {
			insertAccount(accountID, "123", 20000000, "100000000000000000",
							bank[0], branch[0]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean insertAccount(String accountID, String password,
			double balance, String userID, String bank, String branch)
			throws SQLException, ClassNotFoundException {
		int rsresult = 0;
		String sql;
		
		Class.forName(DBDRIVER); 

		Connection conn = null; 
		Statement stmt = null; 
		ResultSet rs = null; 
		
		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		stmt = conn.createStatement();

		sql = "SELECT Balance FROM Account WHERE AccountID=" + accountID;
		rs = stmt.executeQuery(sql);
		if (rs.next()) {

		} else {
			sql = "INSERT INTO Account (accountID,password,balance,userID,bank,branch)VALUES ('"
					+ accountID
					+ "','"
					+ password
					+ "','"
					+ balance
					+ "','" + userID + "','" + bank + "','" + branch + "')";
			rsresult = stmt.executeUpdate(sql);
			if (rsresult == 1) {
				rs.close();
				return true;
			} else {
				rs.close();
				return false;
			}
		}
		rs.close();
		return false;
	}
	
	
	private String[] convert(int relation) {
		String bankABAndBranchAB[] = new String[4];
		String bankA = null, bankB = null, branchA = null, branchB = null;
		switch (relation) {
		case 0: {
			bankA = bank[0];
			bankB = bank[0];
			branchA = branch[0];
			branchB = branch[0];
			break;
		}
		case 1: {
			bankA = bank[0];
			bankB = bank[1];
			branchA = branch[0];
			branchB = branch[0];
			break;
		}
		case 2: {
			bankA = bank[0];
			bankB = bank[0];
			branchA = branch[0];
			branchB = branch[1];
			break;
		}
		case 3: {
			bankA = bank[0];
			bankB = bank[1];
			branchA = branch[0];
			branchB = branch[1];
			break;
		}

		}
		bankABAndBranchAB[0] = bankA;
		bankABAndBranchAB[1] = bankB;
		bankABAndBranchAB[2] = branchA;
		bankABAndBranchAB[3] = branchB;

		return bankABAndBranchAB;
	}


}
