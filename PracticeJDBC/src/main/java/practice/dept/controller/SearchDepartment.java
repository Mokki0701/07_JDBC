package practice.dept.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pracice.dept.model.dto.Department;
import practice.dept.model.service.PracticeService;
import practice.dept.model.service.PracticeServiceImpl;

@WebServlet("/department/search")
public class SearchDepartment extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = ("/WEB-INF/view/search.jsp");
		req.getRequestDispatcher(path).forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PracticeService ps = new PracticeServiceImpl();
		
		try {
			
			String search = req.getParameter("search");
			
			List<Department> deptList = ps.search(search);
			
			System.out.println(deptList);
			
			req.setAttribute("deptList", deptList);
			
			String path = ("/WEB-INF/view/selectDepartment.jsp");
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
