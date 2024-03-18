package board.controller;

import java.io.IOException;

import board.dto.Membership;
import board.service.NoticeBoardSerivceImpl;
import board.service.NoticeBoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/join")
public class JoinMembershipServlet extends HttpServlet {
	
	// 일단 여기서는 값들 얻어오고
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/join.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Membership member = new Membership(req.getParameter("boardId"), req.getParameter("boardPw"), req.getParameter("boardName"), req.getParameter("securityNum"), req.getParameter("address"),
					Integer.parseInt(req.getParameter("memberNum")), req.getParameter("nickname"));
			
			NoticeBoardService service = new NoticeBoardSerivceImpl();
			
			int result = service.joinMember(member);
			
			String message = null;
			if(result > 0) message = "회원 가입 성공!!!";
			else					 message = "회원 가입 실패...";
			
			req.getSession().setAttribute("message", message);
			resp.sendRedirect("/");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	
	}
	
}
