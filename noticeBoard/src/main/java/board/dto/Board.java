package board.dto;

public class Board {
	
	private int boardNo;
	private String nickname;
	private String boardTitle;
	private String regdate;
	private String boardText;
	private String memberId;
	
	public Board() {}
	
	

	public Board(int boardNo, String nickname, String boardTitle, String regdate, String memberId) {
		super();
		this.boardNo = boardNo;
		this.nickname = nickname;
		this.boardTitle = boardTitle;
		this.regdate = regdate;
		this.memberId = memberId;
	}
	
	



	public Board(int boardNo, String nickname, String boardTitle, String regdate, String boardText, String memberId) {
		super();
		this.boardNo = boardNo;
		this.nickname = nickname;
		this.boardTitle = boardTitle;
		this.regdate = regdate;
		this.boardText = boardText;
		this.memberId = memberId;
	}



	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getBoardText() {
		return boardText;
	}

	public void setBoardText(String boardText) {
		this.boardText = boardText;
	}
	
	

	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", nickname=" + nickname + ", boardTitle=" + boardTitle + ", regdate="
				+ regdate + ", boardText=" + boardText + ", memberId=" + memberId + "]";
	}




	
	
	
	
}
