package Users;

import java.io.Serializable;

public class User implements Serializable
{
	//variables
	/**
	 * User ID
	 */
	private int UserID;
	/**
	 * UserName
	 */
	private String UserName;
	/**
	 * Password
	 */
	private String Password;
	/**
	 * Permition
	 */
	private String Permition;
	/**
	 * Status - block (0) or not block (1)
	 */
	private boolean Status;
	/**
	 * Entry - show if user entered already or not
	 */
	private int Entry;

	//Constructor
	/**
	 * this constructs a user 
	 * with specified id,UserName,password,Permition,Status,entry
	 * @param id the ID of the user
	 * @param UserName the username of the user
	 * @param password the password of the user
	 * @param Permition the pemition of the user: expert, customer, chainworker and etc.
	 * @param Status user block or not
	 * @param entry the user entered the app or not.
	 */
	public User(int id, String UserName, String password, String Permition, int Status, int entry) 
	{
		this.UserID = id;
		this.UserName = UserName;
		this.Password = password;
		this.Permition = Permition;
		if(Status==1) this.Status = true;
		else  this.Status =false;
		this.Entry= entry;
	}

	//getters and setters:
	/**
	 * 
	 * @return
	 */
	public int getId() {
		return this.UserID;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.UserID = id;
		System.out.println("ID set to "+id);
	}
	/**
	 * 
	 * @return
	 */
	public String getUserName() {
		return this.UserName;
	}
	/**
	 * 
	 * @param UserName
	 */
	public void setUserName(String UserName) {
		this.UserName = UserName;
		System.out.println("UserName set to "+UserName);
	}

	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return this.Password;
	}

	/**
	 * 
	 * @param Password
	 */
	public void setPassword(String Password) {
		this.Password = Password;
		System.out.println("Password set to "+Password);
	}
	/**
	 * 
	 * @return
	 */
	public String getPermition() {
		return this.Permition;
	}

	/**
	 * 
	 * @param Permition
	 */
	public void setPermition(String Permition) {
		this.Permition = Permition;
		System.out.println("Permition set to "+Permition);
	}
	/**
	 * 
	 * @return
	 */
	public Boolean getStatus() {
		return this.Status;
	}

	/**
	 * 
	 * @param Status
	 */
	public void setPermition(Boolean Status) {
		this.Status = Status;
		if(Status==true)
		System.out.println("Status set to not block");
		else
			System.out.println("Status set to block");
	}
	/**
	 * 
	 * @param Entry
	 */
	public void setEntry(int Entry) {
		this.Entry = Entry;
		System.out.println("Password set to "+Entry);
	}
	/**
	 * 
	 * @return
	 */
	public int getEntry() {
		return this.Entry;
	}	
	

	/**
	 * tostring method.
	 * @return
	 */
	public String toString(){
		String AllDetails= ""+UserID+ " "+UserName+ " "+ Password + " " + Permition+ " "+Status+ " " + Entry;
		return AllDetails;
	}

}
