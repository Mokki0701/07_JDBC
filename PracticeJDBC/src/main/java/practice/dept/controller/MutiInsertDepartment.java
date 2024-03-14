package practice.dept.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import practice.dept.exception.PracticeInsertException;
import practice.dept.model.dto.Department;
import practice.dept.model.service.PracticeService;
import practice.dept.model.service.PracticeServiceImpl;

@WebServlet("/department/multiInsert")
public class MutiInsertDepartment extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] deptId = req.getParameterValues("deptId");
		String[] deptTitle = req.getParameterValues("deptTitle");
		String[] locationId = req.getParameterValues("locationId");
		
		List<Department> deptList = new ArrayList<Department>();
		
		for(int i = 0; i < deptId.length; i++) {
			
			Department dept = new Department(deptId[i], deptTitle[i], locationId[i]);
			deptList.add(dept);
			
		}
		
		try {
			int result = 0;
			PracticeService ps = new PracticeServiceImpl();
			String message = null;
			
			result = ps.multiInsert(deptList);
			
			if( result > 0) {
				message = "추가 성공";
			}else {
				message = "추가 실패";
			}
			
			req.getSession().setAttribute("message", message);
			resp.sendRedirect("/department/selectAll");
			
		}catch(PracticeInsertException e) {
			
			String path = "/WEB-INF/view/error.jsp";
			
			req.setAttribute("errormessage", e.getMessage());
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
