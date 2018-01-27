package BranchManager;

public class CompliantReport {
	int CountOfCompliants;
	String branchID;
	public int getCountOfCompliants() {
		return CountOfCompliants;
	}
	public void setCountOfCompliants(int countOfCompliants) {
		CountOfCompliants = countOfCompliants;
	}
	public String getBranchID() {
		return branchID;
	}
	public void setBranchID(String branchID) {
		this.branchID = branchID;
	}
	@Override
	public String toString() {
		return "CompliantReport [CountOfCompliants=" + CountOfCompliants + ", branchID=" + branchID + "]";
	}
	public CompliantReport(int countOfCompliants, String branchID) {
		super();
		CountOfCompliants = countOfCompliants;
		this.branchID = branchID;
	}
	public CompliantReport() {
		super();
	}
	

}
