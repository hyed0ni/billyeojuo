package getonFast.hj.semi.admin.model.vo;

public class AdSpaceOption {
	private int adOptionNo;
	private String adOptionName;
	
	public AdSpaceOption() {
		// TODO Auto-generated constructor stub
	}

	public int getAdOptionNo() {
		return adOptionNo;
	}

	public void setAdOptionNo(int adOptionNo) {
		this.adOptionNo = adOptionNo;
	}

	public String getAdOptionName() {
		return adOptionName;
	}

	public void setAdOptionName(String adOptionName) {
		this.adOptionName = adOptionName;
	}

	@Override
	public String toString() {
		return "AdSpaceOption [adOptionNo=" + adOptionNo + ", adOptionName=" + adOptionName + "]";
	}


}
