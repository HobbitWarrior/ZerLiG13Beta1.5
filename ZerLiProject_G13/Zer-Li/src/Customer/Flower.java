package Customer;

import java.io.Serializable;
import java.util.Comparator;

public class Flower implements Serializable
{	/**Flower class is for customizing of a new product*/
	private int flowerID;
	private String flowerColor;
	private String flowerName;
	private double flowerPrice;
	private String flowerPriceWIthCoins;
	
	public Flower()
	{
		
	}
	
	public Flower(int flowerID, String flowerColor, String flowerName, double flowerPrice) 
	{
		this.flowerID = flowerID;
		this.flowerColor = flowerColor;
		this.flowerName = flowerName;
		this.flowerPrice = flowerPrice;
		flowerPriceWIthCoins=""+ flowerPrice+"$";
	} 

	public int getFlowerID() 
	{
		return flowerID;
	}

	public void setFlowerID(int flowerID) 
	{
		this.flowerID = flowerID;
	}

	public String getFlowerColor() 
	{
		return flowerColor;
	}

	public void setFlowerColor(String flowerColor) 
	{
		this.flowerColor = flowerColor;
	}

	public String getFlowerName() 
	{
		return flowerName;
	}

	public void setFlowerName(String flowerName) 
	{
		this.flowerName = flowerName;
	}

	public double getFlowerPrice() 
	{
		return flowerPrice;
	}

	public void setFlowerPrice(double flowerPrice) 
	{
		this.flowerPrice = flowerPrice;
	}

	@Override
	public String toString() 
	{
		return "Flower [flowerID=" + flowerID + ", flowerColor=" + flowerColor + ", flowerName=" + flowerName
				+ ", flowerPrice=" + flowerPrice + "]";
	}

	public String getFlowerPriceWIthCoins() {
		return flowerPriceWIthCoins;
	}

	public void setFlowerPriceWIthCoins(String flowerPriceWIthCoins) {
		this.flowerPriceWIthCoins = flowerPriceWIthCoins;
	}

	
	
	
}
