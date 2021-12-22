package getonFast.hj.semi.promotion.model.vo;

public class PromotionDetail {
	
	
	private int spaceNo;
	private String spaceNm;
	private String spaceSubNm;
	private int roomPrice;
	private String roomFit;
	private int like;
	private String spaceImgPath;
	private String spaceImgName;
	
	public PromotionDetail() {
		// TODO Auto-generated constructor stub
	}


	public int getSpaceNo() {
		return spaceNo;
	}

	public void setSpaceNo(int spaceNo) {
		this.spaceNo = spaceNo;
	}

	public String getSpaceNm() {
		return spaceNm;
	}

	public void setSpaceNm(String spaceNm) {
		this.spaceNm = spaceNm;
	}

	public String getSpaceSubNm() {
		return spaceSubNm;
	}

	public void setSpaceSubNm(String spaceSubNm) {
		this.spaceSubNm = spaceSubNm;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRoomFit() {
		return roomFit;
	}

	public void setRoomFit(String roomFit) {
		this.roomFit = roomFit;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public String getSpaceImgPath() {
		return spaceImgPath;
	}

	public void setSpaceImgPath(String spaceimgPath) {
		this.spaceImgPath = spaceimgPath;
	}

	public String getSpaceImgName() {
		return spaceImgName;
	}

	public void setSpaceImgName(String spaceimgName) {
		this.spaceImgName = spaceimgName;
	}


	@Override
	public String toString() {
		return "PromotionDetail [spaceNo=" + spaceNo + ", spaceNm=" + spaceNm + ", spaceSubNm=" + spaceSubNm
				+ ", roomPrice=" + roomPrice + ", roomFit=" + roomFit + ", like=" + like + ", spaceImgPath="
				+ spaceImgPath + ", spaceImgName=" + spaceImgName + "]";
	}


	
	
}
