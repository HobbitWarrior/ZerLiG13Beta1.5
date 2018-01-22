package Customer;

import java.io.Serializable;

public class CatalogItemInOrder extends ItemInOrder implements Serializable
{
	public CatalogItemInOrder(int itemId,String itemName, double price)
	{
		super(itemId, itemName, price);
		
	}
	
	public CatalogItemInOrder(int orderid, int itemId,String itemName, double price)
	{
		super(orderid, itemId, itemName , price);

	}
}
  