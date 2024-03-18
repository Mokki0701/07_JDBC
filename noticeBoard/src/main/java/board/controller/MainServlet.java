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

@WebServlet("/board/main")
public class MainServlet extends HttpServlet {

	// 조회 정보 일치 검사
	// 검사 성공 -> 게시판 페이지 이동
	// 검사 실패 -> 다시 로그인 페이지 redirect
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String memberId = req.getParameter("boardId");
			String memberPw = req.getParameter("boardPw");
			
			
			NoticeBoardService service = new NoticeBoardSerivceImpl();
			
			Membership member = service.login(memberId, memberPw);
			
			if(member != null) {
				
				List<Board> boardList = new ArrayList<Board>();
				
				boardList = service.selectAll();
				
				req.setAttribute("boardList", boardList);
				req.getSession().setAttribute("boardId", memberId);
				req.getSession().setAttribute("boardPw", memberPw);
				
				String path = "/WEB-INF/views/boardmain.jsp";
				
				req.getRequestDispatcher(path).forward(req, resp);
			}else {
				String message = "아이디/비밀번호 불일치";
				req.getSession().setAttribute("message", message);
				resp.sendRedirect("/");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
                                                                                                                                                                                                          