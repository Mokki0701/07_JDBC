package edu.kh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample3 {
	
	public static void main(String[] args) {
		
	  // 입력 받은 최소 급여 보다 많이 받고(이상)
		// 입력 받은 최고 급여보단 적게 받는(이하)
		// 사원의  사번, 이름, 급여를 급여 내림차순 조회
		
		// [실행화면]
		// 최소 급여 : 1000000
		// 최대 급여 : 3000000
			
		// (사번) / (이름) / (급여)
		// (사번) / (이름) / (급여)
		// (사번) / (이름) / (급여)
		
		
		// 1. 일단 객체들 생성
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			// 2-1. 기본 그거 만들기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2-2) DB 연결 정보를 이용해 Connection
			String type     = "jdbc:oracle:thin:@"; // 드라이버 종류
			String host     = "localhost"; // DB 서버 컴퓨터의 IP 주소
			String port     = ":1521"; // DB 서버 컴퓨터에 DB 프로그램 연결 번호
			String dbName   = ":xe"; // DB 이름
			String userName = "KH_JSW"; // 사용자 계정
			String pw 		  = "KH1234"; // 계정 비밀번호
			
			// 3. 연결하기
			conn = DriverManager.getConnection(type + host + port + dbName, userName, pw);
			
			// 4. sql문 생성
			
			Scanner sc = new Scanner(System.in);
			System.out.print("최소 급여를 입력하세요 : ");
			int input1 = sc.nextInt();
			
			System.out.print("최대 급여를 입력하세요 : ");
			int input2 = sc.nextInt();
			
			String sql = "SELECT EMP_ID , EMP_NAME , SALARY \r\n"
					+ "FROM EMPLOYEE\r\n"
					+ "WHERE SALARY BETWEEN " + input1 + " AND " + input2
					+ " ORDER BY SALARY DESC";
			
			stmt = conn.createStatement();
			
			// 5. stmt 객체 생성
			rs = stmt.executeQuery(sql);
			
			// 6. 컬럼 값 얻어오기
			while(rs.next()) {
				
				String empID = rs.getString("EMP_ID");
				String empName = rs.getString("EMP_NAME");
				int salary = rs.getInt("SALARY");
				
				System.out.printf("%s / %s / %d \n", empID, empName, salary );
				
			}
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				if( rs != null)	rs.close();
				if( stmt != null) stmt.close();
				if( conn != null) conn.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
