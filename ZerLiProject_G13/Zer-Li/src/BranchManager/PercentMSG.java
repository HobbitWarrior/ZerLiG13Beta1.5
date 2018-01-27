package BranchManager;

import java.io.Serializable;

public class PercentMSG implements Serializable {

	String itemId;
	String Percent ;
	String BranchID;
	public PercentMSG(String itemId, String percent, String BranchID) 
	{
		this.itemId = itemId;
		Percent = percent;
		this.BranchID=BranchID;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getPercent() {
		return Percent;
	}
	public void setPercent(String percent) {
		Percent = percent;
	}

	@Override
	public String toString() {
		return "PercentMSG [itemId=" + itemId + ", Percent=" + Percent + "]";
	}
	public String getBranchID() {
		return BranchID;
	}
	public void setBranchID(String branchID) {
		BranchID = branchID;
	}
	
	
}
