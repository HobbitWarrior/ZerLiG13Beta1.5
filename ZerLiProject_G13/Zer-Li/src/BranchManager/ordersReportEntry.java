package BranchManager;
/***Holds each entry of the sales report ***/
public class ordersReportEntry {
	private int itemType;
	private int itemQuantity;
	
	public ordersReportEntry(int ItemType,int ItemQuantity)
	{
		itemType=ItemType;
		itemQuantity=ItemQuantity;
	}

	public int getItemType() {
		return itemType;
	}

	public void setItemType(int itemType) {
		this.itemType = itemType;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

}
