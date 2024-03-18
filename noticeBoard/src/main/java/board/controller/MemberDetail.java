package board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import board.dto.Board;
import board.dto.Membership;
import board.service.NoticeBoardSerivceImpl;
import board.service.NoticeBoardService;
import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@WebServlet("/board/member")
public class MemberDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			NoticeBoardService service = new NoticeBoardSerivceImpl();
			String boardId = (String)req.getSession().getAttribute("boardId");
			
			System.out.println(boardId);
			
			Membership member = service.memberDetail(boardId);
			
			String message = null;
			
			if(member != null) {
				String path = "/WEB-INF/views/memberDetail.jsp";
				req.setAttribute("member", member);
				req.getRequestDispatcher(path).forward(req, resp);
			}else {
				List<Board> boardList = new ArrayList<Board>();
				
				message = "정보 조회 실패";
				
				boardList = service.selectAll();
				req.setAttribute("boardList", boardList);
				req.getSession().setAttribute("message", message);
				
				String path = "/WEB-INF/views/boardmain.jsp";
				req.getRequestDispatcher(path).forward(req, resp);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
