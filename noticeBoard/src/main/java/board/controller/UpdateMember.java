package board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import board.dto.Board;
import board.dto.Membership;
import board.service.NoticeBoardSerivceImpl;
import board.service.NoticeBoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/updateMember")
public class UpdateMember extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			NoticeBoardService service = new NoticeBoardSerivceImpl();
			String boardId = (String)req.getSession().getAttribute("boardId");
			
			System.out.println(boardId);
			
			Membership member1 = new Membership(req.getParameter("boardId"), req.getParameter("boardPw"), req.getParameter("boardName"),
					req.getParameter("securityNum"), req.getParameter("address"), Integer.parseInt(req.getParameter("memberNum")), req.getParameter("nickname"));
			
			System.out.println(member1.toString());
			
			
			
			service.updateMember(member1,boardId);
			
			List<Board> boardList = new ArrayList<Board>();
			boardList = service.selectAll();
			
			req.getSession().setAttribute("boardId", member1.getBoardId());
			req.setAttribute("boardList", boardList);
			String path = "/WEB-INF/views/boardmain.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String boardId = (String) req.getSession().getAttribute("boarId");
			NoticeBoardService service = new NoticeBoardSerivceImpl();
			
			Membership member = service.memberDetail(boardId);
			
			String path = "/WEB-INF/views/updateMember.jsp";
			req.setAttribute("member", member);
			req.getRequestDispatcher(path).forward(req, resp);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
