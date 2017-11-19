package ustb.edu.cn.atm;

import java.sql.SQLException;

public class Tester {
	
	public static void main(String[] args)
	{
		ustb.edu.cn.atm.ROR_30.ConnectBank connectToBank = ustb.edu.cn.atm.ROR_30.ConnectBank.getInstance();
		try {
			double[] balance=connectToBank.transferMoney("1136899676","0102000000",2,700);
			System.out.println(balance[0]);
			System.out.println(balance[1]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
}
