package getonFast.hj.semi.review.model.vo;

import getonFast.hj.semi.member.vo.Member;

public class Review {
	private int revNo;
	private String revContent;
	private String revDt;
	private int revSt;
	private int resNo;
	private int spaceRoomNo;
	private int spaceNo;
	
	private Member member;
	
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

	public String getRevDt() {
		return revDt;
	}

	public void setRevDt(String revDt) {
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

	public int getSpaceRoomNo() {
		return spaceRoomNo;
	}

	public void setSpaceRoomNo(int spaceRoomNo) {
		this.spaceRoomNo = spaceRoomNo;
	}

	public int getSpaceNo() {
		return spaceNo;
	}

	public void setSpaceNo(int spaceNo) {
		this.spaceNo = spaceNo;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
	
	
	

}
