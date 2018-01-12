package Customer;

import java.text.DecimalFormat;
import java.util.Comparator;

import javafx.collections.ObservableList;

public class ItemInOrder implements Comparable 
{
	private Integer orderID= null;
	private int itemID;
	private String itemName;
	private int itemQty = 0;
	private double itemPrice=0;
	private double itemTotalPrice=0;
	private String itemTotalPriceWithCoin="";


	public ItemInOrder(int itemId,String itemName, double price)
	{
		this.itemID = itemId;
		this.itemName = itemName;
		this.itemPrice = price;
		this.itemTotalPrice = this.itemPrice;
		itemTotalPriceWithCoin=""+itemTotalPrice+"$";
		this.itemQty=1;
	}
	
	public ItemInOrder(int orderid, int itemId,String itemName, double price)
	{
		this.orderID = new Integer(orderid);
		this.itemID = itemId;
		this.itemName = itemName;
		this.itemPrice = price;
		this.itemTotalPrice = this.itemPrice;
		itemTotalPriceWithCoin=""+itemTotalPrice+"$";

		this.itemQty=1;	
	}
	
	@Override
	public int compareTo(Object anotherItemInOrder) 
	{
		if(anotherItemInOrder instanceof ItemInOrder) 
		{
			if( ((ItemInOrder)anotherItemInOrder).getItemID()==this.itemID )
			{
				Integer newOrderID=((ItemInOrder)anotherItemInOrder).getOrderID();
				Integer oldOrderID=  this.orderID ;
				
				if(newOrderID==null && oldOrderID==null)
				{
					return 1;

				}
				else if( oldOrderID == newOrderID )
				{
					return 1;

				}
			}

		}
		return 0;

	}

	public Integer getOrderID() 
	{
		return orderID;
	}

	public void setOrderID(int orderID) 
	{
		this.orderID = orderID;
	}

	public int getItemID() 
	{
		return itemID;
	}

	public int getItemQty() 
	{
		return itemQty;
	}

	public void setItemQty(int itemQty) 
	{
		this.itemQty = itemQty;
		this.itemTotalPrice=this.itemPrice*itemQty;
		this.itemTotalPrice=this.itemTotalPrice*100/100;
		this.itemTotalPriceWithCoin=""+this.itemTotalPrice+"$";
	}

	public double getItemPrice() 
	{
		return itemPrice;
	}
	
	public void setItemPrice(double itemSinglePrice) 
	{
		this.itemPrice=itemSinglePrice;
		this.itemTotalPrice=this.itemQty*this.itemPrice;
	}
	
	public double getTotalPrice()
	{
		return this.itemTotalPrice;
	}
	
	public void incQty()
	{
		this.itemQty++;
		this.itemTotalPrice=this.itemTotalPrice + this.itemPrice;
	}
	
	

	public void decQty()
	{
		this.itemQty--;
		this.itemTotalPrice=this.itemTotalPrice - this.itemPrice;

	}

	public String getItemName() 
	{
		return itemName;
	}

	public void setItemName(String itemName) 
	{
		this.itemName = itemName;
	}

	public String getItemTotalPriceWithCoin()
	{
		return this.itemTotalPriceWithCoin;
	}
	
	public void setItemTotalPriceWithCoin(String newPrice)
	{
		this.itemTotalPriceWithCoin = newPrice;
	}
	
	

}
