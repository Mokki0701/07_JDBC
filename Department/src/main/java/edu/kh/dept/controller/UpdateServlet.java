package edu.kh.dept.controller;

import java.io.IOException;

import edu.kh.dept.model.dto.Department;
import edu.kh.dept.model.service.DepartmentService;
import edu.kh.dept.model.service.DepartmentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/department/update")
public class UpdateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String deptId = req.getParameter("deptId");
		
		try {
			DepartmentService service = new DepartmentServiceImpl();
			Department dept = new Department();
			dept = service.selectOne(deptId);
			
			// 조회 결과가 없을 경우
			if(dept == null) {
				req.getSession().setAttribute("message", "해당 부서가 존재하지 않습니다.");
				resp.sendRedirect("/department/selectAll");
			} else { // 조회 결과가 있을 경우
				
				req.setAttribute("dept", dept); 
				String path = "/WEB-INF/views/update.jsp";
				req.getRequestDispatcher(path).forward(req, resp); // jsp로 forward
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 부서 수정
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			DepartmentService service = new DepartmentServiceImpl();
			
			// 전달 받은 파라미터를 모두 얻어와 Department 객체에 저장
			Department dept = new Department(req.getParameter("deptId"), req.getParameter("deptTitle"), req.getParameter("locationId"));
			
			int result = service.updateDepartment(dept);
			
			String message = null;
			if(result > 0) message = "수정 성공!!!";
			else					 message = "수정 실패...";
			
			req.getSession().setAttribute("message", message);
			
			resp.sendRedirect("/department/selectAll");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
