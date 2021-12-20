package getonFast.hj.semi.member.vo;

public class Member {
	
	
	private String memberName;
	private String memberEmail;
	private String memberPw;
	private int memberSMSChk;
	private int memberEmailChk;
	
	public Member() {}



	public Member(String memberName, String memberEmail, String memberPw, int memberSMSChk, int memberEmailChk) {
		super();
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPw = memberPw;
		this.memberSMSChk = memberSMSChk;
		this.memberEmailChk = memberEmailChk;
	}


	public int getMemberSMSChk() {
		return memberSMSChk;
	}


	public void setMemberSMSChk(int memberSMSChk) {
		this.memberSMSChk = memberSMSChk;
	}



	public int getMemberEmailChk() {
		return memberEmailChk;
	}



	public void setMemberEmailChk(int memberEmailChk) {
		this.memberEmailChk = memberEmailChk;
	}



	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}



	@Override
	public String toString() {
		return "Member [memberName=" + memberName + ", memberEmail=" + memberEmail + ", memberPw=" + memberPw
				+ ", memberSMSChk=" + memberSMSChk + ", memberEmailChk=" + memberEmailChk + "]";
	}


	

	
	
	
	
}
