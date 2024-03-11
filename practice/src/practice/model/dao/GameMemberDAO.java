package practice.model.dao;

import static practice.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import practice.model.dto.GameMember;

public class GameMemberDAO {
		
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int insertMember(GameMember member	) throws SQLException {
		
		int result = 0;
		
		try {
			conn = getConnection();
			
			String sql = "INSERT INTO GAME_MEMBER VALUES(?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setInt(4, member.getMemberNum());
			pstmt.setString(5, member.getTierCode());
			pstmt.setString(6, member.getTierName());
			
			// 이제 집어 넣어야지
			result = pstmt.executeUpdate();
			
			if(result > 0) commit(conn);
			else					 rollback(conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
