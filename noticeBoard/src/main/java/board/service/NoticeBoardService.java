package board.service;


import java.sql.SQLException;
import java.util.List;

import board.dto.Board;
import board.dto.Membership;

public interface NoticeBoardService {

	int joinMember(Membership member) throws SQLException;

	Membership login(String memberId, String memberPw) throws SQLException;

	List<Board> selectAll() throws SQLException;

	Board detailSelect(int boardNo) throws SQLException;

	int boardAdd(String parameter, String parameter2, String parameter3) throws SQLException;

	Membership memberDetail(String boardId) throws SQLException;

	List<Board> memberBoardDetail(String boardId) throws SQLException;

	void updateMember(Membership member, String boardId) throws SQLException;

	List<Board> searchBoard(String boardName, int selectOption) throws SQLException;

}
