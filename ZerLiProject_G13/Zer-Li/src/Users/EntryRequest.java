package Users;

import java.io.Serializable;

public class EntryRequest implements Serializable 
{
	private String request="";
	
	public EntryRequest(String req)
	{
		this.request=req;
	}

	public String getRequest() 
	{
		return request;
	}

	public void setRequest(String req) 
	{
		this.request = req;
	}
	
	
}
