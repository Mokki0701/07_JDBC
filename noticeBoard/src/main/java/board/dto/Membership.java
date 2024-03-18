package board.dto;

public class Membership {
	
	private String boardId;
	private String boardPw;
	private String boardName;
	private String SecurityNum;
	private String address;
	private int memberNum;
	private String nickname;
	
	public Membership() {}

	public Membership(String boardId, String boardPw) {
		super();
		this.boardId = boardId;
		this.boardPw = boardPw;
	}
	
	public Membership(String boardId, String boardPw, String boardName, String securityNum, String address,
			int memberNum, String nickname) {
		super();
		this.boardId = boardId;
		this.boardPw = boardPw;
		this.boardName = boardName;
		SecurityNum = securityNum;
		this.address = address;
		this.memberNum = memberNum;
		this.nickname = nickname;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public String getBoardPw() {
		return boardPw;
	}

	public void setBoardPw(String boardPw) {
		this.boardPw = boardPw;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getSecurityNum() {
		return SecurityNum;
	}

	public void setSecurityNum(String securityNum) {
		SecurityNum = securityNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	@Override
	public String toString() {
		return "Membership [boardId=" + boardId + ", boardPw=" + boardPw + ", boardName=" + boardName + ", SecurityNum="
				+ SecurityNum + ", address=" + address + ", memberNum=" + memberNum + ", nickname=" + nickname + "]";
	}
	
}
