package CustomerServiceDepartmentworker;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
/**a complaint Entity that used for the data binding in the GUI,
 * used mainly in the CustomerServiceDepartmentworkerMainWindow controller
 * 
 * @author Alex
 *
 */
public class complaintEntry {

	public SimpleIntegerProperty CompliantID;
	public SimpleIntegerProperty CustomerID;
	public SimpleIntegerProperty EmpHandlingID;
	public SimpleStringProperty Topic;
	public SimpleStringProperty Time;
	public SimpleStringProperty Date;
	public SimpleStringProperty Status;
	public SimpleStringProperty details;
	
	
	
	public complaintEntry()
	{
		CompliantID=new SimpleIntegerProperty();
		CustomerID=new SimpleIntegerProperty();
		EmpHandlingID=new SimpleIntegerProperty();
		Topic =new SimpleStringProperty();
		Time=new SimpleStringProperty();
		Date=new SimpleStringProperty();
		Status=new SimpleStringProperty();
		details=new SimpleStringProperty();
		
	}
	public complaintEntry(complaint c)
	{
		this();
		
		setCompliantID(c.getComplaintID());
		setCustomerID(c.getCustomerID());
		setTime(c.getTimeComplaint());
		setDate(c.getDateComplaint());
		setDetails(c.getDetails());
		setEmpHandlingID(c.getEmpHandling());
		setStatus(c.getStatus());
		setTopic(c.getTopic());
		
	}
	
	
	
	public SimpleIntegerProperty getCompliantID() {
		return CompliantID;
	}
	public void setCompliantID(int compliantID) {
		CompliantID.setValue(compliantID);
	}
	public SimpleStringProperty getCustomerID() {
		return new SimpleStringProperty(String.valueOf(CustomerID.getValue()));
	}
	public SimpleIntegerProperty getCustomerIDInteger()
	{
		return CustomerID;
	}
	
	public void setCustomerID(int customerID) {
		CustomerID.setValue(customerID);
	}
	public SimpleStringProperty getEmpHandlingIDString() {
		return new SimpleStringProperty(String.valueOf(EmpHandlingID.getValue()));
	}
	public SimpleIntegerProperty getEmpHandlingID()
	{
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
