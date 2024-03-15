package practice.dept.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import practice.dept.model.dto.Department;
import practice.dept.model.dto.Person;

public interface PracticeDAO {

	List<Department> selectAll(Connection conn) throws SQLException;


	int insert(String deptId, String deptTitle, String locationId, Connection conn) throws SQLException;


	List<Department> search(String search, Connection conn) throws SQLException;


	int deleteDepartment(Connection conn, String deptId) throws SQLException;


	List<Person> searchEmployee(Connection conn, String deptId) throws SQLException;




}
