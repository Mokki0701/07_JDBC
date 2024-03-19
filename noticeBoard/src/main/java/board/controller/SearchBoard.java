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

@WebServlet("/board/search")
public class SearchBoard extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			NoticeBoardService service = new NoticeBoardSerivceImpl();
			
			int selectOption = Integer.parseInt(req.getParameter("selectOption"));
			System.out.println(selectOption);
			String boardName = req.getParameter("boardName");
			List<Board> boardList = service.searchBoard(boardName, selectOption);
			
			String message = null;
			
			if(!boardList.isEmpty()) {
				message = "조회 성공!!!";
				req.setAttribute("boardList", boardList);
			}
			else {
				message = "조회 실패...";
				boardList = new ArrayList<Board>();
				
				boardList = service.selectAll(); 
				
				req.setAttribute("boardList", boardList);
			}
			String path = "/WEB-INF/views/boardmain.jsp";
			req.setAttribute("message", message);
			
			req.getRequestDispatcher(path).forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	
	}

}
