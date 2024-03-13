package practice.dept.controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import practice.dept.exception.PracticeInsertException;
import practice.dept.model.service.PracticeService;
import practice.dept.model.service.PracticeServiceImpl;

@WebServlet("/department/insert")
public class Insert extends HttpServlet {
	
	// 얘는 다시 돌아와서 팝업창으로 띄우는거 하자
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/view/insert.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PracticeService ps = new PracticeServiceImpl();
		
		
		try {
			
			String deptId = req.getParameter("deptId");
			String deptTitle = req.getParameter("deptTitle");
			String locationId = req.getParameter("locationId");
			
			int result = ps.insert(deptId, deptTitle, locationId);
			
			String message = null;
			
			if(result > 0) message = "추가 성공";
			else message = "추가 실패";
			
			HttpSession session = req.getSession();
			session.setAttribute("message", message);
			
			resp.sendRedirect("/");
			
			
			
			
		} catch (PracticeInsertException e) {
			
			req.setAttribute("errorMessage", e.getMessage());
			
			String path = "/WEB-INF/view/exception.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
