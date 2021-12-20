package getonFast.hj.semi.admin.model.vo;

public class AdSpaceOption {
	private int AdOptionNo;
	private String AdOptionName;
	
	public AdSpaceOption() {
		// TODO Auto-generated constructor stub
	}

	public int getAdOptionNo() {
		return AdOptionNo;
	}

	public void setAdOptionNo(int adOptionNo) {
		AdOptionNo = adOptionNo;
	}

	public String getAdOptionName() {
		return AdOptionName;
	}

	public void setAdOptionName(String adOptionName) {
		AdOptionName = adOptionName;
	}

	@Override
	public String toString() {
		return "AdSpaceOption [AdOptionNo=" + AdOptionNo + ", AdOptionName=" + AdOptionName + "]";
	}
	
}
