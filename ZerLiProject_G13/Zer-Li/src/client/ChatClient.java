package client;

import ocsf.client.*;
import common.*;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.*;
import java.util.ArrayList;

import BranchManager.OwnReportBrowseControl;
import BranchManager.PaymentAccount;
import BranchManager.Reports;
import Catalog.CatalogItem;
import ChainWorker.CatalogEditControl;
import Customer.CatalogItemGUI;
import Customer.CatalogOrderControl;
import Users.LoginContol;
import Users.User;

public class ChatClient extends AbstractClient {
	// Instance variables **********************************************
	private LoginContol login;
	private CatalogOrderControl orderFromCatalog;
	private CatalogEditControl editCatalog;   // ************************************************* i added
	
	private String chooseControl; //choose between CatalogEditControl and CatalogOrderControl   // ************************************** i added
	// Constructors ****************************************************

	public ChatClient(String host, int port) throws IOException {
		super(host, port); // Call the superclass constructor
	}

	// Instance methods ************************************************

	public void setLoginControl(LoginContol login) 
	{
		this.login = login;
	}
	
	
	public void setCatalogOrderControl(CatalogOrderControl CatalogOrder) 
	{
		this.orderFromCatalog=CatalogOrder;
	}
	
	
	public void setCatalogEditControl(CatalogEditControl CatalogEdit)     // ********************* i added
	{
		this.editCatalog=CatalogEdit;
	}
	
	public void setchooseControl(String Control)   // ********************************************* i added
	{
		this.chooseControl=Control;
	}

	public void handleMessageFromServer(Object msg) 
	{

		if (msg instanceof Message) 
		{
			Message ServerMsg;
			ServerMsg = (Message) msg;
			if (ServerMsg.getMsgType().equals("User")) 
			{
				ArrayList<User> AllUsersFromServer = (ArrayList<User>) ServerMsg.getMsgObject();
				for (int i = 0; i < AllUsersFromServer.size(); i++) 
				{
					// System.out.println(""+AllUsersFromServer.get(i));
					LoginContol.AllUsers.add(AllUsersFromServer.get(i));
				}
				quit();
				Platform.runLater(new Runnable() 
				{

					@Override
					public void run() 
					{
						login.CheckUserExist();
					}

				});

				return;
			}
			
			if (ServerMsg.getMsgType().contains("Answer if Unique item ID: ")) 
			{
				Boolean ans = (Boolean)  ServerMsg.getMsgObject();
				CatalogEditControl.ansUniqueID =ans;
				
				String cutItemIDFromStringMessage=ServerMsg.getMsgType().substring(26, (ServerMsg.getMsgType().length() ) );
				int id = Integer.parseInt(cutItemIDFromStringMessage);
		//		CatalogEditControl.currentID=id;
				quit();
				
				Platform.runLater(new Runnable() 
				{

					@Override
					public void run() 
					{
						
						editCatalog.checkUniqueIDResult(id);
					}

				});

				return;
			}
			
			if(ServerMsg.getMsgType().equals("CatalogItem"))
			{
				System.out.println("ServerMsg.getMsgType().equals catalogItem");

				ArrayList<CatalogItem> AllCatalogItems = (ArrayList<CatalogItem>) ServerMsg.getMsgObject();
				for (int i = 0; i < AllCatalogItems.size(); i++) // transfer from vector to observable list because only->*
				{
					//convert from ArrayList<CatalogItem> to ObservableList<CatalogItemGUI> in order to load picture and button into the catalog table
					int itemID = AllCatalogItems.get(i).getItemID(); 
					String itemName = AllCatalogItems.get(i).getItemName(); 
					String itemType = AllCatalogItems.get(i).getItemType(); 
					String itemDescription = AllCatalogItems.get(i).getItemDescription();
					MyFile itemPhoto = AllCatalogItems.get(i).getItemPhoto(); 
					double Price = AllCatalogItems.get(i).getItemPrice();
					
					if(chooseControl.equals("CatalogOrderControl"))
					{
					
					CatalogItemGUI catalogProduct= new CatalogItemGUI(itemID , itemName , itemType , itemDescription , itemPhoto , Price, orderFromCatalog );
					CatalogOrderControl.catalogList.add(catalogProduct);					// ->* observablelist loaded into the table
					}
					
					if(chooseControl.equals("CatalogEditControl"))
					{
					
					CatalogItemGUI catalogProduct= new CatalogItemGUI(itemID , itemName , itemType , itemDescription , itemPhoto , Price, editCatalog );
					CatalogEditControl.catalogList.add(catalogProduct);					// ->* observablelist loaded into the table
					}
				}
				quit();
				
				/*
				Platform.runLater(new Runnable() 
				{

					@Override
					public void run() 
					{
						if(chooseControl.equals("CatalogOrderControl"))
							orderFromCatalog.loadAllCatalogItems(AllCatalogItems); //keep backup ArrayList into Catalog class
						if(chooseControl.equals("CatalogEditControl"))
							editCatalog.loadAllCatalogItems(AllCatalogItems); //keep backup ArrayList into Catalog class
						
					}
					

				});
				
				*/

				return;
			}
			else if (ServerMsg.getMsgType().equals("AllReports")) 
			{
				
				System.out.println("**Back");

				ArrayList<Reports> AllReportsFromServer = (ArrayList<Reports>) ServerMsg.getMsgObject();
				for (int i = 0; i < AllReportsFromServer.size(); i++) 
				{ 
			    	 OwnReportBrowseControl.AllReports.add(AllReportsFromServer.get(i));
				}
				quit();
				Platform.runLater(new Runnable() 
				{

					@Override
					public void run() 
					{
						OwnReportBrowseControl.SetReportsInList();
					}

				});

				return;
				 
			}
		}

	}

