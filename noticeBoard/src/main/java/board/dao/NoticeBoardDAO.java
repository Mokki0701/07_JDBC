package board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import board.dto.Board;
import board.dto.Membership;

public interface NoticeBoardDAO {

	int joinMember(Membership member, Connection conn) throws SQLException;

	Membership login(String memberId, String memberPw, Connection conn) throws SQLException;

	List<Board> selectAll(Connection conn) throws SQLException;

	Board service(int boardNo, Connection conn) throws SQLException;

	int boardAdd(String parameter, String parameter2, String parameter3, Connection conn) throws SQLException;

	Membership detailmember(String boardId, Connection conn) throws SQLException;

	List<Board> memberBoardDetail(Connection conn, String boardId) throws SQLException;
	 
}
