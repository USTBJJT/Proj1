package cn.edu.ustb.cbwstc.Experiment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 针对有数据库读写的服务，需要在每个测试脚本执行前，将数据库恢复到初始情况
 * @author Administrator
 *
 */
public class InitExperiment {
	
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
	public static final String DBURL = "jdbc:mysql://127.0.0.1:3306/ustbone?useUnicode=true&characterEncoding=utf8";
	public static final String DBUSER = "root";
	public static final String DBPASS = "root";
	
	public void init() {
		try {
			Class.forName(DBDRIVER);
			Connection conn = null; 
			Statement stmt = null;
			try {
				conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
				stmt = conn.createStatement();
				String sql = "delete from park";
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
		    {
				if(stmt!= null)
					try {
						stmt.close();
						stmt = null;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			     if(conn!= null)
					try {
						conn.close();
						conn = null;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			  }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
