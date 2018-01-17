package Customer;

import java.io.Serializable;

public class MessgaeCatalogProduct implements Serializable	/**this is a message class to get catalog items of a branch!!*/
{
	private final String msg = "Give Me All CatalogItems";
	private String branchID="";
	public MessgaeCatalogProduct(String branchID) 
	{
		this.branchID = branchID;
	}
	public String getBranchID() 
	{
		return branchID;
	}
	public void setBranchID(String branchID) 
	{
		this.branchID = branchID;
	}
	public String getMsg() 
	{
		return msg;
	}
}
