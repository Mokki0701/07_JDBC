package board.service;

import static board.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.dao.NoticeBoardDAO;
import board.dao.NoticeBoardDAOImpl;
import board.dto.Board;
import board.dto.Membership;

public class NoticeBoardSerivceImpl implements NoticeBoardService {

	private NoticeBoardDAO dao = null;
	
	public NoticeBoardSerivceImpl() {
		dao = new NoticeBoardDAOImpl();
	}

	// 회원가입
	@Override
	public int joinMember(Membership member) throws SQLException {
			
		Connection conn = getConnection();
		
		int result = dao.joinMember(member,conn);
		
		if(result > 0) commit(conn);
		else					 rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	// 회원 정보 일치
	@Override
	public Membership login(String memberId, String memberPw) throws SQLException {
		Connection conn = getConnection();
		
		Membership member = dao.login(memberId, memberPw, conn);
		
		if(member == null) rollback(conn);
		else							 commit(conn);
		
		close(conn);
		
		return member;
	}

	// 게시글 전체 조회
	@Override
	public List<Board> selectAll() throws SQLException {
		
		List<Board> boardList = new ArrayList<Board>();
		Connection conn = getConnection();
		
		boardList = dao.selectAll(conn);
		
		close(conn);

		return boardList;
	}

	// 게시글 상세 조회
	@Override
	public Board detailSelect(int boardNo) throws SQLException {
		
		Connection conn	= getConnection();
		
		Board board = dao.service(boardNo, conn);
		
		close(conn);
		
		return board;
	}
	
	// 게시글 추가
	@Override
	public int boardAdd(String boardTitle, String boardId, String boardText) throws SQLException {
		
		Connection conn = getConnection();
		
		// 개인 조회
		Membership member = dao.detailmember(boardId, conn);
		
		System.out.println(member.getNickname());
		
		// 개인 조회로 얻은 닉네임값 입력 (닉네임은 뽀린키라서 멤버 닉네임이랑 같아야함)
		int result = dao.boardAdd(boardTitle,member.getNickname(), boardText, conn);
		
		if(result > 0) commit(conn);
		else					 rollback(conn);
		
		close(conn);
		
		return result;
	}

	@Override
	public Membership memberDetail(String boardId) throws SQLException {
		
		Connection conn = getConnection();
		
		Membership member = dao.detailmember(boardId, conn);
		
		close(conn);
		
		return member;
	}

	
	@Override
	public List<Board> memberBoardDetail(String boardId) throws SQLException {
		Connection conn = getConnection();
		
		List<Board> boardList = dao.memberBoardDetail(conn, boardId);
		
		if(boardList.isEmpty()) rollback(conn);
		else										commit(conn);
		
		close(conn);
		
		return boardList;
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
