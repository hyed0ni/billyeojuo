package getonFast.hj.semi.admin.model.vo;

public class AdRoomtype {
	private int roomNo;
	private int spaceNo;
	private String roomName;
	private int roomPrice;
	private String roomDesc;
	private String roomFit;
	private int optionNo;
	private String roomImg;
	
	public AdRoomtype() {
		// TODO Auto-generated constructor stub
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getSpaceNo() {
		return spaceNo;
	}

	public void setSpaceNo(int spaceNo) {
		this.spaceNo = spaceNo;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRoomDesc() {
		return roomDesc;
	}

	public void setRoomDesc(String roomDesc) {
		this.roomDesc = roomDesc;
	}

	public String getRoomFit() {
		return roomFit;
	}

	public void setRoomFit(String roomFit) {
		this.roomFit = roomFit;
	}
	
	public int getOptionNo() {
		return optionNo;
	}
	
	public void setOptionNo(int optionNo) {
		this.optionNo = optionNo;
	}
	
	public String getRoomImg() {
		return roomImg;
	}

	public void setRoomImg(String roomImg) {
		this.roomImg = roomImg;
	}

	@Override
	public String toString() {
		return "AdRoomtype [roomNo=" + roomNo + ", spaceNo=" + spaceNo + ", roomName=" + roomName + ", roomPrice="
				+ roomPrice + ", roomDesc=" + roomDesc + ", roomFit=" + roomFit + ", optionNo=" + optionNo
				+ ", roomImg=" + roomImg + "]";
	}


	
}
