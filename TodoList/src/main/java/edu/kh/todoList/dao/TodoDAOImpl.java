package edu.kh.todoList.dao;

import static edu.kh.todoList.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.todoList.model.dto.Todo;

// DAO(Data Access Object) : DB에 접근하는 객체 (SQL 수행, 결과 반환 받기)
public class TodoDAOImpl implements TodoDAO {
	
	// JDBC 객체 참조 변수 선언
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// Properties 객체
	private Properties prop = null;
	
	// 기본 생성자 로 객체 생성 시
	// Propperties 객체 생성 + xml 파일 내용 읽어오기
	public TodoDAOImpl() {
		
		try {
			prop = new Properties();
			String path = TodoDAOImpl.class.getResource("/edu/kh/todoList/sql/sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(path));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	// ----------------------------------------------------------------------

	@Override
	public List<Todo> selectAll(Connection conn) throws SQLException {
		
		List<Todo> todoList = new ArrayList<Todo>();
		
		try {
			String sql = prop.getProperty("selectAll");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Todo todo = new Todo(rs.getInt("TODO_NO"), rs.getString("TODO_TITLE"), rs.getString("COMPLETE"), rs.getString("REG_DATE"));
				
				todoList.add(todo);
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		
		return todoList;
	}
	
	// ----------------------------------------------------------------------

	@Override
	public int getCompleteCount(Connection conn) throws SQLException {
		int result = 0;
		
		try {
			String sql = prop.getProperty("completeCount");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			// -> GROUP BY가 없는 SELECT의 COUNT 그룹 함수의 결과는 1행!
			// -> if문을 이용해서 조회 결과 행 접근
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		}finally {
			close(stmt);
		}
		
		return result;
	}
	
	// ------------------------------------------------------------------------------------------

	@Override
	public int addTodo(Connection conn, String todoTitle, String todoContent) throws SQLException {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("addTodo");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, todoTitle);
			pstmt.setString(2, todoContent);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	// ------------------------------------------------------------------------

	@Override
	public Todo detailTodo(Connection conn, int todoNo) throws SQLException {
		Todo todo = null;
		
		try {
			String sql = prop.getProperty("detail");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, todoNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 조회 결과가 있어도 1행 밖에 없음 == if  사용이 효율적
				todo = new Todo();
				todo.setTodoNo(rs.getInt("TODO_NO"));
				todo.setTodoTitle(rs.getString("TODO_TITLE"));
				todo.setTodoContent(rs.getString("TODO_CONTENT"));
				todo.setComplete(rs.getString("COMPLETE"));
				todo.setRegDate(rs.getString("REG_DATE"));
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return todo;
	}
	
	// ----------------------------------------------------------------------------------------

	@Override
	public int changeComplete(Connection conn, int todoNo, String complete) throws SQLException {
		int result = 0;
		
		try {
			String sql = prop.getProperty("change");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, complete);
			pstmt.setInt(2, todoNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
	// ----------------------------------------------------------------------------------------------------

	@Override
	public int updateTodo(Connection conn, String todoTitle, String todoContent, int todoNo) throws SQLException {
		int result = 0;
		
		try {
			String sql = prop.getProperty("update");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, todoTitle);
			pstmt.setString(2, todoContent);
			pstmt.setInt(3, todoNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//s ------------------------------------------------------------------------------------------------------------------

	@Override
	public int deleteTodo(Connection conn, int todoNo) throws SQLException {
		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteTodo");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, todoNo);
			
			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
