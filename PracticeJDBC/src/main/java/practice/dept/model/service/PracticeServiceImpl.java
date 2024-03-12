package practice.dept.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import pracice.dept.model.dto.Department;
import practice.dept.common.JDBCTemplate;
import practice.dept.model.dao.PracticeDAO;
import practice.dept.model.dao.PracticeDAOImpl;

public class PracticeServiceImpl implements PracticeService {

	private PracticeDAO pd = new PracticeDAOImpl();
	
	@Override
	public List<Department> selectAll() throws SQLException {
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<Department> deptList = pd.selectAll(conn);
		
		conn.close();
		
		return deptList;
	}

	@Override
	public int insert(String deptId, String deptTitle, String locationId) throws SQLException {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = pd.insert(deptId, deptTitle, locationId, conn);
		
		conn.close();
		
		return result;
	}
	
	

}
