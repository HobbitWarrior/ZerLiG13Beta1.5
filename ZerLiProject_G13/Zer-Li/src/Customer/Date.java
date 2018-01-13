package Customer;

import java.io.Serializable;

public class Date implements Serializable, Comparable
{
	private int year;
	private int mounth;
	private int day;
	
	public Date(int y, int m, int d)
	{
		this.year = y;
		this.mounth = m;
		this.day = d ;
		
	}
	
	
	
	
	public int getYear() 
	{
		return year;
	}
	public void setYear(int year) 
	{
		this.year = year;
	}
	public int getMounth() 
	{
		return mounth;
	}
	public void setMounth(int mounth) 
	{
		this.mounth = mounth;
	}
	public int getDay() 
	{
		return day;
	}
	public void setDay(int day) 
	{
		this.day = day;
	}




	@Override
	public int compareTo(Object someday) 
	{
		if (someday instanceof Date)
		{
			Date anotherday = (Date)someday;
			if(this.day == anotherday.getDay() && this.mounth== anotherday.getMounth() && this.year == anotherday.getYear() )
			{
				return 1;
			}
			
	
		}
		return 0;
	}
	
	//tostring method:
		public String toString()
		{
			String str= "";
			if(this.mounth <10 && this.day<10)
			{
			 str= ""+this.year+ "-0"+this.mounth+ "-0"+ this.day; 
			}
			else if(this.mounth <10 && this.day>=10)
			{
			 str= ""+this.year+ "-0"+this.mounth+ "-"+ this.day; 
			}
			
			else if(this.mounth <10 && this.day>=10)
			{
			 str= ""+this.year+ "-0"+this.mounth+ "-0"+ this.day; 
			}
			
			else if(this.mounth >=10 && this.day<10)
			{
			 str= ""+this.year+ "-"+this.mounth+ "-0"+ this.day; 
			}
			//s
			else if(this.mounth >=10 && this.day>=10)
			{
			 str= ""+this.year+ "-"+this.mounth+ "-"+ this.day; 
			}
			return str;
		}
}
