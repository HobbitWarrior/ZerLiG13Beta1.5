package Customer;

import java.io.Serializable;

public abstract class Delivery implements Serializable
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
