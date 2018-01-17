package Customer;

import java.io.Serializable;

public class CustomerOrder implements Serializable
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
	private String IsExpeditedDelivery;
	private int CompleteStatus=0;
	private String PaymentAccountUserName;
	private String PaymentAccountPassword;
	
	
	public CustomerOrder(int orderID, int customerID, Delivery ordercustomerDelivery, String orderbranchID,
			Double ordertotalPrice, Date ordersupplyDate, Time ordersupplyTime, Date orderCompletedDate,
			Time orderCompletedTime, String greeting, String paymentType, String isExpeditedDelivery,
			int completeStatus, String paymentAccountUserName, String paymentAccountPassword) 
	{
		OrderID = orderID;
		this.customerID = customerID;
		OrderCustomerDelivery = ordercustomerDelivery;
		OrderbranchID = orderbranchID;
		OrdertotalPrice = ordertotalPrice;
		OrdersupplyDate = ordersupplyDate;
		OrdersupplyTime = ordersupplyTime;
		OrderCompletedDate = orderCompletedDate;
		OrderCompletedTime = orderCompletedTime;
		Greeting = greeting;
		PaymentType = paymentType;
		IsExpeditedDelivery = isExpeditedDelivery;
		CompleteStatus = completeStatus;
		PaymentAccountUserName = paymentAccountUserName;
		PaymentAccountPassword = paymentAccountPassword;
	}


	public CustomerOrder(int customerID, Delivery orderCustomerDelivery, String orderbranchID, Double ordertotalPrice,
			Date ordersupplyDate, Time ordersupplyTime, Date orderCompletedDate, Time orderCompletedTime,
			String greeting, String paymentType, String isExpeditedDelivery, String paymentAccountUserName,
			String paymentAccountPassword) {
		super();
		this.customerID = customerID;
		OrderCustomerDelivery = orderCustomerDelivery;
		OrderbranchID = orderbranchID;
		OrdertotalPrice = ordertotalPrice;
		OrdersupplyDate = ordersupplyDate;
		OrdersupplyTime = ordersupplyTime;
		OrderCompletedDate = orderCompletedDate;
		OrderCompletedTime = orderCompletedTime;
		Greeting = greeting;
		PaymentType = paymentType;
		IsExpeditedDelivery = isExpeditedDelivery;
		PaymentAccountUserName = paymentAccountUserName;
		PaymentAccountPassword = paymentAccountPassword;
		this.CompleteStatus=0;	//0= not supplyied, 1 =supplyed
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


	public void setOrdertotalPrice(Double ordertotalPrice) {
		OrdertotalPrice = ordertotalPrice;
	}


	public Date getOrdersupplyDate() {
		return OrdersupplyDate;
	}


	public void setOrdersupplyDate(Date ordersupplyDate) {
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


	public String getIsExpeditedDelivery() {
		return IsExpeditedDelivery;
	}


	public void setIsExpeditedDelivery(String isExpeditedDelivery) {
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

	
	
	
	
	
}



