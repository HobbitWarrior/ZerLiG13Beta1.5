package Customer;

import java.io.Serializable;

public class BranchShipment extends Delivery implements Serializable
{
	private String BranchName;
	private String BranchAdress;
	
	public BranchShipment(int OrderID, int DeliveryID, String BranchName, String BranchAdress) 
	{
		super(OrderID,DeliveryID, 0 ); //we sending 0 because self arrival is free of charge
		this.BranchName = BranchName;
		this.BranchAdress=BranchAdress;
	}

	public BranchShipment(String BranchName,String BranchAdress) 
	{
		super(0);
		this.BranchName = BranchName;
		this.BranchAdress=BranchAdress;
	}

	public String getBranchName() 
	{
		return BranchName;
	}

	public void setBranchName(String branchName) 
	{
		BranchName = branchName;
	}
	
	public String getBranchAdress()
	{
		return this.BranchAdress;
	}
	
	public void setBranchAdress(String BranchAdress)
	{
		this.BranchAdress=BranchAdress;
	}
}
