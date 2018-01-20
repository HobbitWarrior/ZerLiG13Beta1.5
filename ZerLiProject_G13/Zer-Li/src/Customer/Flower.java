package Customer;

import java.io.Serializable;
import java.util.Comparator;

public class Flower implements Serializable,Comparable,Cloneable,Comparator
{	/**Flower class is for customizing of a new product*/
	private int flowerID;
	private String flowerColor;
	private String flowerName;
	private double flowerPrice;
	
	public Flower(int flowerID, String flowerColor, String flowerName, double flowerPrice) 
	{
		this.flowerID = flowerID;
		this.flowerColor = flowerColor;
		this.flowerName = flowerName;
		this.flowerPrice = flowerPrice;
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

	@Override
	public int compareTo(Object anotherFlower) 
	{
		if(anotherFlower instanceof Flower )
		{
			Flower secondFlower = (Flower)anotherFlower;
			if(this.flowerID == secondFlower.getFlowerID() )
			{
				return 0; //flowers are equals
			}
		}
		return -1;
	}
	
	
	@Override
	public Object clone () throws CloneNotSupportedException
	{
		return super.clone();
		
	}

	@Override
	public int compare(Object flower, Object anotherFlower) 
	{	/**compare method will be for sortinh of floers by their prices*/
		if((flower instanceof Flower) && (anotherFlower instanceof Flower))
		{
			Flower FlowerOne = (Flower) flower;
			Flower FlowerTwo = (Flower) anotherFlower;
			if(FlowerOne.getFlowerPrice() <= FlowerTwo.getFlowerPrice())
				return 1;
		}
		return -1;
	}
}
