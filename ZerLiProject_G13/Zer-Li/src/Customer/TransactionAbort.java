package Customer;

import java.io.Serializable;

public class TransactionAbort implements Serializable
{
	private int orderID;
	private final double refund;
	
	
	public TransactionAbort(int orderID, double refund) 
	{
		super();
		this.orderID = orderID;
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
	
	
	
}
