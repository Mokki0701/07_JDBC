package edu.kh.todoList.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
	private static Connection conn = null;

	public static Connection getConnection() {
		
		try {
			
			if(conn == null || conn.isClosed()) {
				 
				Properties prop = new Properties();

				
				String path = JDBCTemplate.class.getResource("/board/sql/driver.xml").getPath();
				
				
				prop.loadFromXML(new FileInputStream(path));

				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String pw = prop.getProperty("pw");
				
				
				Class.forName(driver);
				
				conn = DriverManager.getConnection(url, user, pw);
				
				conn.setAutoCommit(false);
				
			}
			
		}catch(Exception e) {
			
		}
		
		
		
		
		return conn;
	}
	
	
	public static void commit(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
public static void rollback(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	

public static void close(Connection conn) {
	try {
		if(conn != null && !conn.isClosed()) conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	
	
public static void close(Statement stmt) {
	
	try {
		if(stmt != null && !stmt.isClosed()) stmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}


public static void close(ResultSet rs) {
	
	try {
		if(rs != null && !rs.isClosed()) rs.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
