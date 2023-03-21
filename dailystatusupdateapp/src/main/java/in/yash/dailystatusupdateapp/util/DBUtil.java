package in.yash.dailystatusupdateapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * DBUtil class is used for creating DB related operations like getting
 * connection, preparedStatment, releasing resources etc
 * 
 * @author USER
 *
 */
public class DBUtil {
	// Gather DB info:

	String url="jdbc:mysql://localhost/taskdb";
	String user="pandurang";
	String password="0912";
	// Load Driver and create connection:

	private String driverClassName = "com.mysql.cj.jdbc.Driver";
	private Connection conn = null;
	private PreparedStatement ps = null;

	/**
	 * connect() method is a helper method to create a preparedStatement with the
	 * help of connection object
	 * 
	 * @return conn
	 */
	private Connection connect() {
		try {
			Class c = Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return conn;

	}
	
	// Create prepared Statement using conneection:
	/**
	 * this method is used to create a preparedStatement using connect()
	 * @param sql is a query to execute.
	 * @return preparedStatment.
	 */
		public PreparedStatement prepareStatement(String sql) {
				try {
					ps=	connect().prepareStatement(sql);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			
			
			return ps;
			
		}

/**
 * This method is used to close the resources		
 */
		// 6. close Resources:
	public void closePrepareStatement() {
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
