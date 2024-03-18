package board.controller;

import java.io.IOException;
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

@WebServlet("/board/memberBoardDetail")
public class MemberBoardDetail extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			NoticeBoardService service = new NoticeBoardSerivceImpl();
			String boardId = (String)req.getSession().getAttribute("boardId");
			
			List<Board> boardList = service.memberBoardDetail(boardId);
			
			if(!boardList.isEmpty()) {
				String path = "/WEB-INF/views/memberBoardDetail.jsp";
				
				req.setAttribute("boardList", boardList);
				req.getRequestDispatcher(path).forward(req, resp);
			}else {
				Membership member = service.memberDetail(boardId);
				String path = "/WEB-INF/views/memberDetail.jsp";
				
				req.setAttribute("member", member);
				req.getRequestDispatcher(path).forward(req, resp);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
