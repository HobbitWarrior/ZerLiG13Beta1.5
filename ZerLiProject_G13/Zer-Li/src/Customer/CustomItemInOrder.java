package Customer;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomItemInOrder extends ItemInOrder implements Serializable
{
	private String itemType;
	private ArrayList<Flower> flowersInItem;
	public CustomItemInOrder(int orderid, int itemId, String itemName,String itemType, double price,ArrayList<Flower> flowersInItem) 
	{ 
		super(orderid, itemId, itemName, price);
		this.flowersInItem = flowersInItem;
		this.itemType=itemType;
	}
	
	public CustomItemInOrder(int itemId, String itemName,String itemType, double price,ArrayList<Flower> flowersInItem) 
	{
		super(itemId, itemName, price);
		this.flowersInItem = flowersInItem;
		this.itemType=itemType;

	} 

	public ArrayList<Flower> getFlowersInItem() 
	{
		return flowersInItem;
	}

	public void setFlowersInItem(ArrayList<Flower> flowersInItem) 
	{
		this.flowersInItem = flowersInItem;
	}

	@Override
	public String toString() {
		return "CustomItemInOrder [flowersInItem=" + flowersInItem + ", getOrderID()=" + getOrderID()
				+ ", getItemQty()=" + getItemQty() + ", getItemName()=" + getItemName()
				+ ", getItemTotalPriceWithCoin()=" + getItemTotalPriceWithCoin() + "]" +flowersInItem;
	}

 

}
