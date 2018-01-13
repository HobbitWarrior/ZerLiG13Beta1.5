package Customer;

import java.io.Serializable;

public class Branch implements Serializable
{
	private String branchName;
	private String branchAddress;
	
	public Branch(String branchName, String branchAddress)
	{
		this.branchName  =branchName;
		this.branchAddress = branchAddress;
	}

	public String getBranchName() 
	{
		return branchName;
	}

	public void setBranchName(String branchName) 
	{
		this.branchName = branchName;
	}

	public String getBranchAddress() 
	{
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) 
	{
		this.branchAddress = branchAddress;
	}
}
