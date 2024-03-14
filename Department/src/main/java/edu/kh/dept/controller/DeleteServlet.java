package edu.kh.dept.controller;

import java.io.IOException;

import edu.kh.dept.model.exception.DepartmentDeleteException;
import edu.kh.dept.model.service.DepartmentService;
import edu.kh.dept.model.service.DepartmentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/department/delete")
public class DeleteServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			DepartmentService service = new DepartmentServiceImpl();
			
			String deptId = req.getParameter("deptId");
			
			int result = service.delete(deptId);
			
			
			// 서비스 결과에 따라서
			// Session에 "삭제 성공", "삭제 실패" 메시지를 속성을 추가
			String message = null;
			HttpSession session = req.getSession();
			
			if(result > 0) message = "삭제 성공";
			else					 message = "삭제 실패";
			
			// 전체 부서 조회를 재요청
			session.setAttribute("message", message);
			resp.sendRedirect("selectAll");
			
		}catch(DepartmentDeleteException e) {
			HttpSession session = req.getSession();
			
			session.setAttribute("message", e.getMessage());
			resp.sendRedirect("selectAll");
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
