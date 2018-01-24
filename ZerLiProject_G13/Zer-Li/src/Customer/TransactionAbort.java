package Customer;

import java.io.Serializable;

public class TransactionAbort implements Serializable
{
	private int orderID;
	private double orderPrice;
	private final double refund;
	boolean commit=false;
	
	public TransactionAbort(int orderID,double orderPrice , double refund) 
	{
		super();
		this.orderID = orderID;
		this.orderPrice=orderPrice;
		this.refund = refund;
	}


	public int getOrderID() {
		return orderID;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	public double getRefund() {
		return refund;
	}


	@Override
	public String toString() 
	{
		return " Order No:"+this.orderID+" will get --> "+(this.refund*100 )+"% refund!!!";
	}
	
	public boolean isCommit() {
		return commit;
	}


	public void setCommit(boolean commit) {
		this.commit = commit;
	}


	public double getOrderPrice() {
		return orderPrice;
	}


	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	
}
