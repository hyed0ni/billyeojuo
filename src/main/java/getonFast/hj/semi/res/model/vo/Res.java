package getonFast.hj.semi.res.model.vo;

import getonFast.hj.semi.space.model.vo.Space;

public class Res {
	private int resNo;
	private String resPersonnel;
	private String resNm;
	private String resPno;
	private String resEmail;
	private String resPurpose;
	private String resReq;
	private char resAgree;
	private String payDate;
	private String useDate;
	private int resDt;

	private Space space;

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

	public char getResAgree() {
		return resAgree;
	}

	public void setResAgree(char resAgree) {
		this.resAgree = resAgree;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public String getUseDate() {
		return useDate;
	}

	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}

	public int getResDt() {
		return resDt;
	}

	public void setResDt(int resDt) {
		this.resDt = resDt;
	}

	public Space getSpace() {
		return space;
	}

	public void setSpace(Space space) {
		this.space = space;
	}

	@Override
	public String toString() {
		return "Res [resNo=" + resNo + ", resPersonnel=" + resPersonnel + ", resNm=" + resNm + ", resPno=" + resPno
				+ ", resEmail=" + resEmail + ", resPurpose=" + resPurpose + ", resReq=" + resReq + ", resAgree="
				+ resAgree + ", payDate=" + payDate + ", useDate=" + useDate + ", resDt=" + resDt + ", space=" + space
				+ "]";
	}

}
