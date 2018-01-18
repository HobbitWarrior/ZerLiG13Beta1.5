package Customer;

import java.io.Serializable;

public class PrivateShipment extends Delivery implements Serializable
{
	
	private String addressee;
	private String address;
	private String phoneNumber;
	
	public PrivateShipment(int OrderID, int DeliveryID, double Price, String addressee, String address, String phoneNumber ) 
	{
		super(OrderID, DeliveryID, Price);
		this.addressee=addressee;
		this.address=address;
		this.phoneNumber=phoneNumber;
	}
	
	public PrivateShipment( double Price, String addressee, String address, String phoneNumber ) 
	{
		super( Price);
		this.addressee=addressee;
		this.address=address;
		this.phoneNumber=phoneNumber;
	}

	public String getAddressee() 
	{
		return addressee;
	}

	public void setAddressee(String addressee) 
	{
		this.addressee = addressee;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getPhoneNumber() 
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "PrivateShipment [addressee=" + addressee + ", address=" + address + ", phoneNumber=" + phoneNumber
				+ "]";
	}
	
	
}
