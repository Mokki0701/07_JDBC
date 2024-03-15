package practice.dept.model.service;

import static practice.dept.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import practice.dept.common.JDBCTemplate;
import practice.dept.exception.PracticeInsertException;
import practice.dept.model.dao.PracticeDAO;
import practice.dept.model.dao.PracticeDAOImpl;
import practice.dept.model.dto.Department;
import practice.dept.model.dto.Person;

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

	// -------------------------------------------------------------------------------
	
	@Override
	public int multiInsert(List<Department> deptList) throws PracticeInsertException {
		
		int result = 0;
		Connection conn = getConnection();
		
		try {
			for(Department dept : deptList) result += pd.insert(dept.getDeptId(), dept.getDeptTitle(), dept.getLocationId(), conn);		
			
			if(result == deptList.size()) commit(conn);
			else													rollback(conn);
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			rollback(conn);
			
			throw new PracticeInsertException("해당 부서는 이미 존재합니다.");
						
		} finally {
			close(conn);
		}
		
		
		
		return result;
	}

	// ------------------------------------------------------------------
	
	@Override
	public int deleteDepartment(String deptId) throws SQLException {
		int result = 0;
		Connection conn = getConnection();
		
		result = pd.deleteDepartment(conn, deptId);
		
		if(result > 0) commit(conn);
		else					 rollback(conn);
		
		close(conn);
		
		return result;
	}

	@Override
	public List<Person> searchEmployee(String deptId) throws SQLException {
		
		Connection conn = getConnection();
		
		List<Person> person = pd.searchEmployee(conn, deptId);
		
		close(conn);
		
		return person;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
