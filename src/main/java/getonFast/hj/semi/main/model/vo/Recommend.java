package getonFast.hj.semi.main.model.vo;

public class Recommend {
	
	private int spaceNo;
	private String spaceNm;
	private String spaceSubNm;
	private int roomPrice;
	private String roomFit;
	private int like;
	private String imgPath;
	private String imgName;
	
	public Recommend() {
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

	@Override
	public String toString() {
		return "Recommend [spaceNo=" + spaceNo + ", spaceNm=" + spaceNm + ", spaceSubNm=" + spaceSubNm + ", roomPrice="
				+ roomPrice + ", roomFit=" + roomFit + ", like=" + like + ", imgPath=" + imgPath + ", imgName="
				+ imgName + "]";
	}
	
	
	
	
	

}
