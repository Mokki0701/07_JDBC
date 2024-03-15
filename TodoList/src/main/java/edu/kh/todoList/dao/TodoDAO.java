package edu.kh.todoList.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.model.dto.Todo;

public interface TodoDAO {

	/** 할 일 목록 조회
	 * @param conn
	 * @return todoList
	 * @throws SQLException
	 */
	List<Todo> selectAll(Connection conn) throws SQLException;

	/** 완료된 할 일 개수 조회
	 * @param conn
	 * @return completeCount
	 * @throws SQLException
	 */
	int getCompleteCount(Connection conn) throws SQLException;

	/**
	 * @param conn
	 * @param todoTitle
	 * @param todoContent
	 * @return result
	 * @throws SQLException
	 */
	int addTodo(Connection conn, String todoTitle, String todoContent) throws SQLException;

	/**
	 * @param conn
	 * @param todoNo
	 * @return todoList
	 * @throws SQLException
	 */
	Todo detailTodo(Connection conn, int todoNo) throws SQLException;

	/**
	 * @param conn
	 * @param todoNo
	 * @param complete
	 * @return result
	 * @throws SQLException
	 */
	int changeComplete(Connection conn, int todoNo, String complete) throws SQLException;

	
	/**
	 * @param conn
	 * @param todoTitle
	 * @param todoContent
	 * @return result
	 * @throws SQLException
	 */
	int updateTodo(Connection conn, String todoTitle, String todoContent, int todoNo) throws SQLException;

	
	/**
	 * @param conn
	 * @param todoNo
	 * @return result
	 * @throws SQLException
	 */
	int deleteTodo(Connection conn, int todoNo) throws SQLException;
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
