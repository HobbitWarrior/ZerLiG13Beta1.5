package CustomerServiceDepartmentworker;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class complaintEntry {

	public SimpleIntegerProperty CompliantID;
	public SimpleIntegerProperty CustomerID;
	public SimpleIntegerProperty EmpHandlingID;
	public SimpleStringProperty Topic;
	public SimpleStringProperty Time;
	public SimpleStringProperty Date;
	public SimpleStringProperty Status;
	public SimpleStringProperty details;
	
	
	
	
	
	public SimpleIntegerProperty getCompliantID() {
		return CompliantID;
	}
	public void setCompliantID(int compliantID) {
		CompliantID.setValue(compliantID);;
	}
	public SimpleIntegerProperty getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID.setValue(customerID);
	}
	public SimpleIntegerProperty getEmpHandlingID() {
		return EmpHandlingID;
	}
	public void setEmpHandlingID(int empHandlingID) {
		EmpHandlingID.setValue(empHandlingID);
	}
	public SimpleStringProperty getTopic() {
		return Topic;
	}
	public void setTopic(String topic) {
		Topic.setValue(topic);;
	}
	public SimpleStringProperty getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time.setValue(time);
	}
	public SimpleStringProperty getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date.setValue(date);
	}
	public SimpleStringProperty getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status.setValue(status);
	}
	public SimpleStringProperty getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details.setValue(details);
	}
	
	
	
	
}
