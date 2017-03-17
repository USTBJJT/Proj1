package cn.edu.ustb.mt4ws.tcg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.xmlbeans.SchemaType;

import cn.edu.ustb.mt4ws.mr.model.RelationOfInput;

public class SqlUtils {

	private volatile static SqlUtils instance = null;

	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/mydb";
	public static final String DBUSER = "root";
	public static final String DBPASS = "root";

	private Connection conn = null;

	private Statement stmt = null;

	private SqlUtils() {
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Singleton模式
	 * 
	 * @return
	 */
	public static SqlUtils getInstance() {
		if (instance == null) {
			synchronized (SqlUtils.class) {
				if (instance == null)
					instance = new SqlUtils();
			}
		}
		return instance;
	}

	/**
	 * 根据operation的名称生成MySQL数据表
	 * 
	 * @param opFormat
	 */
	public void createTableByOperation(Map<String, WsdlOperationFormat> opFormat) {
		Set<Map.Entry<String, WsdlOperationFormat>> entry = opFormat.entrySet();
		Iterator<Map.Entry<String, WsdlOperationFormat>> iter = entry
				.iterator();
		Map.Entry<String, WsdlOperationFormat> myentry = null;
		StringBuffer createTableSQL = null;
		while (iter.hasNext()) {
			myentry = iter.next();
			createTableSQL = new StringBuffer();
			/*
			 * 根据operationName建表
			 */
			createTableSQL.append("CREATE TABLE " + myentry.getKey() + " (");
			/*
			 * 所有simple type作为表的列
			 */
			Set<Map.Entry<String, SchemaType>> entryInput = myentry.getValue()
					.getInput().format.getSimpleTypes().entrySet();
			Iterator<Map.Entry<String, SchemaType>> iterInput = entryInput
					.iterator();
			Map.Entry<String, SchemaType> myentryInput = null;
			createTableSQL
					.append("id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,");
			createTableSQL.append("mrID INT,");
			while (iterInput.hasNext()) {
				myentryInput = iterInput.next();
				createTableSQL.append(myentryInput.getKey() + " ").append(
						checkTypeForSQL(myentryInput.getValue()));
				if (iterInput.hasNext())
					createTableSQL.append(",");
			}
			/*
			 * 所有simple type 作为表的列
			 */
			// entryInput =
			// myentry.getValue().getInput().format.getSimpleTypes()
			// .entrySet();
			// iterInput = entryInput.iterator();
			// myentryInput = null;
			// while (iterInput.hasNext()) {
			// myentryInput = iterInput.next();
			// createTableSQL.append(myentryInput.getKey() + " ").append(
			// checkTypeForSQL(myentryInput.getValue()));
			// if (iterInput.hasNext())
			// createTableSQL.append(",");
			// }

			createTableSQL.append(");");
			// System.out.println("&&&&&&&&");
			// System.out.println(createTableSQL.toString());
			try {
				System.out.println("**********" + createTableSQL);
				stmt.execute(createTableSQL.toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 向数据库插入一个随机生成的TC
	 * 
	 * @param operationName
	 *            在哪个operation上产生test case
	 * @param format
	 *            operation的输入输出格式
	 * @return true成功,false失败
	 */
	public boolean insertRandomTC(String operationName,
			WsdlOperationFormat opFormat) {
		XmlTestCaseGenerator tcGen = new XmlTestCaseGenerator();
		XmlTestCase tc = tcGen.genWithRandomValue(operationName, opFormat);
		String sqlInsert = tcGen.convertToSQLStatement(tc);
		try {
			return stmt.execute(sqlInsert);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 向数据库插入一个有特殊要求的test case
	 * 
	 * @param operationName
	 *            在哪个operation上产生test case
	 * @param opFormat
	 *            operation的输入输出格式
	 * @param relationOfInput
	 *            某个MR的relation of input元素
	 * @return true成功,false失败
	 */
	public boolean insertLimitedTC(String operationName,
			WsdlOperationFormat opFormat, RelationOfInput relationOfInput,
			int mrID) {
		XmlTestCaseGenerator tcGen = new XmlTestCaseGenerator();
		XmlTestCase tc = tcGen.genWithLimitation(operationName, opFormat
				.getInput().format, relationOfInput, mrID);
		String sqlInsert = tcGen.convertToSQLStatement(tc);
		try {
			return stmt.execute(sqlInsert);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getValueFromDB(String operationName, String colName, int id)
			throws Exception {
		String sql = "SELECT " + colName + " FROM " + operationName
				+ " WHERE id=" + id + ";";
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next())
			return rs.getObject(colName).toString();
		else
			return null;
	}

	public List<Integer> searchTCForMR(String operationName, int mrID)
			throws SQLException {
		List<Integer> result = new ArrayList<Integer>();
		String searchSQL = "SELECT id FROM " + operationName + " WHERE mrID="
				+ mrID + ";";
		ResultSet rs = stmt.executeQuery(searchSQL);
		while (rs.next()) {
			result.add(rs.getInt("id"));
		}
		return result;
	}

	private String checkTypeForSQL(SchemaType type) {
		String SQLType = "";
		switch (type.getPrimitiveType().getBuiltinTypeCode()) {
		case SchemaType.BTC_DATE_TIME: {
			SQLType = "";
			break;
		}
		case SchemaType.BTC_TIME: {
			SQLType = "";
			break;
		}
		case SchemaType.BTC_DATE: {
			SQLType = "";
			break;
		}
		case SchemaType.BTC_G_YEAR_MONTH: {
			SQLType = "";
			break;
		}
		case SchemaType.BTC_G_YEAR: {
			SQLType = "";
			break;
		}
		case SchemaType.BTC_G_MONTH_DAY: {
			SQLType = "";
			break;
		}
		case SchemaType.BTC_G_DAY: {
			SQLType = "";
			break;
		}
		case SchemaType.BTC_G_MONTH: {
			SQLType = "";
			break;
		}

		case SchemaType.BTC_NOT_BUILTIN:
			return "";

		case SchemaType.BTC_ANY_TYPE:
		case SchemaType.BTC_ANY_SIMPLE:

		case SchemaType.BTC_BOOLEAN:

		case SchemaType.BTC_BASE_64_BINARY: {
		}

		case SchemaType.BTC_HEX_BINARY:

		case SchemaType.BTC_ANY_URI:

		case SchemaType.BTC_QNAME:

		case SchemaType.BTC_NOTATION:

		case SchemaType.BTC_FLOAT:
			SQLType = "FLOAT";
			break;
		case SchemaType.BTC_DOUBLE:
			SQLType = "DOUBLE";
			break;
		case SchemaType.BTC_DECIMAL:
			switch (new XmlTcgUtils().closestBuiltin(type).getBuiltinTypeCode()) {
			case SchemaType.BTC_SHORT:
			case SchemaType.BTC_UNSIGNED_SHORT:
			case SchemaType.BTC_BYTE:
			case SchemaType.BTC_UNSIGNED_BYTE:
			case SchemaType.BTC_INT:
				SQLType = "INT";
				break;
			case SchemaType.BTC_UNSIGNED_INT:
			case SchemaType.BTC_LONG:
			case SchemaType.BTC_UNSIGNED_LONG:
			case SchemaType.BTC_INTEGER:
			case SchemaType.BTC_NON_POSITIVE_INTEGER:
			case SchemaType.BTC_NEGATIVE_INTEGER:
			case SchemaType.BTC_NON_NEGATIVE_INTEGER:
			case SchemaType.BTC_POSITIVE_INTEGER:
			case SchemaType.BTC_DECIMAL:
			}

		case SchemaType.BTC_STRING: {
			switch (new XmlTcgUtils().closestBuiltin(type).getBuiltinTypeCode()) {
			case SchemaType.BTC_STRING:
				SQLType = "VARCHAR(20)";
				break;
			case SchemaType.BTC_NORMALIZED_STRING:
				break;

			case SchemaType.BTC_TOKEN:
				break;
			}
		}

		case SchemaType.BTC_DURATION:

		}
		return SQLType;

	}

	public AccountManager getAccountManager() {
		return new AccountManager();
	}

	public void closeConnection() throws SQLException {
		stmt.close();
		conn.close();
	}

	// 以下函数是为了ATM实验方便
	public class AccountManager {

		String[] bank = { "ICBC", "BOC" };
		String[] branch = { "Beijing", "Shanghai" };

		public void accountTtoDB(String tableName, int testcaseID)
				throws SQLException, ClassNotFoundException {

			String sql;
			ResultSet rs = null;
			sql = "SELECT * FROM " + tableName + " WHERE id=" + testcaseID;// TODO确定数据表的列名称
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				String accountA = rs.getString("AccountFrom");
				String accountB = rs.getString("AccountTo");
				int relation = rs.getInt("mode");

				String[] bankABAndBranchAB = convert(relation);
				String bankA = bankABAndBranchAB[0];
				String bankB = bankABAndBranchAB[1];
				String branchA = bankABAndBranchAB[2];
				String branchB = bankABAndBranchAB[3];
				insertAccount(accountA, "123", 20000000, "100000000000000000",
						bankA, branchA);
				insertAccount(accountB, "123", 20000000, "100000000000000000",
						bankB, branchB);
			}
		}

		public void testRubbishDisposal(String tableName, int testcaseID)
				throws SQLException, ClassNotFoundException {
			String sql;
			ResultSet rs = null;
			sql = "SELECT * FROM " + tableName + " WHERE id=" + testcaseID;// TODO确定数据表的列名称
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				String accountA = rs.getString("AccountFrom");
				String accountB = rs.getString("AccountTo");
				deleteAccount(accountA);
				deleteAccount(accountB);
			}
		}

		private boolean insertAccount(String accountID, String password,
				double balance, String userID, String bank, String branch)
				throws SQLException, ClassNotFoundException {
			int rsresult = 0;

			String sql;

			ResultSet rs = null;

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

		private boolean deleteAccount(String accountID) throws SQLException,
				ClassNotFoundException {

			int rsresult = 0;
			String sql;
			ResultSet rs = null;

			sql = "SELECT Balance FROM Account WHERE AccountID=" + accountID;
			rs = stmt.executeQuery(sql);
			if (!rs.next()) {
			} else {
				sql = "DELETE FROM Account WHERE AccountID=" + accountID;
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

}
