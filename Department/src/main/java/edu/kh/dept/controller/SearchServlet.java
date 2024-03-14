package edu.kh.dept.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.dept.model.dto.Department;
import edu.kh.dept.model.service.DepartmentService;
import edu.kh.dept.model.service.DepartmentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/department/search")
public class SearchServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DepartmentService service = new DepartmentServiceImpl();
		List<Department> deptList = new ArrayList<Department>();
		
		try {
			String keyword = req.getParameter("keyword");
			String message = null;
			
			deptList = service.searchDepartment(keyword);			
			
			if(deptList.isEmpty()) {
				message = "해당 검색어에 대한 결과가 존재하지 않습니다";
				HttpSession session = req.getSession();
				session.setAttribute("message", message);
				resp.sendRedirect("/");
			}else {
				// forward할 JSP 경로
				String path = "/WEB-INF/views/search.jsp";
				req.setAttribute("deptList", deptList);
				
				req.getRequestDispatcher(path).forward(req, resp);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	
	}
	
	
}
