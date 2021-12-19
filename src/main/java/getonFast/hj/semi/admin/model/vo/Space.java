package getonFast.hj.semi.admin.model.vo;


public class Space {
	private int spaceNo;
	private int spaceStatus;
	private String spaceName;
	private String spaceSubName;
	
	private String spaceIntro;
	private String spaceGuide;
	private String precautions;
	private String refundPolicy;
	
	private String spaceAddr;
	private String spacePhone;
	
	private String spaceMapImg;
	private String spaceMapPath;
	private String spaceRecommend;
	private String spaceTypeNo;
	
 
	public Space() {
	}


	public int getSpaceNo() {
		return spaceNo;
	}


	public void setSpaceNo(int spaceNo) {
		this.spaceNo = spaceNo;
	}


	public String getSpaceName() {
		return spaceName;
	}


	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}


	public String getSpaceSubName() {
		return spaceSubName;
	}


	public void setSpaceSubName(String spaceSubName) {
		this.spaceSubName = spaceSubName;
	}


	public String getSpaceIntro() {
		return spaceIntro;
	}


	public void setSpaceIntro(String spaceIntro) {
		this.spaceIntro = spaceIntro;
	}


	public String getSpaceGuide() {
		return spaceGuide;
	}


	public void setSpaceGuide(String spaceGuide) {
		this.spaceGuide = spaceGuide;
	}


	public String getPrecautions() {
		return precautions;
	}


	public void setPrecautions(String precautions) {
		this.precautions = precautions;
	}


	public String getRefundPolicy() {
		return refundPolicy;
	}


	public void setRefundPolicy(String refundPolicy) {
		this.refundPolicy = refundPolicy;
	}


	public String getSpaceAddr() {
		return spaceAddr;
	}


	public void setSpaceAddr(String spaceAddr) {
		this.spaceAddr = spaceAddr;
	}


	public String getSpacePhone() {
		return spacePhone;
	}


	public void setSpacePhone(String spacePhone) {
		this.spacePhone = spacePhone;
	}


	public String getSpaceMapImg() {
		return spaceMapImg;
	}


	public void setSpaceMapImg(String spaceMapImg) {
		this.spaceMapImg = spaceMapImg;
	}


	public String getSpaceMapPath() {
		return spaceMapPath;
	}


	public void setSpaceMapPath(String spaceMapPath) {
		this.spaceMapPath = spaceMapPath;
	}


	public String getSpaceRecommend() {
		return spaceRecommend;
	}


	public void setSpaceRecommend(String spaceRecommend) {
		this.spaceRecommend = spaceRecommend;
	}


	public String getSpaceTypeNo() {
		return spaceTypeNo;
	}


	public void setSpaceTypeNo(String spaceTypeNo) {
		this.spaceTypeNo = spaceTypeNo;
	}

	

	public int getSpaceStatus() {
		return spaceStatus;
	}


	public void setSpaceStatus(int spaceStatus) {
		this.spaceStatus = spaceStatus;
	}


	@Override
	public String toString() {
		return "Space [spaceNo=" + spaceNo + ", spaceName=" + spaceName + ", spaceSubName=" + spaceSubName
				+ ", spaceIntro=" + spaceIntro + ", spaceGuide=" + spaceGuide + ", precautions=" + precautions
				+ ", refundPolicy=" + refundPolicy + ", spaceAddr=" + spaceAddr + ", spacePhone=" + spacePhone
				+ ", spaceMapImg=" + spaceMapImg + ", spaceMapPath=" + spaceMapPath + ", spaceRecommend="
				+ spaceRecommend + ", spaceTypeNo=" + spaceTypeNo + ", spaceStatus=" + spaceStatus + ", getSpaceNo()="
				+ getSpaceNo() + ", getSpaceName()=" + getSpaceName() + ", getSpaceSubName()=" + getSpaceSubName()
				+ ", getSpaceIntro()=" + getSpaceIntro() + ", getSpaceGuide()=" + getSpaceGuide()
				+ ", getPrecautions()=" + getPrecautions() + ", getRefundPolicy()=" + getRefundPolicy()
				+ ", getSpaceAddr()=" + getSpaceAddr() + ", getSpacePhone()=" + getSpacePhone() + ", getSpaceMapImg()="
				+ getSpaceMapImg() + ", getSpaceMapPath()=" + getSpaceMapPath() + ", getSpaceRecommend()="
				+ getSpaceRecommend() + ", getSpaceTypeNo()=" + getSpaceTypeNo() + ", getSpaceStatus()="
				+ getSpaceStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


	
	
}
