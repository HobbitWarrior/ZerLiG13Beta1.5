package Catalog;

import java.io.Serializable;

import common.MyFile;

public class CatalogItem implements Serializable
{
	private int itemID;
	private String itemName;
	private String itemType;
	private String itemDescription;
	private MyFile itemPhoto;
	private double itemPrice;



	public CatalogItem(int itemID, String itemName,	String itemType , String itemDescription , MyFile itemPhoto ,double Price ) 
	{
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemType = itemType;
		this.itemDescription = itemDescription;
		this.itemPhoto = itemPhoto;	
		this.itemPrice= Price;
	}
	
	
	
	
	public int getItemID()
	{
		return this.itemID;
	}
	
	public void setItemID(int itemID)
	{
		this.itemID = itemID;

	}
	
	public String getItemName()
	{
		return this.itemName;

	}
	
	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}
	
	public String getItemType()
	{
		return this.itemType;
	}
	
	public void setItemType(String ItemType)
	{
		this.itemType=ItemType;
	}
	
	public String getItemDescription()
	{
		return this.itemDescription;

	}
	
	public void setItemDescription(String itemDescription)
	{
		this.itemDescription=itemDescription;
	}
	

	public MyFile getItemPhoto()
	{
		return this.itemPhoto;

	}
	
	public void setIitemPhoto(MyFile itemPhoto)
	{
		this.itemPhoto=itemPhoto;
	}
	
	public double getItemPrice()
	{
		return this.itemPrice;
	}
	
	public void setItemPrice(double price)
	{
		this.itemPrice = price;

	}
	

	
	public String toString()
	{
		String CatalogProduct = ""+this.itemID+" "+this.itemName+" " +this.itemType+" "+ this.itemDescription  ;
		CatalogProduct=CatalogProduct+ " "+this.itemPhoto.getFileName()+" "+this.itemPrice;
		return CatalogProduct;
	}
}