package practice.dept.model.service;

import static practice.dept.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import pracice.dept.model.dto.Department;
import practice.dept.common.JDBCTemplate;
import practice.dept.exception.PracticeInsertException;
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
	
	// ------------------------------------------------------------------------------

	@Override
	public int insert(String deptId, String deptTitle, String locationId) throws PracticeInsertException {
		
		int result = 0;
		
		Connection conn = JDBCTemplate.getConnection();
		
		try {
			result = pd.insert(deptId, deptTitle, locationId, conn);
			
			if(result > 0) JDBCTemplate.commit(conn);
			else					 JDBCTemplate.rollback(conn);
						
		} catch(SQLException e) {
			e.printStackTrace();
			
			JDBCTemplate.rollback(conn);
			throw new PracticeInsertException();
		}finally {
			close(conn);
		}
		
		return result;
	}

	// ------------------------------------------------------------------------------
	
	@Override
	public List<Department> search(String search) throws SQLException {
	
		Connection conn = JDBCTemplate.getConnection();
		
		List<Department> deptList = pd.search(search, conn);
		
		conn.close();
		
		return deptList;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
