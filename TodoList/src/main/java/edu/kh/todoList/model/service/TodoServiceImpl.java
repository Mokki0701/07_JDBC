package edu.kh.todoList.model.service;

import static edu.kh.todoList.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.dao.TodoDAO;
import edu.kh.todoList.dao.TodoDAOImpl;
import edu.kh.todoList.model.dto.Todo;

// Service : 비즈니스 로직 처리
// - 데이터 가공, 트랜잭션 제어 처리
public class TodoServiceImpl implements TodoService {
	
	private TodoDAO dao = null;
	
	// 기본 생성자 가장 우선순위
	public TodoServiceImpl() {
		dao = new TodoDAOImpl();
	}

	@Override
	public Map<String, Object> selectAll() throws SQLException {
		
		Connection conn = getConnection();
		
		// 2. 할 일 목록 조회 DAO 메서드 호출 후 결과 반환 받기
		List<Todo> todoList = dao.selectAll(conn); 
		
		// 3. 완료된 할 일 개수 조회 DAO 메서드 호출 후 결과 반환 받기
		int completeCount = dao.getCompleteCount(conn);
		
		// 4. Connection 반환
		close(conn);
		
		// 5. Map을 생성해서 DAO 호출 결광를 한 번에 묶어서 반환
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("todoList", todoList);
		map.put("completeCount", completeCount);
		
		return map;
	}

	@Override
	public int addTodo(String todoTitle, String todoContent) throws SQLException {
		
		Connection conn = getConnection();
		
		int result = dao.addTodo(conn, todoTitle, todoContent);
		
		if(result > 0) commit(conn);
		else					 rollback(conn);
		
		close(conn);
		
		return result;
	}

	
	
	@Override
	public Todo detailTodo(int todoNo) throws SQLException {
			
		Connection conn = getConnection();
		
		Todo todo = dao.detailTodo(conn, todoNo);
		
		close(conn);
		
		return todo;
	}

	@Override
	public int changeComplete(int todoNo, String complete) throws SQLException {
		
		Connection conn = getConnection();
		int result = dao.changeComplete(conn, todoNo, complete);
		
		if(result > 0) commit(conn);
		else					 rollback(conn);
		
		close(conn);
		
		return result;
	}
	

	@Override
	public int updateTodo(String todoTitle, String todoContent, int todoNo) throws SQLException {
		int result = 0;
		Connection conn = getConnection();
		
		result = dao.updateTodo(conn, todoTitle, todoContent, todoNo);
		
		if(result > 0) commit(conn);
		else					 rollback(conn);
		
		close(conn);
		
		return result;
	}

	
	
	@Override
	public int deleteTodo(int todoNo) throws SQLException {
		int result = 0;
		
		Connection conn = getConnection();
		
		result = dao.deleteTodo(conn, todoNo);
		
		if(result > 0) commit(conn);
		else					 rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
