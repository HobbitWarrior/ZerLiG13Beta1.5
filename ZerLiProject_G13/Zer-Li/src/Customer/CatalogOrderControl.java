package Customer;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Vector;

import Catalog.CatalogItem;
import Catalog.ZerLiCatalog;
import Users.LoginContol;
import Users.User;
import client.ChatClient;
import common.Branch;
import common.MyFile;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CatalogOrderControl extends LoginContol implements Initializable
{

	private ZerLiCatalog theCatalog;

	public static ObservableList<CatalogItemGUI> catalogList= FXCollections.observableArrayList();
	

    @FXML
    private Button btnCustomise;



	@FXML
	private TableView<CatalogItemGUI> CatalogTable;


	@FXML
	private TableColumn<CatalogItemGUI, String> CatalogItemNameColumn;

    @FXML
    private TableColumn<CatalogItemGUI, String> CatalogItemTypeColumn;

	@FXML
	private TableColumn<CatalogItemGUI, String> CatalogItemDescriptionColumn;

	@FXML
	private TableColumn<CatalogItemGUI, ImageView> CatalogImageColumn;

	
	@FXML
	private TableColumn<CatalogItemGUI, Label> CatalogPriceColumn;

	@FXML
    private TableColumn<CatalogItemGUI, Button> PlusColumn;
	
	@FXML
	private TableColumn<CatalogItemGUI, Button> MinusColumn;
	
	@FXML
    private Button orderDetials;
	
	@FXML
	private Button btnLogout;


	@FXML
	private Button CustomiseBtn;

	@FXML
	private Button CancelOrderBtn;

	@FXML
	private Button btnAccount;

	@FXML
	private Button btnHome;

	@FXML
	private Button btnCart;
	

    @FXML
    private Label addToCartLabel;

    @FXML
    private ImageView imgController;
    
    
    @FXML
    void btnCustomisePressed(ActionEvent event)
    {
       	Stage primaryStage = new Stage();
       	CustomOrderControl aFrame = new CustomOrderControl();
  	  
 			
 				try 
 				{
					aFrame.start(primaryStage);
				} 
 				catch (Exception e) 
 				{
					System.out.println("Cannot open customize window");
				}
 			
 			btnCustomise.getScene().getWindow().hide(); //hiding primary window

    }
  
	@FXML
	void logoutEvent(ActionEvent event) throws IOException 
	{
		changeEntry(UserNameToCheck);
		System.out.println("return to main menu");
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding primary window
		LoginContol aFrame = new LoginContol(); // create Login Frame
		Stage arg0 = new Stage();
		OrdersControl.ItemsInOrderList.clear();
		this.catalogList.clear();
		aFrame.start(arg0);

	}

	@FXML
	void goHome(ActionEvent event) {
		btnHome.getScene().getWindow().hide(); // hiding primary window
		this.catalogList.clear();
		Stage primaryStage = new Stage();
		CustomerMainWindow aFrame = new CustomerMainWindow();
		try {
			aFrame.start(primaryStage);
		} catch (IOException e) {
			System.out.println("Cannot start Customer main Window");
		}
	}

	@FXML
	void seeAccount(ActionEvent event) {
		btnAccount.getScene().getWindow().hide(); // hiding primary window

		Stage primaryStage = new Stage();
		this.catalogList.clear();
		AccountControl aFrame = new AccountControl();
		try {
			aFrame.start(primaryStage);
		} catch (IOException e) {
			System.out.println("Cannot start Account Window");
		}

	}

	@FXML
    void btnCartPressed(ActionEvent event) 
    {
		btnCart.getScene().getWindow().hide(); // hiding primary window
		Stage primaryStage = new Stage();
		OrdersControl aFrame = new OrdersControl();
		this.catalogList.clear();
		try {
			aFrame.start(primaryStage);
		} catch (IOException e) {
			System.out.println("Cannot start Cart Window");
		}
    }
	
	@FXML
	void CustomiseBtnPressed(ActionEvent event) 
	{
	
	}

	@FXML
	void CancelOrderBtnPressed(ActionEvent event) 
	{

	}
	
	

	

	public void loadAllCatalogItems(ArrayList<CatalogItem> allCatalogProduct) // this method will add the items to the
																				// table
	{
		theCatalog.setCatalog(allCatalogProduct);

	}



	
	public Label getAddToCartLabel()
	{
		return this.addToCartLabel;
	}
	
	
	
	  @FXML
	    void orderDetailsBtnPressed(ActionEvent event) 
	  {/**this method create a status label about how many items we want to buy and the total price*/
		  OrdersControl.calculateTotalPriceAndQuantity();
		  double totalPrice = OrdersControl.getTotalPrice();
		  int totalQuantity = OrdersControl.getTotalQuantity();
		  String fixNum = "" +OrdersControl.CutDoubleNumUpToTwoDigitAfterPoint(totalPrice);  
		  fixNum=fixNum+" $";
		  addToCartLabel.setText("Number of Items: "+ totalQuantity +",  Total price: "+ fixNum+".");
		  addToCartLabel.setVisible(true);

	  }
	

	  
	  
	  
		@Override
		public void initialize(URL location, ResourceBundle resources) 	
		{	//(int itemID, String itemName,	String itemType , String itemDescription , MyFile itemPhoto ,double Price )
			
			/**this method load the table view*/

			CatalogItemNameColumn.setCellValueFactory(new PropertyValueFactory<CatalogItemGUI, String>("itemName"));
			CatalogItemDescriptionColumn.setCellValueFactory(new PropertyValueFactory<CatalogItemGUI, String>("itemDescription"));
			CatalogItemTypeColumn.setCellValueFactory(new PropertyValueFactory<CatalogItemGUI, String>("itemType"));
			 CatalogImageColumn.setCellValueFactory(new PropertyValueFactory<CatalogItemGUI,  ImageView>("img"));
			CatalogPriceColumn.setCellValueFactory(new PropertyValueFactory<CatalogItemGUI, Label>("priceItemLabel"));
			PlusColumn.setCellValueFactory(new PropertyValueFactory<CatalogItemGUI, Button>("plusBtn"));
			MinusColumn.setCellValueFactory(new PropertyValueFactory<CatalogItemGUI, Button>("minusBtn"));

			CatalogTable.setItems(catalogList);
		
		}
	 
		public void start(Stage primaryStage) throws IOException {
			Pane root = FXMLLoader.load(getClass().getResource("/Customer/CatalogOrderFrameWindow.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Catalog"); // name of the title of the window
			primaryStage.setScene(scene);
			primaryStage.show();
			int port = LoginContol.PORT;
			String ip = LoginContol.ServerIP;
			myClient = new ChatClient(ip, port); // create new client
			myClient.setCatalogOrderControl(this);
			myClient.setchooseControl("CatalogOrderControl");
			myClient.sendRequestToGetAllCatalogItemsOfBranch(CustomerMainWindow.chosenBranchID);
			// Can't close the window without logout
			primaryStage.setOnCloseRequest(event -> {
				event.consume();
			});
			
			 
			
			 
		}
	

}
