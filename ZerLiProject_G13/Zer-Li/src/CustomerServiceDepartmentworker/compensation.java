package CustomerServiceDepartmentworker;
/**the following class is a entity that contains the data for the compensation that is given
 * by the customer service department
 * @author Alex
 *
 */
public class compensation {
	
	private int compensationID;
	private int customerID;
	private int csde_id;
	private double compensationAmount;
	private String isPaid;
	
	
	
	public  int getCompensationID() {
		return compensationID;
	}
	public void setCompensationID(int compensationID) {
		this.compensationID = compensationID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getCsde_id() {
		return csde_id;
	}
	public void setCsde_id(int csde_id) {
		this.csde_id = csde_id;
	}
	public double getCompensationAmount() {
		return compensationAmount;
	}
	public void setCompensationAmount(double compensationAmount) {
		this.compensationAmount = compensationAmount;
	}
	public String getIsPaid() {
		return isPaid;
	}
	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}
	

}
