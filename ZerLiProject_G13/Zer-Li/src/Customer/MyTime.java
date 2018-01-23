package Customer;

import java.io.Serializable;

public class MyTime implements Serializable, Comparable,Cloneable
{
	private String hour;
	private String minutes;
	private String seconds;


	public MyTime(String hour, String minutes, String seconds) 
	{
		this.hour = hour;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	@Override
	public Object clone () throws CloneNotSupportedException
	{
		return super.clone();
		
	}
	
	@Override
	public int compareTo(Object anothertime) 
	{
		if(anothertime instanceof MyTime)
		{
			MyTime check = (MyTime)anothertime;
			
			if( check.getHour().equals(this.hour) && check.getMinutes().equals(this.minutes) && check.getSeconds().equals(this.seconds))
			{
				return 1;
			}
		}
		return 0;
	}

	public String getHour() 
	{
		return hour;
	}

	public void setHour(String hour) 
	{
		this.hour = hour;
	}

	public String getMinutes() 
	{
		return minutes;
	}

	public void setMinutes(String minutes) 
	{
		this.minutes = minutes;
	}
	
	public String getSeconds() 
	{
		return seconds;
	}

	public void setSeconds(String seconds) 
	{
		this.seconds = seconds;
	}

	// tostring method:
	public String toString() {
		String str = this.hour+":"+this.minutes+":"+this.seconds;
		return str;
	}


}
