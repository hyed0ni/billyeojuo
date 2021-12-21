package getonFast.hj.semi.member.vo;

import java.util.Date;

public class Member {
	
	private int memberNo;
	private String memberName;
	private String memberEmail;
	private String memberPw;
	private String memberPhone;
	private int memberSMSChk;
	private int memberEmailChk;
	private Date enrollDate; // java.sql.Date
	private int statusCode;
	private int gradeCode;
	private String imgOrg;
	private String imgPath;
	private String imgName;
	



	public Member() {}



	public Member(String memberName, String memberEmail, String memberPw, int memberSMSChk, int memberEmailChk) {
		super();
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPw = memberPw;
		this.memberSMSChk = memberSMSChk;
		this.memberEmailChk = memberEmailChk;
	}
	
	
	

	public Member(int memberNo, String memberName, String memberEmail, String memberPw, String memberPhone,
			int memberSMSChk, int memberEmailChk, Date enrollDate, int statusCode, int gradeCode, String imgOrg,
			String imgPath, String imgName) {
		super();
		this.memberNo = memberNo;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberPw = memberPw;
		this.memberPhone = memberPhone;
		this.memberSMSChk = memberSMSChk;
		this.memberEmailChk = memberEmailChk;
		this.enrollDate = enrollDate;
		this.statusCode = statusCode;
		this.gradeCode = gradeCode;
		this.imgOrg = imgOrg;
		this.imgPath = imgPath;
		this.imgName = imgName;
	}



	public String getImgOrg() {
		return imgOrg;
	}



	public void setImgOrg(String imgOrg) {
		this.imgOrg = imgOrg;
	}



	public String getImgPath() {
		return imgPath;
	}



	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}



	public String getImgName() {
		return imgName;
	}



	public void setImgName(String imgName) {
		this.imgName = imgName;
	}



	public String getMemberPhone() {
		return memberPhone;
	}
	
	
	
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public int getMemberNo() {
		return memberNo;
	}
	
	
	
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}
	
	
	
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	
	
	public int getStatusCode() {
		return statusCode;
	}
	
	
	
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	
	
	public int getGradeCode() {
		return gradeCode;
	}
	
	
	
	public void setGradeCode(int gradeCode) {
		this.gradeCode = gradeCode;
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
		return "Member [memberNo=" + memberNo + ", memberName=" + memberName + ", memberEmail=" + memberEmail
				+ ", memberPw=" + memberPw + ", memberPhone=" + memberPhone + ", memberSMSChk=" + memberSMSChk
				+ ", memberEmailChk=" + memberEmailChk + ", enrollDate=" + enrollDate + ", statusCode=" + statusCode
				+ ", gradeCode=" + gradeCode + ", imgOrg=" + imgOrg + ", imgPath=" + imgPath + ", imgName=" + imgName
				+ "]";
	}







	











	

	
	
	
	
}
