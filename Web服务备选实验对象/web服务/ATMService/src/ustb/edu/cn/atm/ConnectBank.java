package ustb.edu.cn.atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConnectBank {
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/mydb";
	public static final String DBUSER = "root";
	public static final String DBPASS = "root";
	public static String[] bank = { "ICBC", "BOC" };
	public static String[] branch = { "Beijing", "Shanghai" };

	public final int maxWithdrawAmount_Once = 2000;

	public final int maxWithdrawAmount_OneDay = 5000;

	public final int maxTransferAmount_Once = 5000;

	public final int maxTransferAmount_OneDay = 10000;

	public final double rate0 = 0.005;

	public final double rate1 = 0.005;

	public final double rate2 = 0.01;

	private ConnectBank() {
	};

	private static volatile ConnectBank instance = null;

	/*
	 * Singleton
	 */
	public static ConnectBank getInstance() {
		if (instance == null)
			instance = new ConnectBank();
		return instance;
	}

	/**
	 * 添加Account
	 * 
	 * @param accountID
	 */
	public void insertAccount(String accountID) {
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
					+ "','"
					+ userID + "','" + bank + "','" + branch + "')";
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

	public synchronized double[] transferMoney(String from, String to,
			int mode, int money) throws SQLException, ClassNotFoundException {
		double amount, commission_charge;

		double[] result = new double[2];
		amount = (double) money;

		if (amount > maxTransferAmount_Once) {
			return null;
		}

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs_from = null;
		ResultSet rs_to = null;

		Class.forName(DBDRIVER);

		conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		stmt = conn.createStatement();

		ResultSet rs_balance_A_before = null, rs_balance_B_before = null, rs_balance_A_after = null, rs_balance_B_after = null;
		String sql = "SELECT Balance FROM Account WHERE AccountID=" + from;
		rs_balance_A_before = stmt.executeQuery(sql);

		// 判断balance_A_before是否存在
		if (!rs_balance_A_before.next()) {
			insertAccount(from);
			rs_balance_A_before = stmt.executeQuery(sql);
			rs_balance_A_before.next();
		}

		double balance_A_before = rs_balance_A_before.getDouble("Balance");
		sql = "SELECT Balance FROM Account WHERE AccountID=" + to;
		rs_balance_B_before = stmt.executeQuery(sql);
		// 判断balance_B_before是否存在
		if (!rs_balance_B_before.next()) {
			insertAccount(to);
			rs_balance_B_before = stmt.executeQuery(sql);
			rs_balance_B_before.next();
		}

		double balance_B_before = rs_balance_B_before.getDouble("Balance");
		sql = "SELECT Bank,Branch FROM Account WHERE AccountID=" + from;

		rs_from = stmt.executeQuery(sql);
		sql = "SELECT Bank,Branch FROM Account WHERE AccountID=" + to;
		rs_from.next();

		rs_to = stmt.executeQuery(sql);

		rs_to.next();

		if (mode == 3) {
			commission_charge = (double) (amount * rate2);
		} else if (mode == 2) {
			commission_charge = (double) (amount * rate1);
		} else if (mode == 1) {
			commission_charge = (double) (amount * rate0);
		} else

			commission_charge = 0;

		if (mode != 0) {
			if (commission_charge >= 1 && commission_charge <= 50)
				;
			else if(Math.abs(commission_charge-0)<0.000001){
				commission_charge=0;
			}
			else if (commission_charge < 1)
				commission_charge = 1;
			else 
				commission_charge = 50;
			
		}
	
		try {

			sql = "UPDATE Account SET Balance=Balance-" + amount + "-"
					+ commission_charge + " WHERE AccountID=" + from;
			int result1 = stmt.executeUpdate(sql);
			sql = "UPDATE Account SET Balance=Balance+" + amount
					+ " WHERE AccountID=" + to;
			int result2 = stmt.executeUpdate(sql);

			sql = "SELECT Balance FROM Account WHERE AccountID=" + from;
			rs_balance_A_after = stmt.executeQuery(sql);
			rs_balance_A_after.next();
			double balance_A_after = rs_balance_A_after.getDouble("Balance");

			sql = "SELECT Balance FROM Account WHERE AccountID=" + to;
			rs_balance_B_after = stmt.executeQuery(sql);
			rs_balance_B_after.next();
			double balance_B_after = rs_balance_B_after.getDouble("Balance");

			result[0] = (balance_A_before - balance_A_after);
			result[1] = (balance_B_after - balance_B_before);

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (Exception ex) {
			}
		}

		rs_from.close();
		rs_to.close();
		stmt.close();
		rs_balance_A_before.close();
		rs_balance_A_after.close();
		rs_balance_B_after.close();
		rs_balance_B_before.close();
		conn.close();
		return result;

	}

};