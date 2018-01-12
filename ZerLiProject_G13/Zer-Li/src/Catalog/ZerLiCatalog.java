package Catalog;

import java.util.ArrayList;
import java.util.Vector;

public class ZerLiCatalog 
{
	private static Vector<CatalogItem> AllCatalogItems=new Vector<CatalogItem>();
	
	
	
	public static Vector<CatalogItem> getCatalog()
	{
		return AllCatalogItems;
	}
	
	public static void setCatalog(ArrayList<CatalogItem> CatalogItemsArray)
	{
		AllCatalogItems.clear();
		for(int i=0 ; i < CatalogItemsArray.size() ; i++)
		{
			AllCatalogItems.add(CatalogItemsArray.get(i));
		}
	}

}
