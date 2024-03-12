package practice.dept.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pracice.dept.model.dto.Department;
import practice.dept.model.service.PracticeService;
import practice.dept.model.service.PracticeServiceImpl;

// index에서 요기루
@WebServlet("/department/selectAll")
public class SelectAll extends HttpServlet {
	
	// a태그 썼으니까 doGet으로 받고
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			PracticeService ps = new PracticeServiceImpl();
			
			List<Department> deptList = new ArrayList<Department>();
			
			deptList = ps.selectAll();
			
			req.setAttribute("deptList", deptList);
			
			String path = ("/WEB-INF/view/selectAll.jsp");
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
