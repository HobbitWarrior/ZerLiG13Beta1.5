package Customer;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerTransaction implements Serializable
{	/**this class is responsible for the customer order, and check if payment account exist in table*/
	private int OrderID;
	private int customerID;
	private Delivery OrderCustomerDelivery;
	private String OrderbranchID;
	private Double OrdertotalPrice;
	private Date OrdersupplyDate;
	private Time OrdersupplyTime;
	private Date OrderCompletedDate;
	private Time OrderCompletedTime;
	private String Greeting;
	private String PaymentType;
	private boolean IsExpeditedDelivery;
	private int CompleteStatus=0;
	private String PaymentAccountUserName;
	private String PaymentAccountPassword;
	private ArrayList<ItemInOrder> productsList;
	private boolean isApproved=false;
	private String msgToClient="";
	
	public CustomerTransaction() //constructor is empty because is will be too long to insert attributes
	{
	}


	public int getOrderID() {
		return OrderID;
	}


	public void setOrderID(int orderID) {
		OrderID = orderID;
	}


	public int getCustomerID() {
		return customerID;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


	public Delivery getOrderCustomerDelivery() {
		return OrderCustomerDelivery;
	}


	public void setOrderCustomerDelivery(Delivery orderCustomerDelivery) {
		OrderCustomerDelivery = orderCustomerDelivery;
	}


	public String getOrderbranchID() {
		return OrderbranchID;
	}


	public void setOrderbranchID(String orderbranchID) {
		OrderbranchID = orderbranchID;
	}


	public Double getOrdertotalPrice() {
		return OrdertotalPrice;
	}


	public void setOrderTotalPrice(Double ordertotalPrice) {
		OrdertotalPrice = ordertotalPrice;
	}


	public Date getOrdersupplyDate() {
		return OrdersupplyDate;
	}


	public void setOrderSupplyDate(Date ordersupplyDate) {
		OrdersupplyDate = ordersupplyDate;
	}


	public Time getOrdersupplyTime() {
		return OrdersupplyTime;
	}


	public void setOrdersupplyTime(Time ordersupplyTime) {
		OrdersupplyTime = ordersupplyTime;
	}


	public Date getOrderCompletedDate() {
		return OrderCompletedDate;
	}


	public void setOrderCompletedDate(Date orderCompletedDate) {
		OrderCompletedDate = orderCompletedDate;
	}


	public Time getOrderCompletedTime() {
		return OrderCompletedTime;
	}


	public void setOrderCompletedTime(Time orderCompletedTime) {
		OrderCompletedTime = orderCompletedTime;
	}


	public String getGreeting() {
		return Greeting;
	}


	public void setGreeting(String greeting) {
		Greeting = greeting;
	}


	public String getPaymentType() {
		return PaymentType;
	}


	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}


	public boolean getIsExpeditedDelivery() {
		return IsExpeditedDelivery;
	}


	public void setIsExpeditedDelivery(boolean isExpeditedDelivery) {
		IsExpeditedDelivery = isExpeditedDelivery;
	}


	public int getCompleteStatus() {
		return CompleteStatus;
	}


	public void setCompleteStatus(int completeStatus) {
		CompleteStatus = completeStatus;
	}


	public String getPaymentAccountUserName() {
		return PaymentAccountUserName;
	}


	public void setPaymentAccountUserName(String paymentAccountUserName) {
		PaymentAccountUserName = paymentAccountUserName;
	}


	public String getPaymentAccountPassword() {
		return PaymentAccountPassword;
	}


	public void setPaymentAccountPassword(String paymentAccountPassword) {
		PaymentAccountPassword = paymentAccountPassword;
	}


	public ArrayList<ItemInOrder> getProductsList() {
		return productsList;
	}


	public void setProductsList(ArrayList<ItemInOrder> productsList) {
		this.productsList = productsList;
	}


	public boolean isApproved() {
		return isApproved;
	}


	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}


	public String getMsgToClient() {
		return msgToClient;
	}


	public void setMsgToClient(String msgToClient) {
		this.msgToClient = msgToClient;
	}
	
	
	
}

