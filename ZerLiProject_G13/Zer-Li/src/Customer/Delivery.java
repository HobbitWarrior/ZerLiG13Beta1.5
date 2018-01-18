package Customer;

import java.io.Serializable;

public abstract class Delivery implements Serializable, Cloneable
{
	private int OrderID;
	private int DeliveryID;
	private double Price;
	
	public Delivery(int OrderID, int DeliveryID, double Price )
	{
		this.OrderID=OrderID;
		this.DeliveryID=DeliveryID;
		this.Price=Price;
	}
	
	@Override
	public Object clone () throws CloneNotSupportedException
	{
		return super.clone();
		
	}
	
	
	public Delivery (double Price )
	{
		this.Price=Price;
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) 
	{
		OrderID = orderID;
	}

	public int getDeliveryID() 
	{
		return DeliveryID;
	}

	public void setDeliveryID(int deliveryID) 
	{
		DeliveryID = deliveryID;
	}

	public double getPrice() 
	{
		return Price;
	}

	public void setPrice(double price) 
	{
		Price = price;
	}
	
	
}
