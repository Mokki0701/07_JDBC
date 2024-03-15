package practice.dept.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import practice.dept.model.dto.Department;
import practice.dept.model.dto.Person;

public class PracticeDAOImpl implements PracticeDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public PracticeDAOImpl() {
	
		try {

			prop = new Properties();
			
			String path = PracticeDAOImpl.class.getResource("/practice/dept/sql/sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(path));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	// ------------------------------------------------------------------------------
	
	@Override
	public List<Department> selectAll(Connection conn) throws SQLException {
		
		List<Department> deptList = new ArrayList<Department>();
		
		try {
			
			String sql = prop.getProperty("selectAll");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql); 
			
			while(rs.next()) {
				
				String deptId = rs.getString("DEPT_ID");
				String deptTitle = rs.getString("DEPT_TITLE");
				String locationId = rs.getString("LOCATION_ID");
				
				Department dept = new Department(deptId, deptTitle, locationId);
				
				deptList.add(dept);
			}
			
		} finally {
			
			rs.close();
			stmt.close();	
		}
		
		return deptList;
	}

	// -------------------------------------------------------------------------------
	
	@Override
	public int insert(String deptId, String deptTitle, String locationId, Connection conn) throws SQLException {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("insert");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, deptId);
			pstmt.setString(2, deptTitle);
			pstmt.setString(3, locationId);
			
			result = pstmt.executeUpdate(); // 여기서 PRIMARY KEY에 의한 무결성 제약 조건 발생
			
		}finally {
			pstmt.close();
		}
		
		return result;
	}

	// --------------------------------------------------------------------------------------

	
	@Override
	public List<Department> search(String search, Connection conn) throws SQLException {

		List<Department> deptList = new ArrayList<Department>();
		
		try {
			String sql = prop.getProperty("search");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, search);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String deptId = rs.getString("DEPT_ID");
				String deptTitle = rs.getString("DEPT_TITLE");
				String locationId = rs.getString("LOCATION_ID");
				
				Department dept = new Department(deptId, deptTitle, locationId);
				
				System.out.println(dept.toString());
				
				deptList.add(dept);
				
			}
		}finally {
			rs.close();
			pstmt.close();
		}
	
		return deptList;
	}

	@Override
	public int deleteDepartment(Connection conn, String deptId) throws SQLException {
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("delete");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, deptId);
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			pstmt.close();
			
		}
		
		return result;
	}
	
	// --------------------------------------------------------------------------------

	@Override
	public List<Person> searchEmployee(Connection conn, String deptId) throws SQLException {
		
		List<Person> person = new ArrayList<Person>();
		
		try {
			
			String sql = prop.getProperty("employee");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, deptId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Person ps = new Person(rs.getString("EMP_ID"), rs.getString("EMP_NAME"), rs.getString("PHONE"), rs.getString("DEPT_TITLE"), rs.getString("LOCATION_ID"));
				person.add(ps);
				
				System.out.println(ps.toString());
				
			}
			
			
		}finally {
			rs.close();
			pstmt.close();
		}
		
		return person;
	}

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	
	
	
	
	
	
	
	
	
	
	
	

}
