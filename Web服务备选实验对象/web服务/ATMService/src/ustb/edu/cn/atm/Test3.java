package ustb.edu.cn.atm;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test3 {

	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/mydb";
	public static final String DBUSER = "root";
	public static final String DBPASS = "root";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<String> list=new ArrayList<String>();
		list.add("bbbb");
		list.add("jghkj");
		list.add("jhgjh");
		list.add(0, "ttt");
		System.out.println(list.get(0)+list.get(1)+list.size());
		
		try {
			Class c=Class.forName("ustb.edu.cn.atm.ConnectBank");
			Constructor constructor = c.getDeclaredConstructor(new Class[] {  });
			constructor.setAccessible(true);
			Object o = constructor.newInstance(new Object[] { });

			Method testMethod = c.getMethod("transferMoney",new Class[]{Class.forName("java.lang.String"),Class.forName("java.lang.String"),int.class,int.class});
			double[] balance=(double[]) testMethod.invoke(o,"1136899676","2000000000",2,500);
			System.out.println(balance[0]);
			System.out.println(balance[1]);
			
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		/*Test3 test = new Test3();
		test.genTC(20);
		List listS = test.getTCSromDB("transfer");
		test.printS(listS);*/

	}
	
	
	public List getTCSromDB(String tableName){
		List listAllS=new ArrayList();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName(DBDRIVER);
			con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			stmt = con.createStatement();
			
			// 打印数据库中的所有数据
			String sqlstr = "select * from " + tableName;
			rs = stmt.executeQuery(sqlstr);
			// session.removeAttribute("transferinputset");//vector中的属性清空。
			ResultSetMetaData rsmd = rs.getMetaData();// 获取元数据
			int j = 0;
			j = rsmd.getColumnCount();// 获得结果集的行数
			for (int k = 0; k < j; k++) {
				System.out.print(rsmd.getColumnName(k + 1));
				System.out.print("\t");
			}
			System.out.print("\n");
			while (rs.next()) {
				for (int i = 0; i < j; i++) {
					System.out.print(rs.getString(i + 1));
					System.out.print("\t");
				}
				System.out.print("\n");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listAllS;
		
	}
	
	public void printS(List<List> listAll){
		for (List list : listAll){
			int id = Integer.parseInt((String) list.get(0));
			int mrID = Integer.parseInt((String) list.get(1));
			String accountFrom = (String) list.get(2);
			String accountTo = (String) list.get(3);
			
			String mode = (String) list.get(4);
			String amount = (String) list.get(5);
			
			System.out.println(id+"   "+mrID+"   "+accountFrom+"   "+accountTo+"    "+mode+"    "+amount );
			
		}
	}

	public void genTC(int m) {

		List listAll_S = new ArrayList();// Source
		List listAll_F = new ArrayList();// FollowUp
		for (int i = 0; i < m; i++) {
			// 原始测试用例
			List list_S = new ArrayList();
			List list_F = new ArrayList();

			// Source
			//MR1
			list_S=genTCS_MR1(i+1);
			
			listAll_S.add(list_S);

			list_F = getFollowUp_MR1(list_S);
			// Follow Up
			// String
			// amount_F=randomInt(amount,String.valueOf((Integer.parseInt(amount)+100)));
			//			
			// list_F.add(id);
			// list_F.add(mrID);
			// list_F.add(accountFrom);
			// list_F.add(accountTo);
			// list_F.add(mode);
			// list_F.add(amount_F);
			listAll_F.add(list_F);

			/*
			 * System.out.println("accountFrom:"+accountFrom);
			 * System.out.println("accountTo:"+accountTo);
			 * System.out.println("mode:"+mode);
			 * System.out.println("amount:"+amount);
			 */

		}

		insertDB(listAll_S, "transfer");
		insertDB(listAll_F, "transferF");

	}

	/**
	 * 随机获得10位数
	 * 
	 * @return
	 */
	public String genTenInt() {
		int a[] = new int[10];
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (10 * (Math.random()));
			str.append(a[i]);
		}

		return String.valueOf(str.toString());

	}

	/**
	 * 随机获得模式
	 * 
	 * @return
	 */
	public String genMode() {
		Random ran = new Random();
		int temp = ran.nextInt(4);
		return String.valueOf(temp);
	}

	/**
	 * 获得amount
	 * 
	 * @return
	 */
	public String genAmount() {
		int a = (int) (50 * (Math.random()));
		return String.valueOf(a * 100);

	}

	public void insertDB(List<List> listAll, String tableName) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName(DBDRIVER);
			con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			stmt = con.createStatement();
			String sqlDel = "truncate table mydb." + tableName;
			stmt.executeUpdate(sqlDel);
			String sqlstr1 = "";
			for (List list : listAll) {
				int id = Integer.parseInt((String) list.get(0));
				int mrID = Integer.parseInt((String) list.get(1));
				String accountFrom = (String) list.get(2);
				String accountTo = (String) list.get(3);
				
				String mode = (String) list.get(4);
				String amount = (String) list.get(5);
				// System.out.println(id);
				if (tableName.equals("transfer")) {
					sqlstr1 = "INSERT INTO "
							+ tableName
							+ "(ID,mrID,accountFrom,accountTo,amount,mode)values("
							+ id + "," + mrID + ",'" + accountFrom + "','"
							+ accountTo + "','" + amount + "','" + mode + "')";
				} else if (tableName.equals("transferF")) {
					sqlstr1 = "INSERT INTO "
							+ tableName
							+ "(sID,mrID,accountFrom,accountTo,amount,mode)values("
							+ id + "," + mrID + ",'" + accountFrom + "','"
							+ accountTo + "','" + amount + "','" + mode + "')";
				}
				System.out.println("sql:" + sqlstr1);
				// 执行更新
				stmt.executeUpdate(sqlstr1);

			}
			// 打印数据库中的所有数据
			String sqlstr = "select * from " + tableName;
			rs = stmt.executeQuery(sqlstr);
			// session.removeAttribute("transferinputset");//vector中的属性清空。
			ResultSetMetaData rsmd = rs.getMetaData();// 获取元数据
			int j = 0;
			j = rsmd.getColumnCount();// 获得结果集的行数
			//打印字段名
			for (int k = 0; k < j; k++) {
				System.out.print(rsmd.getColumnName(k + 1));
				System.out.print("\t");
			}
			System.out.print("\n");
			while (rs.next()) {
				List listS=new ArrayList();
				for (int i = 0; i < j; i++) {
					System.out.print(rs.getString(i + 1));
					listS.add(rs.getString(i + 1));
					System.out.print("\t");
				}
				System.out.print("\n");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 随机产生一个在min和max之间的float数
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	@SuppressWarnings("unused")
	private String randomInt(String min, String max) {
		float minflo = Float.parseFloat(min);
		float maxflo = Float.parseFloat(max);
		if (minflo > maxflo) {
			return null;
		} else {
			Random rand = new Random();
			float flo = minflo + rand.nextFloat() * (maxflo - minflo);
			// System.out.println(String.valueOf(flo));
			return String.valueOf(flo);
		}
	}
	
	/**
	 * 得到原始测试用例
	 */
	public List genTCS_MR1(int i) {
		List listS= new ArrayList();
		
		// Source
		String id = String.valueOf(i);
		String mrID = "1";
		String accountFrom = genTenInt();
		String accountTo = genTenInt();
		String mode = genMode();
		String amount = genAmount();
		listS.add(id);
		listS.add(mrID);
		listS.add(accountFrom);
		listS.add(accountTo);
		listS.add(mode);
		listS.add(amount);
		
		return listS;
	}

	/**
	 * 得到衍生测试用例 MR1 M’=2M ∆A’<=2∆A 且 ∆B’=2∆B
	 * 
	 * @param list
	 * @return
	 */
	public List getFollowUp_MR1(List list) {
		List listF = new ArrayList();

		String id = (String) list.get(0);
		String mrID = (String) list.get(1);
		String accountFrom = (String) list.get(2);
		String accountTo = (String) list.get(3);
		;
		String mode = (String) list.get(4);
		String amount = (String) list.get(5);

		String amount_F = String.valueOf((Integer.parseInt(amount) * 2));

		listF.add(id);
		listF.add(mrID);
		listF.add(accountFrom);
		listF.add(accountTo);
		listF.add(mode);
		listF.add(amount_F);

		return listF;
	}


	/**
	 * 得到原始测试用例
	 */
	public List genTCS_MR2(int i) {
		List listS= new ArrayList();
		
		// Source
		String id = String.valueOf(i);
		String mrID = "2";
		String accountFrom = genTenInt();
		String accountTo = genTenInt();
		String mode = "1";
		String amount = genAmount();
		listS.add(id);
		listS.add(mrID);
		listS.add(accountFrom);
		listS.add(accountTo);
		listS.add(mode);
		listS.add(amount);
		
		return listS;
	}

	/**
	 * 得到衍生测试用例 MR2
	 *  P = 1且P’ = 2 ∆A’- ∆B’ = ∆A - ∆B
	 * 
	 * @param list
	 * @return
	 */
	public List getFollowUp_MR2(List list) {
		List listF = new ArrayList();

		String id = (String) list.get(0);
		String mrID = (String) list.get(1);
		String accountFrom = (String) list.get(2);
		String accountTo = (String) list.get(3);
		;
		String mode = (String) list.get(4);
		String amount = (String) list.get(5);

		String amount_F = "2";

		listF.add(id);
		listF.add(mrID);
		listF.add(accountFrom);
		listF.add(accountTo);
		listF.add(mode);
		listF.add(amount_F);

		return listF;
	}

}
