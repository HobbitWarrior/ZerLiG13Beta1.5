package CustomerServiceDepartmentworker;

import java.io.Serializable;

public class complaintProgress implements Serializable {

	/**
	 * <h1>complaintProgress Fileds</h>
	 * <p>
	 * keeps the entries to be sent to the DB
	 * 
	 * @author Alex
	 *         </p>
	 */
	private int ComplaintID;
	private int EmpHandlingID;
	private String Topic;
	private String Details;

	public complaintProgress(int complaintID, int empHandlingID, String topic, String details) {
		// set the fields
		setComplaintID(complaintID);
		setEmpHandlingID(empHandlingID);
		setTopic(topic);
		setDetails(details);
	}

	public int getComplaintID() {
		return ComplaintID;
	}

	public void setComplaintID(int complaintID) {
		this.ComplaintID = complaintID;
	}

	public int getEmpHandlingID() {
		return EmpHandlingID;
	}

	public void setEmpHandlingID(int empHandlingID) {
		EmpHandlingID = empHandlingID;
	}

	public String getTopic() {
		return Topic;
	}

	public void setTopic(String topic) {
		Topic = topic;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

}
