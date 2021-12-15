package getonFast.hj.semi.review.model.vo;

import java.sql.Date;

public class Review {
	private int revNo;
	private String revContent;
	private Date revDt;
	private int revSt;
	private int resNo;
	
	public Review() {}

	public int getRevNo() {
		return revNo;
	}

	public void setRevNo(int revNo) {
		this.revNo = revNo;
	}

	public String getRevContent() {
		return revContent;
	}

	public void setRevContent(String revContent) {
		this.revContent = revContent;
	}

	public Date getRevDt() {
		return revDt;
	}

	public void setRevDt(Date revDt) {
		this.revDt = revDt;
	}

	public int getRevSt() {
		return revSt;
	}

	public void setRevSt(int revSt) {
		this.revSt = revSt;
	}

	public int getResNo() {
		return resNo;
	}

	public void setResNo(int resNo) {
		this.resNo = resNo;
	}
	
	
	
	
	

}
