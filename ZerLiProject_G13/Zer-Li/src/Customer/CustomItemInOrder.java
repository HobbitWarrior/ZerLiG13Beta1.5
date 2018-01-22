package Customer;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomItemInOrder extends ItemInOrder implements Serializable
{
	private String itemType;
	private ArrayList<Flower> flowersInItem;
	private String itemDominantColor="";
	public CustomItemInOrder(int orderid, int itemId, String itemName,String itemType, double price,ArrayList<Flower> flowersInItem,String itemDominantColor) 
	{ 
		super(orderid, itemId, itemName, price);
		this.flowersInItem = flowersInItem;
		this.itemType=itemType;
		this.itemDominantColor=itemDominantColor;
	} 
	
	public CustomItemInOrder(int itemId, String itemName,String itemType, double price,ArrayList<Flower> flowersInItem,String itemDominantColor) 
	{
		super(itemId, itemName, price);
		this.flowersInItem = flowersInItem;
		this.itemType=itemType;
		this.itemDominantColor=itemDominantColor;
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

	public String getItemDominantColor() {
		return itemDominantColor;
	}

	public void setItemDominantColor(String itemDominantColor) {
		this.itemDominantColor = itemDominantColor;
	}

 

}
