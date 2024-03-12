package practice.dept.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import pracice.dept.model.dto.Department;

public interface PracticeDAO {

	List<Department> selectAll(Connection conn) throws SQLException;


	int insert(String deptId, String deptTitle, String locationId, Connection conn) throws SQLException;

}
