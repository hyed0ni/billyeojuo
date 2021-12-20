package getonFast.hj.semi.my.model.vo;

import java.sql.Date;

public class Qna {
	private int queNo;
	private int inqType;
	private String queTitle;
	private String queContent;
	private Date queDt;
	private int queSt;
	private int memberNo;
	private int spaceNo;
	
	private void qna() {
	}

	public int getQueNo() {
		return queNo;
	}

	public void setQueNo(int queNo) {
		this.queNo = queNo;
	}

	public int getInqType() {
		return inqType;
	}

	public void setInqType(int inqType) {
		this.inqType = inqType;
	}

	public String getQueTitle() {
		return queTitle;
	}

	public void setQueTitle(String queTitle) {
		this.queTitle = queTitle;
	}

	public String getQueContent() {
		return queContent;
	}

	public void setQueContent(String queContent) {
		this.queContent = queContent;
	}

	public Date getQueDt() {
		return queDt;
	}

	public void setQueDt(Date queDt) {
		this.queDt = queDt;
	}

	public int getQueSt() {
		return queSt;
	}

	public void setQueSt(int queSt) {
		this.queSt = queSt;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getSpaceNo() {
		return spaceNo;
	}

	public void setSpaceNo(int spaceNo) {
		this.spaceNo = spaceNo;
	}
	
	

}
