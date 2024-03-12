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

import pracice.dept.model.dto.Department;

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
			
			result = pstmt.executeUpdate();
			
		}finally {
			pstmt.close();
		}
		
		return result;
	}



	
	
	
	
	
	
	
	
	
	
	
	

}
