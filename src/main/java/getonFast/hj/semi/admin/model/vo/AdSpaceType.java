package getonFast.hj.semi.admin.model.vo;

public class AdSpaceType {
	private int AdSpaceTypeNo;
	private String AdSpaceTypeName;
	private String AdSpaceTypeStatus;
	
	public AdSpaceType() {
	}

	public int getAdSpaceTypeNo() {
		return AdSpaceTypeNo;
	}

	public void setAdSpaceTypeNo(int adSpaceTypeNo) {
		AdSpaceTypeNo = adSpaceTypeNo;
	}

	public String getAdSpaceTypeName() {
		return AdSpaceTypeName;
	}

	public void setAdSpaceTypeName(String adSpaceTypeName) {
		AdSpaceTypeName = adSpaceTypeName;
	}

	public String getAdSpaceTypeStatus() {
		return AdSpaceTypeStatus;
	}

	public void setAdSpaceTypeStatus(String adSpaceTypeStatus) {
		AdSpaceTypeStatus = adSpaceTypeStatus;
	}

	@Override
	public String toString() {
		return "AdSpaceType [AdSpaceTypeNo=" + AdSpaceTypeNo + ", AdSpaceTypeName=" + AdSpaceTypeName
				+ ", AdSpaceTypeStatus=" + AdSpaceTypeStatus + "]";
	}
	
	
}
