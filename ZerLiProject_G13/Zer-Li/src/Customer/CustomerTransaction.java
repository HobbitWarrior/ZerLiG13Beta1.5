package Customer;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomerTransaction implements Serializable
{	/**this class is responsible for the customer order, and check if payment account exist in table*/
	private int OrderID;
	private int customerID;
	private Delivery OrderCustomerDelivery;
	private String OrderbranchID;
	private String branchName;	//
	private Double OrdertotalPrice;
	private Date OrdersupplyDate;
	private String supplyDateStr="";	//
	private MyTime OrdersupplyTime;
	private String supplyTimeStr="";	//
	private Date OrderCompletedDate;
	private MyTime OrderCompletedTime;
	private String Greeting;
	private String PaymentType;
	private boolean IsExpeditedDelivery;
	private int CompleteStatus=0;
	private String PaymentAccountUserName;
	private String PaymentAccountPassword;
	private ArrayList<ItemInOrder> productsList;
	private boolean isApproved=false;
	private String orderPriceWithCoin="";
	private String msgToClient="";
	private String msgToServer="";

	
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


	public void setOrderTotalPrice(Double ordertotalPrice) 
	{
		OrdertotalPrice = ordertotalPrice;
		orderPriceWithCoin=""+OrdertotalPrice+" $";
	}


	public Date getOrdersupplyDate() {
		return OrdersupplyDate;
	}


	public void setOrderSupplyDate(Date ordersupplyDate) {
		OrdersupplyDate = ordersupplyDate;
	}


	public MyTime getOrdersupplyTime() {
		return OrdersupplyTime;
	}


	public void setOrdersupplyTime(MyTime ordersupplyTime) {
		OrdersupplyTime = ordersupplyTime;
	}


	public Date getOrderCompletedDate() {
		return OrderCompletedDate;
	}


	public void setOrderCompletedDate(Date orderCompletedDate) {
		OrderCompletedDate = orderCompletedDate;
	}


	public MyTime getOrderCompletedTime() {
		return OrderCompletedTime;
	}


	public void setOrderCompletedTime(MyTime orderCompletedTime) {
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


	public String getOrderPriceWithCoin() {
		return orderPriceWithCoin;
	}


	public void setOrderPriceWithCoin(String orderPriceWithCoin) {
		this.orderPriceWithCoin = orderPriceWithCoin;
	}


	public String getBranchName() {
		return branchName;
	}


	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}


	public String getSupplyDateStr() {
		return supplyDateStr;
	}


	public void setSupplyDateStr(String supplyDateStr) 
	{
		String dateStrToIsrael=""+supplyDateStr.substring(8, supplyDateStr.length())+"/"+supplyDateStr.substring(5, 7)+"/"+supplyDateStr.substring(0, 4);
		
		this.supplyDateStr = dateStrToIsrael;
	}


	public String getSupplyTimeStr() {
		return supplyTimeStr;
	}


	public void setSupplyTimeStr(String supplyTimeStr) 
	{
		

		
		this.supplyTimeStr = supplyTimeStr;
	}


	public String getMsgToServer() {
		return msgToServer;
	}


	public void setMsgToServer(String msgToServer) {
		this.msgToServer = msgToServer;
	}


	@Override
	public String toString() {
		return "CustomerTransaction [OrderID=" + OrderID + ", customerID=" + customerID + ", OrderbranchID="
				+ OrderbranchID + ", branchName=" + branchName + ", OrdertotalPrice=" + OrdertotalPrice
				+ ", OrdersupplyDate=" + OrdersupplyDate + ", OrdersupplyTime=" + OrdersupplyTime + "]";
	}
	
	
	
}

