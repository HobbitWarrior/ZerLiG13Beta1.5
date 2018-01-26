package CustomerServiceDepartmentworker;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class closingComplaintEntry {
	
	
	private SimpleIntegerProperty complaintID;
	private SimpleIntegerProperty customerID;
	private SimpleStringProperty details;
	
	
	
	public closingComplaintEntry(int ComplaintID,int CustomerID,String Details)
	{
		complaintID=new SimpleIntegerProperty();
		customerID=new SimpleIntegerProperty();
		details=new SimpleStringProperty();
		
		setComplaintID(ComplaintID);
		setCustomerID(CustomerID);
		setDetails(Details);
		
		
	}



	public SimpleIntegerProperty getComplaintID() {
		return complaintID;
	}



	public void setComplaintID(int ComplaintID) {
		this.complaintID.setValue(ComplaintID);
	}



	public SimpleIntegerProperty getCustomerID() {
		return customerID;
	}



	public void setCustomerID(int CustomerID) {
		this.customerID.setValue(CustomerID);
	}



	public SimpleStringProperty getDetails() {
		return details;
	}



	public void setDetails(String Details) {
		this.details.setValue(Details);
	}

}
