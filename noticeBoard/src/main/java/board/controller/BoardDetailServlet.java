package board.controller;

import java.io.IOException;

import board.dto.Board;
import board.service.NoticeBoardSerivceImpl;
import board.service.NoticeBoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			NoticeBoardService service = new NoticeBoardSerivceImpl();
			
			Board board = new Board();
			board = service.detailSelect(boardNo);
			
			String path = "/WEB-INF/views/detail.jsp";
			
			req.setAttribute("board", board);
			
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	
	}
	

}
