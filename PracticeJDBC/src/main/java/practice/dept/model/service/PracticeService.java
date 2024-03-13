package practice.dept.model.service;

import java.sql.SQLException;
import java.util.List;

import pracice.dept.model.dto.Department;
import practice.dept.exception.PracticeInsertException;

public interface PracticeService {

	List<Department> selectAll() throws SQLException;

	int insert(String deptId, String deptTitle, String locationId) throws PracticeInsertException;

	List<Department> search(String search) throws SQLException;


}
