package CustomerServiceDepartmentworker;

import java.io.Serializable;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class complaint implements Serializable {
	/*
	 * This class is the 'complaints' entity it will store a single entry form the
	 * DB
	 */
	private SimpleIntegerProperty ComplaintID;
	private SimpleIntegerProperty CustomerID;
	private SimpleIntegerProperty EmpHandling;
	private SimpleStringProperty Topic;
	private SimpleStringProperty TimeComplaint;
	private SimpleStringProperty DateComplaint;
	private SimpleStringProperty Status;
	private SimpleStringProperty Details;

	public complaint(int complaintID, int customerID, int empHandling, String topic, String timeComplaint,
			String dateComplaint, String status, String details) {

		//Generate and instantiate the properties
		ComplaintID = new SimpleIntegerProperty(complaintID);
		CustomerID = new SimpleIntegerProperty(customerID);
		EmpHandling = new SimpleIntegerProperty(empHandling);
		Topic = new SimpleStringProperty(topic);
		TimeComplaint = new SimpleStringProperty(timeComplaint);
		DateComplaint = new SimpleStringProperty(timeComplaint);
		Status = new SimpleStringProperty(status);
		Details = new SimpleStringProperty(details);
	}

	public int getComplaintID() {
		return ComplaintID.getValue();
	}

	public void setComplaintID(int complaintID) {
		ComplaintID.setValue(complaintID);
		;
	}

	public int getCustomerID() {
		return CustomerID.getValue();
	}

	public void setCustomerID(int customerID) {
		CustomerID.set(customerID);
		;
	}

	public int getEmpHandling() {
		return EmpHandling.getValue();
	}

	public void setEmpHandling(int empHandling) {
		EmpHandling.setValue(empHandling);
		;
	}

	public String getTopic() {
		return Topic.getValue();
	}

	public void setTopic(String topic) {
		Topic.setValue(topic);
	}

	public String getTimeComplaint() {
		return TimeComplaint.getValue();
	}

	public void setTimeComplaint(String timeComplaint) {
		TimeComplaint.setValue(timeComplaint);
	}

	public String getDateComplaint() {
		return DateComplaint.getValue();
	}

	public void setDateComplaint(String dateComplaint) {
		DateComplaint.setValue(dateComplaint);
	}

	public String getStatus() {
		return Status.getValue();
	}

	public void setStatus(String status) {
		Status.setValue(status);
	}

	public void setDetails(String details) {
		Details.setValue(details);
	}

	public String getDetails() {
		return Details.getValue();
	}

	// setters and getters to support the GUI
	/*
	 * private SimpleIntegerProperty ComplaintID; private SimpleIntegerProperty
	 * CustomerID; private SimpleIntegerProperty EmpHandling; private
	 * SimpleStringProperty Topic; private SimpleStringProperty TimeComplaint;
	 * private SimpleStringProperty DateComplaint; private SimpleStringProperty
	 * Status; private SimpleStringProperty Details;
	 */

	public Property<String> ComplaintTopicGUIGetter() {
		return Topic;
	}

}
