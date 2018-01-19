package BranchManager;

import java.io.Serializable;

public class PercentMSG implements Serializable {

	String itemId;
	String Percent ;
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
	public PercentMSG(String itemId, String percent) {
		super();
		this.itemId = itemId;
		Percent = percent;
	}
	@Override
	public String toString() {
		return "PercentMSG [itemId=" + itemId + ", Percent=" + Percent + "]";
	}
	
	
}
