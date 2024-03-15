package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoService;
import edu.kh.todoList.model.service.TodoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/todo/update")
public class TodoUpdateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			TodoService service = new TodoServiceImpl();
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			Todo todo = service.detailTodo(todoNo);
			
			if(todo != null) {
				req.setAttribute("todo", todo);
				
				String path = "/WEB-INF/views/update.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
	
			}else { // 존재하지 않는 글 == 수정 불가
				req.getSession().setAttribute("message", "존재하지 않는 할 일 입니다.");
				resp.sendRedirect("/"); // 메인 페이지로 	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			TodoService service = new TodoServiceImpl();
			String todoTitle = req.getParameter("todoTitle");
			String todoContent = req.getParameter("todoContent");
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			int result = service.updateTodo(todoTitle, todoContent, todoNo);
			
			String path = null;
			String message = null;
			
			if(result > 0) {
				path = "/todo/detail?todoNo=" + todoNo;
				message = "수정 성공!!!";
				
			}else {
				path = "/todo/update?todoNo=" + todoNo;
				message = "수정 실패";
			}
			
			req.getSession().setAttribute("message", message);
			resp.sendRedirect(path);
			
			
			
		}catch(Exception e	) {
			e.printStackTrace();
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
