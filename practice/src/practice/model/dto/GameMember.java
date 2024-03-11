package practice.model.dto;

public class GameMember {

	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberNum;
	private String tierCode;
	private String tierName;
	
	public GameMember() {}
	
	public GameMember(String memberId, String memberPw, String memberName, int memberNum, String tierCode,
			String tierName) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberNum = memberNum;
		this.tierCode = tierCode;
		this.tierName = tierName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}

	public String getTierCode() {
		return tierCode;
	}

	public void setTierCode(String tierCode) {
		this.tierCode = tierCode;
	}

	public String getTierName() {
		return tierName;
	}

	public void setTierName(String tierName) {
		this.tierName = tierName;
	}

	@Override
	public String toString() {
		return "GameMember [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName + ", memberNum="
				+ memberNum + ", tierCode=" + tierCode + ", tierName=" + tierName + "]";
	}
}
