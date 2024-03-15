package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.service.TodoService;
import edu.kh.todoList.model.service.TodoServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/changeComplete")
public class TodoChangeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			int result = 0;
			TodoService service = new TodoServiceImpl();
			
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));  // 이거는 String으로 받아도 되긴 하는데 그럼 Oracle에서 자동으로 변환해줘서 가능한거임 그럼 한줄 더생겨서 느려짐
			String complete = req.getParameter("complete");
			
			result = service.changeComplete(todoNo, complete);
			
			String message = null;
			if(result > 0) message = "변경 성공!!!";
			else					 message = "변경 실패...";
			
			req.getSession().setAttribute("message", message);
			resp.sendRedirect("/todo/detail?todoNo="+todoNo);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
}
