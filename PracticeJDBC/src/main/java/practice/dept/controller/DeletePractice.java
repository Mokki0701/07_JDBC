package practice.dept.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import practice.dept.model.service.PracticeService;
import practice.dept.model.service.PracticeServiceImpl;

@WebServlet("/department/delete")
public class DeletePractice extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int result = 0;
		
		try {
			PracticeService ps = new PracticeServiceImpl();
			String deptId = req.getParameter("deptId");
			
			result = ps.deleteDepartment(deptId);
			
			String message = null;
			if(result > 0) message = "삭제 성공";
			else					 message = "삭제 실패";
			
			req.getSession().setAttribute("message", message);
			resp.sendRedirect("selectAll");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}

}
