package getonFast.hj.semi.admin.model.vo;

public class AdSpaceRoomOption {
	
	private int roomNo;
	private int OptionNo;

	public AdSpaceRoomOption() {
		// TODO Auto-generated constructor stub
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int spaceNo) {
		this.roomNo = spaceNo;
	}

	public int getOptionNo() {
		return OptionNo;
	}

	public void setOptionNo(int optionNo) {
		OptionNo = optionNo;
	}

	@Override
	public String toString() {
		return "AdSpaceRoomOption [RoomNo=" + roomNo + ", OptionNo=" + OptionNo + "]";
	}

	
	
	
}
