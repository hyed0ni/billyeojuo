package getonFast.hj.semi.admin.model.vo;

public class AdRe {
	private int revNo;
	private String revContent;
	private String revDt;
	private int revSt;
	private int resNo;
	
	private String replyDt;
	private String replyContent;
	private int replySt;
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
	public String getReplyDt() {
		return replyDt;
	}
	public void setReplyDt(String replyDt) {
		this.replyDt = replyDt;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public int getReplySt() {
		return replySt;
	}
	public void setReplySt(int replySt) {
		this.replySt = replySt;
	}
	@Override
	public String toString() {
		return "AdRe [revNo=" + revNo + ", revContent=" + revContent + ", revDt=" + revDt + ", revSt=" + revSt
				+ ", resNo=" + resNo + ", replyDt=" + replyDt + ", replyContent=" + replyContent + ", replySt="
				+ replySt + "]";
	}
	
}
