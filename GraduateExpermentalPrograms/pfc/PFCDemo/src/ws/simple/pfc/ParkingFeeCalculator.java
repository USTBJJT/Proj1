package ws.simple.pfc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParkingFeeCalculator {
	
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	public static final String DBURL = "jdbc:mysql://127.0.0.1:3306/ustbone?useUnicode=true&characterEncoding=utf8";
	public static final String DBUSER = "root";
	public static final String DBPASS = "root";
	private static String regEx = "[B][J][A-Y][0-9]{5}";
	
	public boolean login(String License, int loginTime) throws SQLException, ClassNotFoundException, IOException {
		Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(License);
        boolean rs = m.matches();
		if(rs && (loginTime>=0 && loginTime<=24)) {
			Class.forName(DBDRIVER);
			Connection conn = null; 
			Statement stmt = null; 
			ResultSet rss = null;
			int rsresult = 0;
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			stmt = conn.createStatement();
			String sql = "SELECT id FROM park WHERE id=" + "\"" + License + "\"";
			rss = stmt.executeQuery(sql);
			if (rss.next()) {
				throw new java.sql.SQLException("Already logged in");
			} else {
				sql = "INSERT INTO park (id,time)VALUES ('"
						+ License
						+ "','"
						+ loginTime
						+ "')";
				rsresult = stmt.executeUpdate(sql);
				if (rsresult == 1) {
					rss.close();
					return true;
				} else {
					rss.close();
					throw new java.sql.SQLException("Logon failure");
				}
			}
		}else {
			throw new java.io.IOException("Invalid data");
		}
	}
	
	public double feeCalculate(String License,int type,int timeout,boolean dayOfWeek,boolean discountCoupon) throws SQLException, ClassNotFoundException, IOException {
		double parkfee = 0;
		Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(License);
        boolean rs = m.matches();
		if(rs && (type ==0 || type ==1 || type==2) && (timeout>=0 && timeout<=24)) {
			Class.forName(DBDRIVER);
			Connection conn = null; 
			Statement stmt = null; 
			ResultSet rss = null;
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
			stmt = conn.createStatement();
			String sql = "SELECT time FROM park WHERE id=" + "\"" + License + "\"";
			rss = stmt.executeQuery(sql);
			if (rss.next()) {
				int time = rss.getInt(1);
				if(timeout<time) {
					throw new java.io.IOException("Logout time is less than login time");
				}else {
					int apd = timeout - time;
					if(apd == 0) {
						apd = 1;
					}
					if(dayOfWeek) {
						if(type ==0) {
							if(apd <=2) {
								parkfee = apd * 4;
							}else if(apd>2 && apd<=4) {
								parkfee = 2 * 4 + (apd- 2) * 5;
							}else {
								parkfee = 2 * 4 + 2 * 5 + (apd-4) * 6;
							}
						}else if(type == 1) {
							if(apd <=2) {
								parkfee = apd * 4.5;
							}else if(apd>2 && apd<=4) {
								parkfee = 2 * 4.5 + (apd- 2) * 5.5;
							}else {
								parkfee = 2 * 4.5 + 2 * 5.5 + (apd-4) * 6.5;
							}
						}else {
							if(apd <=2) {
								parkfee = apd * 5;
							}else if(apd>2 && apd<=4) {
								parkfee = 2 * 5 + (apd- 2) * 6;
							}else {
								parkfee = 2 * 5 + 2 * 6 + (apd-4) * 7;
							}
						}
					}else {
						if(type ==0) {
							if(apd <=2) {
								parkfee = apd * 5;
							}else if(apd>2 && apd<=4) {
								parkfee = 2 * 5 + (apd- 2) * 6.5;
							}else {
								parkfee = 2 * 5 + 2 * 6.5 + (apd- 4) * 8;
							}
						}else if(type == 1) {
							if(apd <=2) {
								parkfee = apd * 6;
							}else if(apd>2 && apd<=4) {
								parkfee = 2 * 6 + (apd - 2) * 7.5;
							}else {
								parkfee = 2 * 6 + 2 * 7.5 +(apd - 4) * 9;
							}
						}else {
							if(apd <=2) {
								parkfee = apd * 7;
							}else if(apd>2 && apd<=4) {
								parkfee = 2 * 7 + (apd - 2) * 8.5;
							}else {
								parkfee = 2 * 7 + 2 * 8.5 +(apd - 4) * 10;
							}
						}
					}
					if(discountCoupon) {
						parkfee = parkfee* 0.5;
					}
					sql = "DELETE FROM park WHERE id=" + "\"" + License + "\"";
					stmt.executeUpdate(sql);
					conn.close();
				}
			}else {
				throw new java.sql.SQLException("Not logged in");
			}
		}else{
			throw new java.io.IOException("Invalid data");
		}
		return parkfee;
	}

}
