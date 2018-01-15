package Customer;

import java.io.Serializable;

public class branchShipment extends Delivery implements Serializable
{
	private String BranchName;
	
	public branchShipment(int OrderID, int DeliveryID, String BranchName) 
	{
		super(OrderID,DeliveryID, 0 ); //we sending 0 because self arrival is free of charge
		this.BranchName = BranchName;
	}

	public branchShipment(String BranchName) 
	{
		super(0);
		this.BranchName = BranchName;
	}

	public String getBranchName() 
	{
		return BranchName;
	}

	public void setBranchName(String branchName) 
	{
		BranchName = branchName;
	}
}
