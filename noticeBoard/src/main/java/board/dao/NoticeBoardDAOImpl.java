package board.dao;

import static board.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import board.dto.Board;
import board.dto.Membership;

public class NoticeBoardDAOImpl implements NoticeBoardDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public NoticeBoardDAOImpl() {
		
		
		try {
			prop = new Properties();
			
			String path = NoticeBoardDAOImpl.class.getResource("/board/sql/sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(path));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	// 회원 가입
	@Override
	public int joinMember(Membership member, Connection conn) throws SQLException {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("join");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getBoardId());
			pstmt.setString(2, member.getBoardPw());
			pstmt.setString(3, member.getBoardName());
			pstmt.setString(4, member.getSecurityNum());
			pstmt.setString(5, member.getAddress());
			pstmt.setInt(6, member.getMemberNum());
			pstmt.setString(7, member.getNickname());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	// 로그인
	@Override
	public Membership login(String memberId, String memberPw, Connection conn) throws SQLException {
		
		Membership member = null;
		
		try {
			
			
			
			String path = prop.getProperty("login");
			pstmt = conn.prepareStatement(path);
			
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Membership();
				
				member.setBoardId(rs.getString("BOARD_ID"));
				member.setBoardPw(rs.getString("BOARD_PW"));
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return member;
	}


	// 게시글 전체 조회
	@Override
	public List<Board> selectAll(Connection conn) throws SQLException {
		
		List<Board> boardList = new ArrayList<Board>();
		
		try {
			String path = prop.getProperty("selectAll");
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(path);
			
			while(rs.next()) {
				Board board = new Board(rs.getInt("BOARD_NO"), rs.getString("NICKNAME"), rs.getString("BOARD_TITLE"), rs.getString("REGDATE"), rs.getString("BOARD_ID"));
				
				boardList.add(board);
			}
		}finally {
			close(rs);
			close(stmt);
		}
		
		return boardList;
	}


	// 게시글 상세 조회\
	@Override
	public Board service(int boardNo, Connection conn) throws SQLException {
		
		Board board = new Board();
		
		try {
			String path = prop.getProperty("detail");
			pstmt = conn.prepareStatement(path);
			
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board.setBoardNo(Integer.parseInt(rs.getString("BOARD_NO")));
				board.setBoardText(rs.getString("BOARD_TEXT"));
				board.setNickname(rs.getString("NICKNAME"));
				board.setRegdate(rs.getString("REGDATE"));
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return board;
	}

	
	// 게시글 추가
	@Override
	public int boardAdd(String boardTitle, String nickname, String boardText, Connection conn) throws SQLException {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("boardAdd");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,nickname);
			pstmt.setString(2,boardTitle);
			pstmt.setString(3, boardText);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}

	
	// 개인 정보 조회
	@Override
	public Membership detailmember(String boardId, Connection conn) throws SQLException {
		
		Membership member = new Membership();
		
		try {
			String path2 = prop.getProperty("detail2");
			
			pstmt = conn.prepareStatement(path2);
			
			pstmt.setString(1, boardId);
			
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setAddress(rs.getString("ADDRESS"));
				member.setBoardId(rs.getString("BOARD_ID"));
				member.setBoardName(rs.getString("BOARD_NAME"));
				member.setBoardPw(rs.getString("BOARD_PW"));
				member.setMemberNum(rs.getInt("MEMBER_NUM"));
				member.setNickname(rs.getString("NICKNAME"));
				member.setSecurityNum(rs.getString("SECURITY_NUM"));
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		System.out.println(member.toString());
		
		return member;
	}

	

	@Override
	public List<Board> memberBoardDetail(Connection conn, String boardId) throws SQLException {
		
		List<Board> boardList = new ArrayList<Board>();
		
		try {
			String sql = prop.getProperty("memberBoardDetail");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board(rs.getInt("BOARD_NO"), rs.getString("NICKNAME"), rs.getString("BOARD_TITLE"), rs.getString("REGDATE"), rs.getString("BOARD_ID"),rs.getString("BOARD_TEXT"));
				
				boardList.add(board);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return boardList;
	}


	@Override
	public int updateMember(Membership member,String boardId, Connection conn) throws SQLException {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateMember");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getBoardId());
			pstmt.setString(2, member.getBoardPw());
			pstmt.setString(3, member.getBoardName());
			pstmt.setString(4, member.getSecurityNum());
			pstmt.setString(5, member.getAddress());
			pstmt.setInt(6, member.getMemberNum());
			pstmt.setString(7, boardId);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}


	@Override
	public List<Board> searchBoard(Connection conn, String boardName, int selectOption) throws SQLException {
		List<Board> boardList = new ArrayList<Board>();
		
		try {
			
			String sql = null;
			if(selectOption == 1) {
				sql = prop.getProperty("searchBoard1");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, boardName);
				
			} else if(selectOption == 2) {
				sql = prop.getProperty("searchBoard2");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, boardName);
				
			} else {
				sql = prop.getProperty("searchBoard3");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, boardName);
				pstmt.setString(2, boardName);
				
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board(Integer.parseInt(rs.getString("BOARD_NO")), rs.getString("NICKNAME"), rs.getString("BOARD_TITLE"),
						rs.getString("REGDATE"), rs.getString("BOARD_TEXT"),rs.getString("BOARD_ID"));
				boardList.add(board);
				System.out.println(board.toString());
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return boardList;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
