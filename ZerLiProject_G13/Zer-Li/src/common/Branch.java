package common;

public class Branch 
{
	private String branchName;
	private String brancAdress;
	
	
	public Branch(String branchName, String brancAdress)
	{
		this.branchName = branchName;
		this.brancAdress = brancAdress;
	}
	
	
	
	
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBrancAdress() {
		return brancAdress;
	}
	public void setBrancAdress(String brancAdress) {
		this.brancAdress = brancAdress;
	}

}
