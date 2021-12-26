package getonFast.hj.semi.admin.model.vo;

public class AdQ {
	private int queNo;
	private int inqType;
	private String queTitle;
	private String queContent;
	private String queDt;
	private int queSt;
	private int memberNo;
	private int spaceNo;
	
	private String ansContent;
	private String ansDate;
	private int ansSt;
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
	public String getQueDt() {
		return queDt;
	}
	public void setQueDt(String queDt) {
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
	public String getAnsContent() {
		return ansContent;
	}
	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}
	public String getAnsDate() {
		return ansDate;
	}
	public void setAnsDate(String ansDate) {
		this.ansDate = ansDate;
	}
	public int getAnsSt() {
		return ansSt;
	}
	public void setAnsSt(int ansSt) {
		this.ansSt = ansSt;
	}
	@Override
	public String toString() {
		return "AdQ [queNo=" + queNo + ", inqType=" + inqType + ", queTitle=" + queTitle + ", queContent=" + queContent
				+ ", queDt=" + queDt + ", queSt=" + queSt + ", memberNo=" + memberNo + ", spaceNo=" + spaceNo
				+ ", ansContent=" + ansContent + ", ansDate=" + ansDate + ", ansSt=" + ansSt + "]";
	}
	
}
