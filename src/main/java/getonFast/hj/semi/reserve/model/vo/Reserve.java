package getonFast.hj.semi.reserve.model.vo;

import java.sql.Date;

public class Reserve {

	private int resNo;
	private String resPersonnel;
	private String resNm;
	private String resPno;
	private String resEmail;
	private String resPurpose;
	private String resReq;
	private String resAgree;
	private int payMethod;
	private Date payDate;
	private Date useDate;
	private int resDt;
	private int memberNo;
	private int spaceRoomNo;
	
	private void reserve() {
	}

	public int getResNo() {
		return resNo;
	}

	public void setResNo(int resNo) {
		this.resNo = resNo;
	}

	public String getResPersonnel() {
		return resPersonnel;
	}

	public void setResPersonnel(String resPersonnel) {
		this.resPersonnel = resPersonnel;
	}

	public String getResNm() {
		return resNm;
	}

	public void setResNm(String resNm) {
		this.resNm = resNm;
	}

	public String getResPno() {
		return resPno;
	}

	public void setResPno(String resPno) {
		this.resPno = resPno;
	}

	public String getResEmail() {
		return resEmail;
	}

	public void setResEmail(String resEmail) {
		this.resEmail = resEmail;
	}

	public String getResPurpose() {
		return resPurpose;
	}

	public void setResPurpose(String resPurpose) {
		this.resPurpose = resPurpose;
	}

	public String getResReq() {
		return resReq;
	}

	public void setResReq(String resReq) {
		this.resReq = resReq;
	}

	public String getResAgree() {
		return resAgree;
	}

	public void setResAgree(String resAgree) {
		this.resAgree = resAgree;
	}

	public int getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(int payMethod) {
		this.payMethod = payMethod;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Date getUseDate() {
		return useDate;
	}

	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}

	public int getResDt() {
		return resDt;
	}

	public void setResDt(int resDt) {
		this.resDt = resDt;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getSpaceRoomNo() {
		return spaceRoomNo;
	}

	public void setSpaceRoomNo(int spaceRoomNo) {
		this.spaceRoomNo = spaceRoomNo;
	}
	
	
	
}
