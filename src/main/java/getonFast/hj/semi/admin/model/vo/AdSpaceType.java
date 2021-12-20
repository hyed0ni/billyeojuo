package getonFast.hj.semi.admin.model.vo;

public class AdSpaceType {
	private int adSpaceTypeNo;
	private String adSpaceTypeName;
	private String adSpaceTypeStatus;
	
	public AdSpaceType() {
	}

	public int getAdSpaceTypeNo() {
		return adSpaceTypeNo;
	}

	public void setAdSpaceTypeNo(int adSpaceTypeNo) {
		this.adSpaceTypeNo = adSpaceTypeNo;
	}

	public String getAdSpaceTypeName() {
		return adSpaceTypeName;
	}

	public void setAdSpaceTypeName(String adSpaceTypeName) {
		this.adSpaceTypeName = adSpaceTypeName;
	}

	public String getAdSpaceTypeStatus() {
		return adSpaceTypeStatus;
	}

	public void setAdSpaceTypeStatus(String adSpaceTypeStatus) {
		this.adSpaceTypeStatus = adSpaceTypeStatus;
	}

	@Override
	public String toString() {
		return "AdSpaceType [adSpaceTypeNo=" + adSpaceTypeNo + ", adSpaceTypeName=" + adSpaceTypeName
				+ ", adSpaceTypeStatus=" + adSpaceTypeStatus + "]";
	}

	
	
	
	
}
