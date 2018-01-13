package ChainWorker;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Customer.CatalogItemGUI;
import Customer.CustomerMainWindow;
import Customer.OrdersControl;
import Users.LoginContol;
import client.ChatClient;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class CatalogEditControl extends LoginContol implements Initializable
{
	
	public static ObservableList<CatalogItemGUI> catalogList= FXCollections.observableArrayList();

	private int loadPressed = 0; // Check if user pressed load already
	private int pressedBtn = 0;  // flag - check on which button we pressed recently : pressedBtn=1 add item ,  pressedBtn=2 edit item
	public static Boolean ansUniqueID=false;  //the server return the answer true to ansUniqueID if the given item id is Unique else it return false. 
	
		//on top of the screen:
    	@FXML
    	private Button btnHome;
	    @FXML
	    private Button btnAccount; 
	    @FXML
	    private Button btnLogout;
	    
	    //content
	
		@FXML
		private Label titleLabel;	
	    @FXML
	    private Button btnAddItem;
	    @FXML
	    private Button btnEditItem;
	    @FXML
	    private Button btnDeleteItem;   
	   @FXML
	    private Button btnEditCatalog;
	    @FXML
	    private TableView<CatalogItemGUI> CatalogTable;
	    @FXML
	    private TableColumn<CatalogItemGUI, String> CatalogItemDescriptionColumn;
	    @FXML
	    private TableColumn<CatalogItemGUI, String> CatalogItemTypeColumn;
	    @FXML
	    private TableColumn<CatalogItemGUI, ImageView> CatalogImageColumn;
	    @FXML
	    private TableColumn<CatalogItemGUI, String> CatalogPriceColumn;
	    @FXML
	    private TableColumn<CatalogItemGUI, String> CatalogItemNameColumn;
	    @FXML
	    private TableColumn<CatalogItemGUI, Integer> CatalogItemIDColumn;
	    
	    /*
	    @FXML
	    private TableColumn<CatalogItemGUI, Button> EditColumn;
	    @FXML
	    private TableColumn<CatalogItemGUI, Button> DeleteColumn;
	    */


	    //change contact - add new item

	    @FXML
	    private AnchorPane anchorPaneAddItem;
	    @FXML
	    private Label ItemIDeLabel;
	    @FXML
	    private Label itemNameLabel;   
	    @FXML
	    private Label descriptionLabel;    
	    @FXML
	    private Label priceLabel;
	    @FXML
	    private Label typeLabel;
	    @FXML
	    private Label pictureLabel;
	    @FXML
	    private Button saveBtn;
	    @FXML
	    private Button backBtn;
	    @FXML
	    private TextField ItemIDTextField;
	    @FXML
	    private TextField itemNameTextField;
	    @FXML
	    private TextField descriptionTextField; 
	    @FXML
	    private TextField typeTextField;
	    @FXML
	    private TextField priceTextField; 
	    @FXML
	    private TextField imageTextField; 
	    @FXML
	    private ImageView newImage;
	    @FXML
	    private Button loadBtn;

	    
	    
	    @FXML
	    void logoutEvent(ActionEvent event) throws IOException
	    {
	    	loadPressed=0;
	    	changeEntry(UserNameToCheck);
	    	
			System.out.println("return to main menu");
			((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window	
			LoginContol aFrame = new LoginContol(); // create Login Frame
			Stage arg0 = new Stage();
			OrdersControl.ItemsInOrderList.clear();
			this.catalogList.clear();
			aFrame.start(arg0);
			
	    }

		@FXML
		void goHome(ActionEvent event) 
		{

		}
		
	    @FXML
	    void AddItemEvent(ActionEvent event) 
	    {    	
	    	pressedBtn=1; //we pressed on add item
	    	loadPressed=0;
	    	CatalogTable.setVisible(false);
	    	titleLabel.setText("ADD NEW ITEM");
	    	btnAddItem.setVisible(false);
	    	btnEditItem.setVisible(false);
	    	btnDeleteItem.setVisible(false);
	    	
	    	anchorPaneAddItem.setVisible(true);
	    	
	    	
	    	
	    	/*         //    ************************************* i don't need this shit
	    	itemNameLabel.setOpacity(1);
	    	descriptionLabel.setOpacity(1);
	    	priceLabel.setOpacity(1);
	    	typeLabel.setOpacity(1);
	    	pictureLabel.setOpacity(1);
	    	saveBtn.setOpacity(1);
	    	backBtn.setOpacity(1);
	    	itemNameTextField.setOpacity(1);
	    	descriptionTextField.setOpacity(1);
	    	typeTextField.setOpacity(1);
	    	priceTextField.setOpacity(1);
	    	imageTextField.setOpacity(1);
	    	*/
	    	
	    }
	    
	    @FXML
	    void EditItemEvent(ActionEvent event) 
	    {
	    	ObservableList<CatalogItemGUI> itemsInRow = CatalogTable.getSelectionModel().getSelectedItems();
	    	if(!itemsInRow.isEmpty())
	    	{
	    		ItemIDTextField.setText(""+itemsInRow.get(0).getItemID());
	    		itemNameTextField.setText(""+itemsInRow.get(0).getItemName());
	    		descriptionTextField.setText(""+itemsInRow.get(0).getItemDescription());
	    		typeTextField.setText(""+itemsInRow.get(0).getItemType());
	    		priceTextField.setText(""+itemsInRow.get(0).getItemPrice());
	 //   		imageTextField.setText(""+itemsInRow.get(0).getImg());

	    		imageTextField.setText(""+itemsInRow.get(0).getItemPhoto().getFileName());
	    		
		    	pressedBtn=2; //we pressed on add item
		    	loadPressed=0;
		    	CatalogTable.setVisible(false);
		    	titleLabel.setText("EDIT ITEM");
		    	btnAddItem.setVisible(false);
		    	btnEditItem.setVisible(false);
		    	btnDeleteItem.setVisible(false);
		    	
		    	
		    	ItemIDTextField.setDisable(true); //can't edit ID
		    	
		    	anchorPaneAddItem.setVisible(true);
		    	
		    	
		    	
		    	showImage(event);                          //computer "press" automatic on load image. show image to costumer
	    	}
	    	else
	    	{
	    		Alert incorrectImageAlert = new Alert(AlertType.WARNING);
	    		incorrectImageAlert.setTitle("No selected Items");
	    		incorrectImageAlert.setHeaderText("You didn't select row in the table");
	    		incorrectImageAlert.setContentText("Please select row in the table");
	    		incorrectImageAlert.showAndWait();
	    	}
	    	
	    	
	    	
	    }
	    
	    
	    @FXML
	    void DeleteItemEvent(ActionEvent event) 
	    {
	    	ObservableList<CatalogItemGUI> itemsInRow = CatalogTable.getSelectionModel().getSelectedItems();
	    	int itemID;
	    	if(!itemsInRow.isEmpty())
	    	{
	    		itemID= itemsInRow.get(0).getItemID();
	    		System.out.println("we choose: "+itemID); //for me to check ******** can delete this
	    		askToDeleteItem(itemID);
	    		
	    		CatalogTable.getItems().removeAll(itemsInRow);
	    	}
	    	else
	    	{
	    		Alert incorrectImageAlert = new Alert(AlertType.WARNING);
	    		incorrectImageAlert.setTitle("No selected Items");
	    		incorrectImageAlert.setHeaderText("You didn't select row in the table");
	    		incorrectImageAlert.setContentText("Please select row in the table");
	    		incorrectImageAlert.showAndWait();
	    	}
	    }
	    
	    
	    public void askToDeleteItem(int itemID)
	    {
	 	   int port=5555;
	 	   String ip="localhost";
	 	   try 
	 	   {
	 		 myClient = new ChatClient(ip,port);	//create new client
	// 		 myClient.setLoginControl(this);
	 	   } 
	 	   catch (IOException e) 
	 	   {
	 		   System.out.println("Cannot create client");	  
	 	   }
	 	   
	 	   	myClient.sendRequestToDeleteItem(itemID); //send request to change entry in db (server)
	    }
	    
	    public void checkUniqueID(int itemID)
	    {
	 	   int port=5555;
	 	   String ip="localhost";
	 	   try 
	 	   {
	 		 myClient = new ChatClient(ip,port);	//create new client
	// 		 myClient.setLoginControl(this);
	 	   } 
	 	   catch (IOException e) 
	 	   {
	 		   System.out.println("Cannot create client");	  
	 	   }
	 	   
	 	   	myClient.sendRequestToCheckUniqueID(itemID); //send request to change entry in db (server)
	    }
/*	    
	    public void addItemInCatalog(int itemID)
	    {
	 	   int port=5555;
	 	   String ip="localhost";
	 	   try 
	 	   {
	 		 myClient = new ChatClient(ip,port);	//create new client
	// 		 myClient.setLoginControl(this);
	 	   } 
	 	   catch (IOException e) 
	 	   {
	 		   System.out.println("Cannot create client");	  
	 	   }
	 	   
	 	   	myClient.sendRequestToAddItem(itemID); //send request to change entry in db (server)
	    }
*/
	    

	    @FXML
	    void saveEvent(ActionEvent event)
	    {    		
	    	
			if(! (ItemIDTextField.getText().equals("") || itemNameTextField.getText().equals("") || descriptionTextField.getText().equals("") || typeTextField.getText().equals("") || priceTextField.getText().equals("")) )
			{
		    	if(!(imageTextField.getText().equals(null) || imageTextField.getText().equals("")) ) //if we load correct image
		    	{
		    		System.out.println("input is not empty");
		    		
		    		if(loadPressed==1)
		    		{
			    		if(newImage.getImage().errorProperty().getValue().equals(false) ) //no error
			    		{
			    			System.out.println("correct image");
			    			
			    			
			    			//******* Task to do:  check price is string (using convert string to int)
			    			
			    	    	if(pressedBtn==1) //add item
			    	    	{
			    	    		
			    	    		int id = Integer.parseInt(ItemIDTextField.getText()); //convert string to int
			    	    		checkUniqueID(id); //check if there is no id like this.
			    	    		if(ansUniqueID==true)
			    	    		{
			    	    			System.out.println("unique item ID"); //for me i can delete this
//			    	    			addItemInCatalog();
			    	    		}
			    	    		else //ID already exists 
			    	    		{
			    	    			Alert incorrectImageAlert = new Alert(AlertType.WARNING);
						    		incorrectImageAlert.setTitle("ID already exists");
						    		incorrectImageAlert.setHeaderText("You entered Item ID that already exists");
						    		incorrectImageAlert.setContentText("Please try again with different item ID!");
						    		incorrectImageAlert.showAndWait();
			    	    		}
			    	    	}
			    	    	
			    	    	if(pressedBtn==2) //edit item
			    	    	{
			    	    		
			    	    	}
			    			
			    		}
			    		else
			    		{
			    			Alert incorrectImageAlert = new Alert(AlertType.WARNING);
				    		incorrectImageAlert.setTitle("Incorrect Image Adress");
				    		incorrectImageAlert.setHeaderText("Incorrect Image Adress");
				    		incorrectImageAlert.setContentText("Please load correct image adress!");
				    		incorrectImageAlert.showAndWait();
			    		}
		    		}
		    		else
		    		{
		    			Alert incorrectImageAlert = new Alert(AlertType.WARNING);
			    		incorrectImageAlert.setTitle("Did not press the load button");
			    		incorrectImageAlert.setHeaderText("You Did not press the load button");
			    		incorrectImageAlert.setContentText("Please press on the load first");
			    		incorrectImageAlert.showAndWait();
		    		}
		    		
		    	}
		    	else
		    	{
		    		Alert incorrectImageAlert = new Alert(AlertType.WARNING);
		    		incorrectImageAlert.setTitle("Empty picture address");
		    		incorrectImageAlert.setHeaderText("Empty picture address");
		    		incorrectImageAlert.setContentText("Please enter and load image adress!");
		    		incorrectImageAlert.showAndWait();
		    	}
			}
	    	else
			{
				Alert incorrectImageAlert = new Alert(AlertType.WARNING);
	    		incorrectImageAlert.setTitle("Empty fields");
	    		incorrectImageAlert.setHeaderText("You did not fill all the fields");
	    		incorrectImageAlert.setContentText("Please fill the fields!");
	    		incorrectImageAlert.showAndWait();
			}
			
			
	    }

	    @FXML
	    void backEvent(ActionEvent event) 
	    {
	    	loadPressed=0;

	    	
	    	anchorPaneAddItem.setVisible(false);
	    	titleLabel.setText("EDIT CATALOG");
	    	CatalogTable.setVisible(true);
	    	btnAddItem.setVisible(true);
	    	btnEditItem.setVisible(true);
	    	btnDeleteItem.setVisible(true);
	    	
	    	
	    	ItemIDTextField.setDisable(false); //can edit ID              //*******************************
	    	
	    	ItemIDTextField.clear();
	    	itemNameTextField.clear();
	    	descriptionTextField.clear();
	    	typeTextField.clear();
	    	priceTextField.clear();
	    	imageTextField.clear();
	    	newImage.setImage(null);
	    }
	   
	    

	    @FXML
	    void showImage(ActionEvent event) 
	    {	
	    	loadPressed=1;
	    	String imgAdress = "file:"+imageTextField.getText();
	    	System.out.println("address: "+imgAdress); //***********************for checking
	    	Image image = new Image(imgAdress);
	    	newImage.setImage(image);
	    }

	    
	/*    
		public void edit(String itemName, String itemDescription, String itemType, double itemPrice, ImageView img) 
		{
			loadPressed=0;
	    	CatalogTable.setVisible(false);
	    	titleLabel.setText("EDIT ITEM");
	    	btnAddItem.setVisible(false);
	    	
	    	anchorPaneAddItem.setVisible(true);
			
	    //	anchorPaneAddItem.
			
			
		}
	  */  
	    
	    

		@Override
		public void initialize(URL location, ResourceBundle resources) 
		{
			CatalogItemNameColumn.setCellValueFactory(new PropertyValueFactory<CatalogItemGUI, String>("itemName"));
			CatalogItemIDColumn.setCellValueFactory(new PropertyValueFactory<CatalogItemGUI, Integer>("itemID"));
			CatalogItemDescriptionColumn.setCellValueFactory(new PropertyValueFactory<CatalogItemGUI, String>("itemDescription"));
			CatalogItemTypeColumn.setCellValueFactory(new PropertyValueFactory<CatalogItemGUI, String>("itemType"));
			CatalogImageColumn.setCellValueFactory(new PropertyValueFactory<CatalogItemGUI,  ImageView>("img"));
			CatalogPriceColumn.setCellValueFactory(new PropertyValueFactory<CatalogItemGUI, String>("ItemPriceWithCoin"));
			
			
			/*
			EditColumn.setCellValueFactory(new PropertyValueFactory<CatalogItemGUI, Button>("editBtn"));
			DeleteColumn.setCellValueFactory(new PropertyValueFactory<CatalogItemGUI, Button>("deleteBtn"));
			*/

			CatalogTable.setItems(catalogList);
			
		}

	
	
	public void start(Stage primaryStage) throws IOException 
	{		
		Parent root = FXMLLoader.load(getClass().getResource("/ChainWorker/CatalogEditFrame.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Catalog Managment"); // name of the title of the window
		primaryStage.setScene(scene);
	  	primaryStage.show();
	  	
		int port = 5555;
		String ip = "localhost";
		myClient = new ChatClient(ip, port); // create new client
		myClient.setCatalogEditControl(this);
		myClient.setchooseControl("CatalogEditControl");
		myClient.sendRequestToGetAllCatalogItems();
	  	
		//Can't close the window without logout
		primaryStage.setOnCloseRequest( event -> {event.consume();} );
	}
}
