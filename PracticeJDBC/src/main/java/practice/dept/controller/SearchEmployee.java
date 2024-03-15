package practice.dept.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import practice.dept.model.dto.Person;
import practice.dept.model.service.PracticeService;
import practice.dept.model.service.PracticeServiceImpl;

@WebServlet("/deaprtment/employee")
public class SearchEmployee extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String deptId = req.getParameter("employee");
			PracticeService ps = new PracticeServiceImpl();
			
			List<Person> person = new ArrayList<Person>();
			String message = null;
			
			person = ps.searchEmployee(deptId);
			
			// 뭐 실패하거나 그럴때 어떻게 할지 코드 작성
			
			String path = "/WEB-INF/view/employeeview.jsp";
			req.setAttribute("person", person);
			
			req.getRequestDispatcher(path).forward(req, resp);		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
