package CustomerServiceDepartmentworker;

import java.io.Serializable;

public class closingComplaint implements Serializable {
	private int complaintID;
	private int cutsomerID;
	private String details;
	
	closingComplaint(closingComplaintEntry cce)
	{
		setComplaintID(cce.getComplaintID().getValue());
		setCutsomerID(cce.getCustomerID().getValue());
		setDetails(cce.getDetails().getValue());
	}
	
	
	
	public int getComplaintID() {
		return complaintID;
	}
	public void setComplaintID(int complaintID) {
		this.complaintID = complaintID;
	}
	public int getCutsomerID() {
		return cutsomerID;
	}
	public void setCutsomerID(int cutsomerID) {
		this.cutsomerID = cutsomerID;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	

}
