package BranchWorker;

import java.io.Serializable;
/**
 * 
 * @author Sharon & Elias
 *
 */
public class Customer implements Serializable {
	int customerID;
	String customerName;
	String customerlastName;
	String  address;
	String  email;
	int  phoneNumber;
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerlastName() {
		return customerlastName;
	}
	public void setCustomerlastName(String customerlastName) {
		this.customerlastName = customerlastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Customer(int customerID, String customerName, String customerlastName, String address, String email,
			int phoneNumber) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerlastName = customerlastName;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerlastName="
				+ customerlastName + ", address=" + address + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	public Customer() {
		super();
	}
	

}
