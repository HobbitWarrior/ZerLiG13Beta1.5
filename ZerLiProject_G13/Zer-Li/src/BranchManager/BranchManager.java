package BranchManager;

import java.io.Serializable;

public class BranchManager implements Serializable
{
	private int branchManagerID;
	private String branchManagerName;
	private String branchManagerEmail;
	private String branchID;
	
	
	
	public BranchManager(int branchManagerID, String branchManagerName, String branchManagerEmail, String branchID) {
		super();
		this.branchManagerID = branchManagerID;
		this.branchManagerName = branchManagerName;
		this.branchManagerEmail = branchManagerEmail;
		this.branchID = branchID;
	}
	public int getBranchManagerID() {
		return branchManagerID;
	}
	public void setBranchManagerID(int branchManagerID) {
		this.branchManagerID = branchManagerID;
	}
	public String getBranchManagerName() {
		return branchManagerName;
	}
	public void setBranchManagerName(String branchManagerName) {
		this.branchManagerName = branchManagerName;
	}
	public String getBranchManagerEmail() {
		return branchManagerEmail;
	}
	public void setBranchManagerEmail(String branchManagerEmail) {
		this.branchManagerEmail = branchManagerEmail;
	}
	public String getBranchID() {
		return branchID;
	}
	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}

	
	@Override
	public String toString() {
		return "BranchManager [branchManagerID=" + branchManagerID + ", branchManagerName=" + branchManagerName
				+ ", branchManagerEmail=" + branchManagerEmail + ", branchID=" + branchID + "]";
	}
}