	public void sendRequestToGetAllUsers() 
	{
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			sendToServer("Give Me All Users");
		} catch (IOException e) 
		{
			System.out.println("Cannot connect to server to get all users");
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Cannot connect to server");
			alert.setHeaderText("Cannot connect to server");
			alert.setContentText("Please check with system manger if serev is open");

			alert.showAndWait();
		}

	}

	public void sendRequestToChangeEntry(String UserName) {
		try 
		{
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try 
		{
			String requestToChangeEntry="Please change Entry of user: "+UserName;
			sendToServer(requestToChangeEntry);
		} catch (IOException e) {
			System.out.println("Cannot connect to server");

		}
		quit();
	}

	
	public void sendRequestToGetAllCatalogItems() 
	{
		try 
		{
			this.openConnection();
		}

		catch (IOException e1) 
		{
			System.out.println("Cannot open connection");
		}

		try 
		{
			System.out.println("Send Message to get all catalogItems");

			sendToServer("Give Me All CatalogItems");
		} catch (IOException e) 
		{
			System.out.println("Cannot connect to server to get CatalogItems");

		}

	}
	
	public void sendRequestToDeleteItem(int itemID) 
	{
		try 
		{
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try 
		{
			String requestToDeleteItem="Please delete item with ID: "+itemID;
			sendToServer(requestToDeleteItem);
		} 
		catch (IOException e) 
		{
			System.out.println("Cannot connect to server");
		}
		quit();
	}
	
	
	public void sendRequestToCheckUniqueID(int itemID)
	{
		try 
		{
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try 
		{
			String requestToCheckUniqueID="Please Check if Unique ID:  "+itemID;
			sendToServer(requestToCheckUniqueID);
		} 
		catch (IOException e) 
		{
			System.out.println("Cannot connect to server");
		}
	}
	
	// ****************************************check!!!!!! giboi
	/*
	public void sendRequestToAddItem(CatalogItem newItem)
	{
		try 
		{
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try 
		{
			sendToServer(newItem);
		} 
		catch (IOException e) 
		{
			System.out.println("Cannot connect to server");
		}
		quit();
	}
	*/
	
	
	public void sendRequestToAddOrEditItem(CatalogItem newItem)
	{
		try 
		{
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try 
		{
			sendToServer(newItem);
		} 
		catch (IOException e) 
		{
			System.out.println("Cannot connect to server");
		}
		quit();
	}
	
	// **************************************** end check
	
	public void sendRequestToGetAllReports(String msg) 
	{
		try 
		{
			this.openConnection();
		}

		catch (IOException e1) 
		{
			System.out.println("Cannot open connection");
		}

		try 
		{
			System.out.println("Send Message to get all Reports");

			sendToServer("Give Me All Reports");
		} catch (IOException e) 
		{
			System.out.println("Cannot connect to server to get Reports");

		}

	}
	
	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
			System.out.println("Cannot close connection");
		}
	}

	public void sendRequestToSaveObjectOnDB(Object OB) {
		 
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			sendToServer(OB);
		} catch (IOException e) 
		{
			System.out.println("Cannot connect to server to set Payment Account");

		}

		
		
	}
 

}