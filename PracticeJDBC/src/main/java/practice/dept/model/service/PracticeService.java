package practice.dept.model.service;

import java.sql.SQLException;
import java.util.List;

import practice.dept.exception.PracticeInsertException;
import practice.dept.model.dto.Department;

public interface PracticeService {

	List<Department> selectAll() throws SQLException;

	int insert(String deptId, String deptTitle, String locationId) throws PracticeInsertException;

	List<Department> search(String search) throws SQLException;

	int multiInsert(List<Department> deptList) throws PracticeInsertException;

	int deleteDepartment(String deptId) throws SQLException;


}
