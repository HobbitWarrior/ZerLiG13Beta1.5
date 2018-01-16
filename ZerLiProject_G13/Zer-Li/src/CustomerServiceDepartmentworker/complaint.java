package CustomerServiceDepartmentworker;

import java.io.Serializable;

public class complaint implements Serializable {
	/*
	 * This class is the 'complaints' entity it will store a single entry form the
	 * DB
	 */
	private int ComplaintID;
	private int CustomerID;
	private int EmpHandling;
	private String Topic;
	private String TimeComplaint;
	private String DateComplaint;
	private String Status;
	private String Details;

	public complaint(int ComplaintID, int CustomerID, int EmpHandling, String Topic, String TimeComplaint,
			String DateComplaint, String Status, String Details) {
		setComplaintID(ComplaintID);
		setCustomerID(CustomerID);
		setEmpHandling(EmpHandling);
		setTopic(Topic);
		setTimeComplaint(TimeComplaint);
		setDateComplaint(DateComplaint);
		setStatus(Status);
		setDetails(Details);
	}

	public int getComplaintID() {
		return ComplaintID;
	}

	public void setComplaintID(int complaintID) {
		ComplaintID = complaintID;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public int getEmpHandling() {
		return EmpHandling;
	}

	public void setEmpHandling(int empHandling) {
		EmpHandling = empHandling;
	}

	public String getTopic() {
		return Topic;
	}

	public void setTopic(String topic) {
		Topic = topic;
	}

	public String getTimeComplaint() {
		return TimeComplaint;
	}

	public void setTimeComplaint(String timeComplaint) {
		TimeComplaint = timeComplaint;
	}

	public String getDateComplaint() {
		return DateComplaint;
	}

	public void setDateComplaint(String dateComplaint) {
		DateComplaint = dateComplaint;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public void setDetails(String details) {
		Details = details;
	}
	
	public String getDetails()
	{
		return Details;
	}

}
