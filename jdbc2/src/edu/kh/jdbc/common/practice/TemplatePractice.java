package edu.kh.jdbc.common.practice;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class TemplatePractice {

	private static Connection conn = null;
	
	public static Connection getConnection() {
		
		try {
			
			if(conn == null || conn.isClosed()) {
				
				Properties prop = new Properties();
				// Properties
				// String 형태의 맵
				
				prop.loadFromXML(new FileInputStream("driver.xml"));
				
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
	
	
	
	
	
	
	
	
	
	
}
