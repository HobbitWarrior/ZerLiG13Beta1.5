package CustomerServiceDepartmentworker;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;

public class progressEntry {
	/***
	 * <h1>complaint progress GUI binding</h1>
	 * <p>
	 * the Following class is used for the binding of the progressComplaintWindow
	 * GUI
	 * 
	 * @author Alex
	 *         </p>
	 * 
	 */

	private SimpleIntegerProperty ComplaintID;
	private SimpleIntegerProperty EmpHandlingId;
	private SimpleStringProperty Topic;
	private SimpleStringProperty Details;

	// setters and getters
	public SimpleIntegerProperty getComplaintID() {
		return ComplaintID;
	}

	public void setComplaintID(int complaintID) {
		ComplaintID.setValue(complaintID);
	}

	public SimpleIntegerProperty getEmpHandlingId() {
		return EmpHandlingId;
	}

	public void setEmpHandlingId(int empHandlingId) {
		EmpHandlingId.setValue(empHandlingId);
	}

	public SimpleSetProperty getTopic() {
		return Topic;
	}

	public void setTopic(String topic) {
		Topic.setValue(topic);
	}

	public SimpleStringProperty getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details.setValue(details); 
	}

}
