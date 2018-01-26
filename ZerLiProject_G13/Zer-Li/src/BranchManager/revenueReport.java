package BranchManager;

public class revenueReport {
	
	int OrderID;
	double OrderPrice;
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public double getOrderPrice() {
		return OrderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		OrderPrice = orderPrice;
	}
	@Override
	public String toString() {
		return "revenueReport [OrderID=" + OrderID + ", OrderPrice=" + OrderPrice + "]";
	}
	public revenueReport(int orderID, double orderPrice) {
		super();
		OrderID = orderID;
		OrderPrice = orderPrice;
	}
	public revenueReport() {
		super();
	}
	
	

}
