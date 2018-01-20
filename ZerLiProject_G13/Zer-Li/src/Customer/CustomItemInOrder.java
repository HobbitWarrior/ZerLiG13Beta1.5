package Customer;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomItemInOrder extends ItemInOrder implements Serializable
{

	private ArrayList<Flower> flowersInItem;
	public CustomItemInOrder(int orderid, int itemId, String itemName, double price,ArrayList<Flower> flowersInItem) 
	{
		super(orderid, itemId, itemName, price);
		this.flowersInItem = flowersInItem;
	}
	
	public CustomItemInOrder(int itemId, String itemName, double price,ArrayList<Flower> flowersInItem) 
	{
		super(itemId, itemName, price);
		this.flowersInItem = flowersInItem;

	}

	public ArrayList<Flower> getFlowersInItem() 
	{
		return flowersInItem;
	}

	public void setFlowersInItem(ArrayList<Flower> flowersInItem) 
	{
		this.flowersInItem = flowersInItem;
	}



}
