package board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import board.dto.Board;
import board.service.NoticeBoardSerivceImpl;
import board.service.NoticeBoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/create")
public class BoardCreateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/create.jsp";
		
		req.getRequestDispatcher(path).forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			NoticeBoardService service = new NoticeBoardSerivceImpl();
			
			int result = service.boardAdd(req.getParameter("boardTitle"), req.getParameter("boardId"), req.getParameter("boardText"));
			String message = null;
			
			if(result > 0) {
				message = "추가 완료!!!";
				req.setAttribute("message", message);
				
				List<Board> boardList = new ArrayList<Board>();
				
				boardList = service.selectAll();
				
				req.setAttribute("boardList", boardList);
				
				req.getRequestDispatcher("/WEB-INF/views/boardmain.jsp").forward(req, resp);
			}else {
				message = "추가 실패...";
				req.getSession().setAttribute("message", message);
				resp.sendRedirect("/board/create");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
}
