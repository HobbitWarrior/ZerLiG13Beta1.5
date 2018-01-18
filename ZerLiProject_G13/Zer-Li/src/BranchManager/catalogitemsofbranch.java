package BranchManager;

import java.io.Serializable;

public class catalogitemsofbranch implements Serializable {

	
	int ItemID;
	String BranchID;
	Double Price;
	public int getItemID() {
		return ItemID;
	}
	public void setItemID(int itemID) {
		ItemID = itemID;
	}
	public String getBranchID() {
		return BranchID;
	}
	public void setBranchID(String branchID) {
		BranchID = branchID;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	@Override
	public String toString() {
		return "catalogitemsofbranch [ItemID=" + ItemID + ", BranchID=" + BranchID + ", Price=" + Price + "]";
	}
	public catalogitemsofbranch(int itemID, String branchID, Double price) {
		super();
		ItemID = itemID;
		BranchID = branchID;
		Price = price;
	}
	
}
