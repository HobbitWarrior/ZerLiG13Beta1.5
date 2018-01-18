package ServerDB;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Statement;

import CustomerServiceDepartmentworker.complaint;
import BranchManager.BranchManager;
import BranchManager.PaymentAccount;
import BranchManager.Reports;
import BranchManager.catalogitemsofbranch;
import BranchWorker.Survey;
import Catalog.CatalogItem;
import Customer.CustomerTransaction;
import Customer.Date;
import Customer.MessgaeCatalogProduct;
import ServerDB.Product;
import Users.LoginContol;
import Users.User;
import client.Message;
import common.Branch;
import common.MyFile;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ocsf.server.*;

public class EchoServer extends AbstractServer implements Initializable 
{
	// Class attributes *************************************************

	private String UserName;
	private String Password;
	private String DataBaseName;
	private Connection ServerDataBase;
	private boolean DB_ACCOUNT;


	// Constructors ****************************************************

	public EchoServer(int port, String UserName, String Password, String DataBaseName) {
		super(port);
		ServerDataBase = connectToDB(UserName, Password, DataBaseName);
	}

	// handle Messages From Client *****************************************************************************************************************************************************

	public void handleMessageFromClient(Object msg, ConnectionToClient client) 
	{
		
		//------------------------------------instanceof String-------------------------------------------------------
		if (msg instanceof String) 
		{ 
			
			
			String DiscoverMessage=(String) msg;
			
			if (DiscoverMessage.equals("Give Me All Branches")) //i changed condition here
			{
				System.out.println("Get all Branches  from DB");

				ArrayList<Branch> BranchesFromDB = new ArrayList<Branch>();
				try 
				{
					BranchesFromDB = PutOutAllBranches(BranchesFromDB);

					Message Msg = new Message(BranchesFromDB, "Branch");

					this.sendToAllClients(Msg);
					
				} 
				catch (SQLException e) 
				{
					System.out.println("error-can't get users data from db");
					this.sendToAllClients("GetFail");
				}
				return;
			}
			
		

		

			//-----------------------------------------------------------//
			if (DiscoverMessage.equals("Give Me All Users")) 
			{
				System.out.println("Get all Users from DB");

				ArrayList<User> UsersFromDB = new ArrayList<User>();
				try 
				{
					UsersFromDB = PutOutAllUsers(UsersFromDB);

					Message Msg = new Message(UsersFromDB, "User");
					//this.sendToAllClients(Msg);
					try {
						client.sendToClient(Msg);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} 
				catch (SQLException e) 
				{
					System.out.println("error-can't get users data from db");
					this.sendToAllClients("GetFail");
				}
				return;
			}
			
		
			
			//-----------------------------------------------------------//
			if (DiscoverMessage.equals("Give Me All CatalogItems")) 
			{
				System.out.println("Get all CatalogItems from DB");

				ArrayList<CatalogItem> CatalogItemsFromDB = new ArrayList<CatalogItem>();
				try 
				{
					CatalogItemsFromDB = PutOutAllCatalogItems(CatalogItemsFromDB);

					Message Msg = new Message(CatalogItemsFromDB, "CatalogItem");
					
					
					this.sendToAllClients(Msg);
					
				} 
				catch (SQLException e) 
				{
					System.out.println("error-can't get catalogItems data from db");
					this.sendToAllClients("GetFail");
				}
				return;
			}
			
			//-----------------------------------------------------------//
			
			
			
			if (DiscoverMessage.equals("Give Me All Reports")) 
			{
				System.out.println("Get all Reports from DB");

				ArrayList<Reports> ReportsFromDB = new ArrayList<Reports>();
				try 
				{
					ReportsFromDB = PutOutAllReports(ReportsFromDB);

					Message Msg = new Message(ReportsFromDB, "AllReports");
					
					
					this.sendToAllClients(Msg);
				} 
				catch (SQLException e) 
				{
					System.out.println("error-can't get Reports data from db");
					this.sendToAllClients("GetFail");
				}
				return;
			}
			 
            //-----------------------------------------------//
			 
			
			
			if ((DiscoverMessage.substring(0, 24)).equals("Give me all ReportBranch")) 
				{
					System.out.println("Get all Reports Branch from DB");

					ArrayList<Reports> ReportsFromDB = new ArrayList<Reports>();
					try 
					{
						System.out.println(  DiscoverMessage.substring(24,DiscoverMessage.length()));
						
						ReportsFromDB = PutOutAllBranchReports(ReportsFromDB,DiscoverMessage.substring(24,DiscoverMessage.length()));

						Message Msg = new Message(ReportsFromDB, "AllBranchReport");
						
						
						this.sendToAllClients(Msg);
					} 
					catch (SQLException e) 
					{
						System.out.println("error-can't get Reports data from db");
						this.sendToAllClients("GetFail");
					}
					return;
				}
			  
			 
			
			
		     //-----------------------------------------------//
			 if ((DiscoverMessage.substring(0, 33)).equals("Give me all catalog items of branch"))
				{
					System.out.println("Get all catalog items of branch  from DB");

					ArrayList<catalogitemsofbranch> catalogitemsofbranchFromDB = new ArrayList<catalogitemsofbranch>();
					try 
					{
						System.out.println(  DiscoverMessage.substring(33,DiscoverMessage.length()));
						
						catalogitemsofbranchFromDB = PutOutAllCatalogItemsOfBranch(catalogitemsofbranchFromDB,DiscoverMessage.substring(33,DiscoverMessage.length()));

						Message Msg = new Message(catalogitemsofbranchFromDB, "catalog items of branch");
						
						
						this.sendToAllClients(Msg);
					} 
					catch (SQLException e) 
					{
						System.out.println("error-can't get Reports data from db");
						this.sendToAllClients("GetFail");
					}
					return;
				}
			 
			// get all the complaints from the DB
			 
		
			 
				if (DiscoverMessage.equals("complaints")) 
				{
					System.out.println("Dear server will you be so kind to get all the Compliants from the DB?");
					ArrayList<complaint> Complaints = new ArrayList<complaint>();
					try {
						// Complaints = PutOutAllCatalogItems(Complaints);

						Message Msg = new Message(Complaints, "Complaints");

						this.sendToAllClients(Msg);

					} catch (Exception e) // SQLException
					{
						System.out.println("error-can't get catalogItems data from db");
						this.sendToAllClients("GetFail");
					}
				}
			//-----------------------------------------------------------//
			
				
				
			// "Please change Entry of user: "  "Please change Entry of user: "+UserName;
			if ( (DiscoverMessage.length()) >= 28 )	//from here there is a process that check if client asking to change entry status of userName 
			{

				String checkSubString = DiscoverMessage.substring(0, 28); // cut msg string to "Please change Entry of user:" in case login control sent request	
				System.out.println(checkSubString);                        // or cut msg string to ""Please delete item with ID: " in case chain worker sent request
				
				if (checkSubString.equals("Please change Entry of user:"))
				{
					String cutUserNameFromStringMessage=DiscoverMessage.substring(29, ( DiscoverMessage.length() ) );
						// need to change entry
						System.out.println("Changing the entry numbers of userName: "+cutUserNameFromStringMessage);
						changeEntryInDB(cutUserNameFromStringMessage);
						return;
				}
				
				//-----------------------------------------------------------//
				
				if (checkSubString.equals("Please delete item with ID: "))
				{
					String cutItemIDFromStringMessage=DiscoverMessage.substring(28, ( DiscoverMessage.length() ) );
						// need to change entry
						System.out.println("Delete the item with itemID: "+cutItemIDFromStringMessage);
						
						int id = Integer.parseInt(cutItemIDFromStringMessage);
						
						deleteItemInDB(id);
						return;
				}
				
				//-----------------------------------------------------------//
				
				if (checkSubString.equals("Please Check if Unique ID:  "))
				{
						String cutItemIDFromStringMessage=DiscoverMessage.substring(28, ( DiscoverMessage.length() ) );
						// need to change entry
						System.out.println("Check if Unique item ID: "+cutItemIDFromStringMessage);
						
						int id = Integer.parseInt(cutItemIDFromStringMessage);
						Boolean ans;
						
						ans=checkUniqueIDInDB(id);
						
						if(ans)
							System.out.println("true");
						else
							System.out.println("false");
						
						Message Msg = new Message(ans, "Answer if Unique item ID: "+id);
						
						this.sendToAllClients(Msg);
						
						return;
				}
				
				//System.out.println("branch2"); //haim&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

				
			}//end of if ( (DiscoverMessage.length()) >= 28 )
			
			
			
			
		

   	
			if(DiscoverMessage.equals("Give Me All Branches managers"))
			{
				System.out.println("Get all Branche managers from DB");

				ArrayList<BranchManager> BrancheManagersFromDB = new ArrayList<BranchManager>();
				try 
				{
					BrancheManagersFromDB = PutOutAllBranchManagers(BrancheManagersFromDB);

					Message Msg = new Message(BrancheManagersFromDB, "BranchManager");

					//this.sendToAllClients(Msg);
					try {
						client.sendToClient(Msg);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
				catch (SQLException e) 
				{
					System.out.println("error-can't get branchManagers data from db");
					//this.sendToAllClients("GetFail");
					
				}
				return;			}
			
		}//end of if (msg instanceof String)
		
		
		//-----------------------------------instanceof PaymentAccount-------------------------------------------------------
		if(msg instanceof PaymentAccount)
		 {
			System.out.println("100");
			System.out.println("Set Payment Account on DB");
			 
			
			try 
			{
				AddNewPaymentAccount(msg);
			} 
			catch (SQLException e) 
			{
				System.out.println("error-can't Set Payment Account on DB");
				this.sendToAllClients("GetFail");
			}
			return;	
		}
		
		//---------------------------------------instanceof Survey---------------------------------------------------------
		if(msg instanceof Survey)
		 {
			System.out.println("yes");
			System.out.println("Set Survey Info on DB");
			 
			
			try 
			{
				SaveSurveyInfo(msg);
			} 
			catch (SQLException e) 
			{
				System.out.println("error-can't Set Survey Info on DB");
				this.sendToAllClients("GetFail");
			}
			return;
		 }
		
		//---------------------------------------instance of Complaints----------------------------------------------------

		// inserts the complaints to the DB
		if (msg instanceof complaint) {
			complaint cmp = (complaint) msg;
			// make sure the data is valid
			if (cmp.getComplaintID() < 1 || cmp.getCustomerID() < 1 || cmp.getDateComplaint().isEmpty()
					|| cmp.getEmpHandling() < 1 || cmp.getStatus().isEmpty() || cmp.getTimeComplaint().isEmpty()
					|| cmp.getTopic().isEmpty() || cmp.getDetails().isEmpty()) {
				System.out.println("Illegal Complaint record entry\nCould not insert to DB");
				return;
			}

			try {
				// insert the data into the table
				Statement statementquery = (Statement) ServerDataBase.createStatement(); // query to check if table
																							// filled

				PreparedStatement ps1 = ServerDataBase
						.prepareStatement("INSERT INTO complaints VALUES (?,?,?,?,?,?,?)");

				// INSERT INTO complaints VALUES (?,?,?,?,?,?,?);
				// (`ComplaintID`, `CustomerID`, `EmpHendelingID`, `Topic`, `TimeComplaint`,
				// `DateComplaint`, `Status`) VALUES

				ps1.setString(1, Integer.toString(cmp.getComplaintID()));
				ps1.setString(2, Integer.toString(cmp.getCustomerID()));
				ps1.setString(3, Integer.toString(cmp.getEmpHandling()));
				ps1.setString(3, cmp.getTopic());
				ps1.setString(4, cmp.getTimeComplaint());
				ps1.setString(5, cmp.getDateComplaint());
				ps1.setString(6, cmp.getStatus());
				ps1.executeUpdate();
				ps1.close();

				statementquery.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		
		//---------------------------------------instanceof CatalogItem----------------------------------------------------
		if(msg instanceof CatalogItem)
		 {
			
			CatalogItem givenItem = (CatalogItem)msg;
			//first we check if we need to add new item or to edit exist item:
			int tempID = givenItem.getItemID();
			Boolean ans;
			ans=checkUniqueIDInDB(tempID);
			
			if(ans) //ans true = this is unique id , means we need to add item to catalog
			{
				System.out.println("Adding item with id: "+tempID);
				addItemInDB(givenItem);
				
				return;
			}
				
			else //ans false = this is Not unique id , means we need to edit item in catalog
			{
				System.out.println("Editing item with id: "+tempID);
				editItemInDB(givenItem);
				
				return;
			}

		 }
		
		if(msg instanceof MessgaeCatalogProduct)
		 {/***this method will give client all catalog items of a specific branch*/
			System.out.println("Get all CatalogItems of a branch from DB");
			MessgaeCatalogProduct specialMessage =(MessgaeCatalogProduct)msg;
			String branchID =specialMessage.getBranchID();
			
			ArrayList<CatalogItem> CatalogItemsFromDB = new ArrayList<CatalogItem>();
			try 
			{
				
				CatalogItemsFromDB = PutOutAllCatalogItems(CatalogItemsFromDB);	//get all catalog items 
				CatalogItemsFromDB = PutOutAllBranchCatalogItems(CatalogItemsFromDB, branchID);	//get all catalog items  new prices


				Message Msg = new Message(CatalogItemsFromDB, "CatalogItem");
				//this.sendToAllClients(Msg);
				try {
					client.sendToClient(Msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} 
			catch (SQLException e) 
			{
				System.out.println("error-can't get catalogItems data from db");
				this.sendToAllClients("GetFail");
			}
			return;
		 }
		
		if(msg instanceof CustomerTransaction)
		 {
			System.out.println("server got request to save order");
		 }
		
		if(msg instanceof CustomerTransaction)
		 {	/**this part responsible on check if payment account ok and save later the data of orders in db*/
			System.out.println("server got request to save order");
			
			CustomerTransaction myOrder= (CustomerTransaction)msg;
			boolean isApproved;
			String PA_userName = myOrder.getPaymentAccountUserName();
			String PA_Password = myOrder.getPaymentAccountPassword();
			String branchID = myOrder.getOrderbranchID();
			Date dateOfOrder= myOrder.getOrderCompletedDate();
			
			
			try 
			{
				isApproved = checkIfAccountOK(PA_userName, PA_Password, branchID, dateOfOrder);
				if(isApproved == true)
				{
					System.out.println("payment account approved");

				}
				else
				{
					System.out.println("payment account not approved");

				}
				
			} 
			catch (SQLException e) 
			{
				System.out.println("cannot connect to db to check payment account");

			}

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		 }	
		
		
	} //end of handleMessageFromClient
	
	//****************************************************************************************************************************

	private boolean checkIfAccountOK(String pA_userName, String pA_Password, String branchID, Date dateOfOrder) throws SQLException 
	{	/**this method check if payment account of order is ok*/
		System.out.println("Server enterd to the method of checking account");
		System.out.println("User name: "+ pA_userName+" Passowrd: "+pA_Password + " branchID: " +branchID );

		
		
		Statement st = (Statement) ServerDataBase.createStatement();

		ResultSet rs = st.executeQuery("select * from paymentaccounts ");

		while (rs.next()) 
		{
			String DB_PA_UserName=rs.getString(1);
			String DB_PA_Password=rs.getString(3);
			String DB_BranchID=rs.getString(11);
			java.sql.Date myDate = rs.getDate(12);
			Date DB_PA_expDate = convertSqlDateToDateOfHaim(myDate);
			System.out.println(""+DB_PA_expDate.getYear() + " "+ DB_PA_expDate.getMounth()+ " " + DB_PA_expDate.getDay());
			if(pA_userName.equals(DB_PA_UserName) && pA_Password.equals(DB_PA_Password) && branchID.equals(DB_BranchID))
			{
				System.out.println("userName and Password and branch approved");
				
				if(dateOfOrder.compareTo(DB_PA_expDate) ==0 || dateOfOrder.compareTo(DB_PA_expDate) == -1)
				{
					rs.close();
					st.close();
					return true;
				}
			}
			
	

		}
		rs.close();
		st.close();


		
		return false;
	}

	private Date convertSqlDateToDateOfHaim(java.sql.Date myDate) 
	{	/*this method responsible for convert sql date type to our project date type**/
		String expDate = ""+ myDate;
		int year = Integer.parseInt(expDate.substring(0, 4)) ;       
		int mounth = Integer.parseInt(expDate.substring(5, 7)) ;       
		int day = Integer.parseInt(expDate.substring(8, expDate.length())) ;       
		Date haimDate = new Date(year, mounth, day);
		return haimDate;
	}

	private ArrayList<CatalogItem> PutOutAllBranchCatalogItems(ArrayList<CatalogItem> catalogItemsFromDB, String branchID) 
	{	/**this method return prices for item in specific branch*/
		Statement st=null;

		try 
		{
			st = (Statement) ServerDataBase.createStatement();
			String sql = "SELECT * FROM catalogitemsofbranch WHERE BranchID = '" + branchID + "'";
			ResultSet rs=null;
			rs = st.executeQuery(sql);
			while (rs.next()) 
			{
				
				int newItemID = rs.getInt(1);
				String newBranchID= rs.getString(2);
				double newItemPrice=rs.getDouble(3);
				for(int i=0; i < catalogItemsFromDB.size() ;i++)
				{
					int oldItemID =catalogItemsFromDB.get(i).getItemID();
					if(oldItemID == newItemID) //if the item in table catalogitemsofbranch exit, take the new price
					{
						catalogItemsFromDB.get(i).setItemPrice(newItemPrice);
						break;
					}
				}
				
				

				
			}
			rs.close();
			st.close();

		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
			System.out.println("Cannot update new price of branch");
		};
		
		
		
		
		return catalogItemsFromDB;
	}

	//****************************************************************************************************************************
	
	
	
	private ArrayList<BranchManager> PutOutAllBranchManagers(ArrayList<BranchManager> branchManagersFromDB) throws SQLException 
	{
		Statement st = (Statement) ServerDataBase.createStatement();

		ResultSet rs = st.executeQuery("select * from branchmanagers ");

		while (rs.next()) 
		{
			int BranchManagerID= rs.getInt(1);
			String BranchManagerName = "" + rs.getString(2);
			String BranchManagerEmail = "" + rs.getString(3);
			String BranchID =  rs.getString(4);

			

			BranchManager BranchManagerReturnToClient = new BranchManager(BranchManagerID,BranchManagerName, BranchManagerEmail,BranchID);
			branchManagersFromDB.add(BranchManagerReturnToClient);
			System.out.println(""+BranchManagerReturnToClient);

		}
		rs.close();
		st.close();

		return branchManagersFromDB;
	}

	private ArrayList<Branch> PutOutAllBranches(ArrayList<Branch> branchesFromDB) throws SQLException 
	{
		Statement st = (Statement) ServerDataBase.createStatement();

		ResultSet rs = st.executeQuery("select * from branches ");

		while (rs.next()) {
			String BranchID=""+rs.getString(1);
			String BranchName = "" + rs.getString(2);
			String BranchAdress = "" + rs.getString(3);
			

			Branch BranchReturnToClient = new Branch(BranchID,BranchName, BranchAdress);
			branchesFromDB.add(BranchReturnToClient);
			System.out.println(""+BranchReturnToClient);

		}
		rs.close();
		st.close();

		return branchesFromDB;
	}

	// Class methods ***************************************************
	
	//***********************************************************************************************************************************************************************************

	// this method get all information from the DB and sent it to the comboBox of
	// the clientGUI
	private ArrayList<User> PutOutAllUsers(ArrayList<User> UsersFromDB) throws SQLException {

		Statement st = (Statement) ServerDataBase.createStatement();

		ResultSet rs = st.executeQuery("select * from Users ");

		while (rs.next()) {
			int ID = rs.getInt(1);
			String UserName = "" + rs.getString(2);
			String Password = "" + rs.getString(3);
			String Permition = "" + rs.getString(4);
			int Status = rs.getInt(5);
			int Entry = rs.getInt(6);

			User UsersReturnToClient = new User(ID, UserName, Password, Permition, Status, Entry);
			UsersFromDB.add(UsersReturnToClient);

		}
		rs.close();
		st.close();

		return UsersFromDB;

	}
	
	//***********************************************************************************************************************************************************************************
	private ArrayList<Reports> PutOutAllReports(ArrayList<Reports> ReportsFromDB) throws SQLException {

		Statement st = (Statement) ServerDataBase.createStatement();

		ResultSet rs = st.executeQuery("select * from reports ");

		while (rs.next()) {
			int ReportType = rs.getInt(1);
			//Year ReportYear = rs.getInt(2);
			
			int ReportQuarter =  rs.getInt(3);
			//Image Permition =  rs.getBlob(4);
			String BranchID = rs.getString(5);
			 

			Reports UsersReturnToClient = new Reports(ReportType, null, ReportQuarter, null, BranchID );
			System.out.println(UsersReturnToClient);
			ReportsFromDB.add(UsersReturnToClient);

		}
		rs.close();
		st.close();

		return ReportsFromDB;

	}
	//***********************************************************************************************************************************************************************************
		//***********************************************************************************************************************************************************************************
			private ArrayList<Reports> PutOutAllBranchReports(ArrayList<Reports> ReportsFromDB,String mybranchid) throws SQLException {

				Statement st = (Statement) ServerDataBase.createStatement();
	            
				ResultSet rs = st.executeQuery("select * from reports where BranchID="+mybranchid+"");

				while (rs.next()) {
					int ReportType = rs.getInt(1);
		  String ReportYear =  rs.getString(2);
					
					int ReportQuarter =  rs.getInt(3);
					//Image Permition =  rs.getBlob(4);
					String BranchID = rs.getString(5);
					 
	   
					Reports UsersReturnToClient = new Reports(ReportType, ReportYear, ReportQuarter, null, BranchID );
					System.out.println(UsersReturnToClient);
					ReportsFromDB.add(UsersReturnToClient);

				}
				rs.close();
				st.close();

				return ReportsFromDB;

			}
			//***********************************************************************************************************************************************************************************
			//***********************************************************************************************************************************************************************************
			private ArrayList<catalogitemsofbranch> PutOutAllCatalogItemsOfBranch(ArrayList<catalogitemsofbranch> catalogitemsofbranchFromDB,String mybranchid) throws SQLException {

				Statement st = (Statement) ServerDataBase.createStatement();
	            
				ResultSet rs = st.executeQuery("select * from reports where BranchID="+mybranchid+"");

				while (rs.next()) {
					int ItemID = rs.getInt(1);
		            String BranchID =  rs.getString(2);
					
					double PriceID =  rs.getInt(3);
				  
					catalogitemsofbranch UsersReturnToClient = new  catalogitemsofbranch(ItemID, BranchID, PriceID );
					System.out.println(UsersReturnToClient);
					catalogitemsofbranchFromDB.add(UsersReturnToClient);

				}
				rs.close();
				st.close();

				return catalogitemsofbranchFromDB;

			}
		
	//***********************************************************************************************************************************************************************************
	
	private ArrayList<CatalogItem> PutOutAllCatalogItems(ArrayList<CatalogItem> CatalogItemsFromDB) throws SQLException 
	{

		Statement st = (Statement) ServerDataBase.createStatement();

		ResultSet rs = st.executeQuery("select * from catalogitems ");

		while (rs.next()) 
		{
			//get normal values from catalogitem table
			int ItemID = rs.getInt(1);
			String ItemName = "" + rs.getString(2);
			String ItemType = "" + rs.getString(3);
			String ItemDescription = "" + rs.getString(4);
			//end to get normal values from catalogitem table

			//from now we get file from longblob column
			String userDir = System.getProperty("user.dir");
			userDir = userDir + "" + "\\ZerLiProject_G13\\Zer-Li\\src\\Catalog\\catalogItemsImages\\"+ItemID+".jpg";
		    File image = new File(userDir);
		    FileOutputStream fos = null;

			try 
			{
				fos = new FileOutputStream(image);

			} 
			catch (FileNotFoundException e) 
			{
				System.out.println("Cannot create FileOutputStream");
			}
			
			Blob getSizeFile = (Blob) rs.getBlob(5);
			byte[] buffer = getSizeFile.getBytes(1, (int) getSizeFile.length());
			
		    //byte[] buffer = new byte[102017];
		    InputStream is = rs.getBinaryStream(5);
		    try 
		    {
				while (is.read(buffer) > 0) 
				{
				    fos.write(buffer);

				}
			    fos.close();

				MyFile ItemImage = createFile(userDir);
				double price = rs.getDouble(6);
				CatalogItem SingleCatalogItem = new CatalogItem (ItemID, ItemName, ItemType, ItemDescription,  ItemImage, price);
				CatalogItemsFromDB.add(SingleCatalogItem);

			} 
		    
		    catch (IOException e) 
		    {
				System.out.println("Cannot read buffer");
			}
			

		}

		rs.close();
		st.close();
		
		return CatalogItemsFromDB;

	}
	
	
	
	
	//***********************************************************************************************************************************************************************************
	
	
	public synchronized void changeEntryInDB(String userName)  
	{	
		Statement st=null;

		try 
		{
			st = (Statement) ServerDataBase.createStatement();
			String sql = "SELECT entry FROM users WHERE UserName = '" + userName + "'";
			ResultSet rs=null;
			rs = st.executeQuery(sql);
			while (rs.next()) 
			{
				
				int UserEntry = rs.getInt(1);
				if (UserEntry == 1)// logout - change the entry from 1 to 0
				{
					String insertTableSQL1 = "UPDATE users SET Entry = " + 0 + " WHERE UserName='" + userName + "';";
					st.executeUpdate(insertTableSQL1);
					


				}
				else// login - change the entry from 0 to 1
				{
					String insertTableSQL2 = "UPDATE users SET Entry = " + 1 + " WHERE UserName='" + userName + "';";
					st.executeUpdate(insertTableSQL2);
					
				}

				rs.close();
				st.close();
				break;	//break the loop to prevent crash
			}

		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
			System.out.println("Cannot update entry");
		};
	}
	
	//***********************************************************************************************************************************************************************************
	public synchronized void deleteItemInDB(int ItemID)
	{
		Statement st=null;

		try 
		{
			st = (Statement) ServerDataBase.createStatement();
			String sqlDeleteRow = "DELETE FROM catalogitems WHERE ItemID = " + ItemID + ";";
			
			st.executeUpdate(sqlDeleteRow);
			st.close();
			
		}
		catch (SQLException e1) 
		{
			e1.printStackTrace();
			System.out.println("Cannot DELETE item");
		};
	}
	
	//***********************************************************************************************************************************************************************************
	public synchronized void addItemInDB(CatalogItem givenItem)
	{
		try {
                 // need to delete !!!!!!!*****************
			
				/*
				Statement statementquery = (Statement) ServerDataBase.createStatement(); // query to check if table filled
				ResultSet rs = statementquery.executeQuery("select * from catalogitems ");
				
				
				while (rs.next()) // here we check if the table already filled
				{
					statementquery.close();
					rs.close();
			//		return "You already inserted the items to the catalog!\n"; //// message to put in the gui
				}
				*/
	
				PreparedStatement ps1 = ServerDataBase.prepareStatement(
						"insert into catalogitems (ItemID,ItemName,ItemType,Description,Photo,Price) values (?,?,?,?,?,?)");

			
				// put new row in catalogitems table!!

				ps1.setInt(1, givenItem.getItemID());
				ps1.setString(2, givenItem.getItemName());
				ps1.setString(3, givenItem.getItemType());
				ps1.setString(4, givenItem.getItemDescription());
				InputStream inputStream = null;
				String filePath = givenItem.getItemPhoto().getFileName();
				try {
					inputStream = new FileInputStream(new File(filePath));
					ps1.setBlob(5, inputStream);
					ps1.setDouble(6, givenItem.getItemPrice());

				}
				catch (FileNotFoundException e) 
				{
					System.out.println("Can't create inputStream");
				}

				ps1.executeUpdate();
			
				
				ps1.close();
	//			statementquery.close();
	//			rs.close();
		}

		catch (SQLException e) // if the adressing to the table failed
		{
			System.out.println("fail to add item!!!");

	//		return "catalog's item insertion failed!!\n"; // message
		}

//		return "catalog's item inserted to the catalogItems table successfully!!\n"; //// message

	}
	
	//***********************************************************************************************************************************************************************************
	
	public synchronized void editItemInDB(CatalogItem givenItem)
	{
		
		deleteItemInDB(givenItem.getItemID());
		addItemInDB(givenItem);		
	}
	
	//***********************************************************************************************************************************************************************************
	
	public synchronized boolean checkUniqueIDInDB(int ItemID)
	{
		Statement st=null;

		try 
		{
			st = (Statement) ServerDataBase.createStatement();
			String sqlSelectID = "SELECT ItemID FROM catalogitems WHERE ItemID =" + ItemID + ";";
			ResultSet rs=null;
			rs = st.executeQuery(sqlSelectID);
			
			while (rs.next())  //there is the same id in DB
			{
//				int IDinDB = rs.getInt(1);                           // *******i can delete this 
//				System.out.println(""+IDinDB);                        // *******i can delete this 
				return false;
			}
			rs.close();
			st.close();
			
		}
		catch (SQLException e1) 
		{
			e1.printStackTrace();
			System.out.println("failed to find answer");
		};
		
		return true; //unique id
	}
	
	//***********************************************************************************************************************************************************************************

	  // Add New Payment Account to the data base 
	  public synchronized void AddNewPaymentAccount(Object PA1) throws SQLException
	  { 
		  try {
			  PaymentAccount PA=(PaymentAccount)PA1;

			Statement statementquery = (Statement) ServerDataBase.createStatement(); // query to check if table filled
			 
			PreparedStatement ps1 = ServerDataBase.prepareStatement(
					"INSERT INTO paymentaccounts VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			 
				ps1.setString(1,PA.getUserName());
				ps1.setInt(2,PA.getCustomerID());
				ps1.setString(3, PA.getPassword());
				ps1.setString(4, PA.getPhoneNumber());
				ps1.setString(5,PA.getPaymentType());
				ps1.setString(6, PA.getCreditCardNum());
				ps1.setString(7,PA.getCreditCardExpDate());
				ps1.setInt(8, PA.getCvvCreditCardNum());
				ps1.setString(9,PA.getCreditCardType());
				ps1.setString(10, PA.getSubscriptionType());
				ps1.setString(11, PA.getBranchID());
				ps1.setString(12, PA.getExpAccountDate());


			 
		 
				ps1.executeUpdate();
				ps1.close();
				 
				statementquery.close();
			 
 			}
		catch (SQLException e1) 
		{
			e1.printStackTrace();
			System.out.println("Cannot create st");
		};
	  }
	  
	//***********************************************************************************************************************************************************************************
	  // Add Survey Information to the data base 
	  public synchronized void SaveSurveyInfo(Object OB) throws SQLException
	  { 
		  try {
			  Survey SurveyToSave=(Survey)OB;

			Statement statementquery = (Statement) ServerDataBase.createStatement(); // query to check if table filled
			 
			PreparedStatement ps1 = ServerDataBase.prepareStatement(
					"INSERT INTO Survies VALUES(?,?,?,?,?,?,?,?,?,?)");
			 
				ps1.setInt(1,SurveyToSave.getCustomerID());
				ps1.setInt(2,SurveyToSave.getSurviesQuarter());
				ps1.setInt(3, SurveyToSave.getSurviesYear());
				ps1.setInt(4,SurveyToSave.getBranchWorkerID());
				ps1.setInt(5, SurveyToSave.getQ1());
				ps1.setInt(6,SurveyToSave.getQ2());
				ps1.setInt(7,SurveyToSave.getQ3());
				ps1.setInt(8,SurveyToSave.getQ4());
				ps1.setInt(9,SurveyToSave.getQ5());
				ps1.setInt(10, SurveyToSave.getQ6());
             
		 
				ps1.executeUpdate();
				ps1.close();
				 
				statementquery.close();
			 
 			}
		catch (SQLException e1) 
		{
			e1.printStackTrace();
			System.out.println("Cannot create st");
		};
	  }
	  
	  
	  
	  // ***************************************************
	  protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());
	  }

	  // ***************************************************
	  protected void serverStopped() {
		System.out.println("Server has stopped listening for connections.");
	  }

	//***********************************************************************************************************************************************************************************
	
	
	/*  !!!!!!!    this are methoods from the prototype         !!!!!!!!
	 
	 
	 
	public synchronized PreparedStatement parsingTheData(Connection dbh, ArrayList<String> List) 
	{
		PreparedStatement ps = null;
		try {
			ps = dbh.prepareStatement(" UPDATE Product SET ProductID=? WHERE ProductName=?;");
			ps.setString(1, List.get(1));
			ps.setString(2, List.get(0));

			ps.executeUpdate();

			ps = dbh.prepareStatement(" UPDATE Product SET ProductName=? WHERE ProductName=?;");
			ps.setString(1, List.get(2));
			ps.setString(2, List.get(0));

			ps.executeUpdate();

			ps = dbh.prepareStatement(" UPDATE Product SET ProductType=? WHERE ProductName=?;");
			ps.setString(1, List.get(3));
			ps.setString(2, List.get(0));

			ps.executeUpdate();

		}

		catch (SQLException ex) 
		{
			System.out.print("Sorry we had  problem, could not save changes to Database\n");
			this.sendToAllClients("UpdateFail");
		}
		this.sendToAllClients("UpdateSuccess");
		return ps;
	}
	
	
	
	
	protected void saveUserToDB(PreparedStatement ps) 
	{
		try {
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.print("Sorry we had a problem, Could not save in Database\n");
			this.sendToAllClients("UpdateFail");
		}
		this.sendToAllClients("UpdateSucces");
	}
	
	
	
	
	
	*/


	

	//***********************************************************************************************************************************************************************************

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public boolean getStatusDBLogin() {
		return this.DB_ACCOUNT;
	}

	
	
	
	//***********************************************************************************************************************************************************************************
	public String prepareCatlog() {
		// here we prepare to take the images from their directory, it is not important
		// where the project located, the code will find the images anyway
		String userDir = System.getProperty("user.dir");
		userDir = userDir + "" + "\\ZerLiProject_G13\\Zer-Li\\src\\client\\image";
		System.out.println("" + userDir);
		String Photo1Path = "" + userDir + "\\BridalBouquet.jpg";
		String Photo2Path = "" + userDir + "\\flowerArrangement.jpg";
		String Photo3Path = "" + userDir + "\\ClusterFlowers.jpg";
		String Photo4Path = "" + userDir + "\\FloweringPlant.jpg";
		String Photo5Path = "" + userDir + "\\BridalBouquet2.jpg";
		String Photo6Path = "" + userDir + "\\ClusterFlowers2.jpg";
		String Photo7Path = "" + userDir + "\\ClusterFlowers3.jpg";
		String Photo8Path = "" + userDir + "\\flowerArrangement2.jpg";
		String Photo9Path = "" + userDir + "\\flowerArrangement3.jpg";
		String Photo10Path = "" + userDir + "\\FloweringPlant2.png";
		
		
		
		ArrayList<CatalogItem> ListOfItemToPutInMySQL = new ArrayList<CatalogItem>();

		// here we create new catalog items, and put it into arraylist
		CatalogItem itemNo1 = new CatalogItem(11111, "BestBrideFlowers", "Bridal Bouquet" , "Bouquet for christian's weddings", createFile(Photo1Path), 39.25);
		CatalogItem itemNo2 = new CatalogItem(22222, "The best of all bouqets", "Flower Arrangement", "Bouquet for special ceremonies", createFile(Photo2Path), 78.22);
		CatalogItem itemNo3 = new CatalogItem(33333, "The bouqets of the stingy people", "Cluster Flowers",	"Bouquet for people who has not too\nmuch money", createFile(Photo3Path), 21.74);
		CatalogItem itemNo4 = new CatalogItem(44444, "Beautifull flowers in big\nplant", "Flowering Plant",	"Plants for big gardens", createFile(Photo4Path), 150);
		CatalogItem itemNo5 = new CatalogItem(55555, "The bouqets of weddings ", "Bridal Bouquet" , "Bouquet for all weddings", createFile(Photo5Path), 55.65);
		CatalogItem itemNo6 = new CatalogItem(66666, "The bouqet of all bouqets", "Cluster Flowers", "Bouquet for grand parties", createFile(Photo6Path), 43.22);
		CatalogItem itemNo7 = new CatalogItem(77777, "The bouqets of children", "Cluster Flowers",	"Bouquet for babies or little\nchildren", createFile(Photo7Path), 111.22);
		CatalogItem itemNo8 = new CatalogItem(88888, "The bouqets women", "Flower Arrangement",	"Bouqets for old women", createFile(Photo8Path), 77.2);
		CatalogItem itemNo9 = new CatalogItem(99999, "The bouqets of men", "Flower Arrangement",	"Bouquet for old men", createFile(Photo9Path), 21.74);
		CatalogItem itemNo10 = new CatalogItem(11110, "The Sad flowers", "Flowering Plant",	"Plants for funreals", createFile(Photo10Path), 150);
		ListOfItemToPutInMySQL.add(itemNo1);
		ListOfItemToPutInMySQL.add(itemNo2);
		ListOfItemToPutInMySQL.add(itemNo3);
		ListOfItemToPutInMySQL.add(itemNo4);
		ListOfItemToPutInMySQL.add(itemNo5);
		ListOfItemToPutInMySQL.add(itemNo6);
		ListOfItemToPutInMySQL.add(itemNo7);
		ListOfItemToPutInMySQL.add(itemNo8);
		ListOfItemToPutInMySQL.add(itemNo9);
		ListOfItemToPutInMySQL.add(itemNo10);
		
		try {

			Statement statementquery = (Statement) ServerDataBase.createStatement(); // query to check if table filled
			ResultSet rs = statementquery.executeQuery("select * from catalogitems ");
			while (rs.next()) // here we check if the table already filled
			{
				statementquery.close();
				rs.close();
				return "You already inserted the items to the catalog!\n"; //// message to put in the gui
			}

			PreparedStatement ps1 = ServerDataBase.prepareStatement(
					"insert into catalogitems (ItemID,ItemName,ItemType,Description,Photo,Price) values (?,?,?,?,?,?)");
			PreparedStatement ps2 = ServerDataBase.prepareStatement("insert into itemstypes (categorytype) values (?)");
			for (int row = 0; row < ListOfItemToPutInMySQL.size(); row++) 
			{
				// this loop put new rows in catalogitems table!!
				CatalogItem itemFromCatalog = ListOfItemToPutInMySQL.get(row);
				ps1.setInt(1, itemFromCatalog.getItemID());
				ps1.setString(2, itemFromCatalog.getItemName());
				ps1.setString(3, itemFromCatalog.getItemType());
				ps1.setString(4, itemFromCatalog.getItemDescription());
				InputStream inputStream = null;
				String filePath = itemFromCatalog.getItemPhoto().getFileName();
				try {
					inputStream = new FileInputStream(new File(filePath));
					ps1.setBlob(5, inputStream);
					ps1.setDouble(6, itemFromCatalog.getItemPrice());

				}

				catch (FileNotFoundException e) {
					System.out.println("Can't create inputStream");
				}
				if(row<4)
				{
					ps2.setString(1, itemFromCatalog.getItemType());
				ps2.executeUpdate(); // safe close of the statements
				}
				ps1.executeUpdate();

			}
			ps1.close();
			ps2.close();
			statementquery.close();
			rs.close();
		}

		catch (SQLException e) // if the adressing to the table failed
		{
			System.out.println(e.getMessage());

			return "Deafult catalog's item insertion failed!!\n"; // message to put in the gui
		}

		return "Deafult catalog's item inserted to the catalogItems table successfully!!\n"; //// message to put in the
																								//// gui

	}
	
	//***********************************************************************************************************************************************************************************
	
	private MyFile createFile(String path) 
	{
		MyFile fileToCreate = new MyFile(path);

		String LocalfilePath = path;

		try {

			File newFile = new File(LocalfilePath);

			byte[] mybytearray = new byte[(int) newFile.length()];
			FileInputStream fis = new FileInputStream(newFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			fileToCreate.initArray(mybytearray.length);
			fileToCreate.setSize(mybytearray.length);
			bis.read(fileToCreate.getMybytearray(), 0, mybytearray.length);
			return fileToCreate;

		} 
		catch (Exception e) 
		{
			System.out.println("Can't create file");
		}
		return null;

	}
	
	//***********************************************************************************************************************************************************************************
	protected Connection connectToDB(String UserName, String Password, String DataBaseName) {
		Connection ServerDataBase = null;
		try {
			String DataBaseAdress = "jdbc:mysql://localhost:3306/" + DataBaseName;
			ServerDataBase = DriverManager.getConnection(DataBaseAdress, UserName, Password);
			System.out.print("Server connected to Database sucessfully!\n");
			this.DB_ACCOUNT = true;

		} catch (SQLException ex) {
			System.out.print("Sorry we had a problem, could not connect to DB server\n");
			this.sendToAllClients("DBConnectFail");
			this.DB_ACCOUNT = false;
		}
		return ServerDataBase;

	}
}