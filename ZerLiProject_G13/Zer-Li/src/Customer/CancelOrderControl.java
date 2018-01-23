package Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Users.LoginContol;
import client.ChatClient;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class CancelOrderControl extends LoginContol implements Initializable
{
	public static ObservableList<CustomerTransaction> allCustomerOrder= FXCollections.observableArrayList();

	   @FXML
	    private Button btnLogout;

	    @FXML
	    private Button btnCatalog;

	    @FXML
	    private ImageView imgController;

	    @FXML
	    private Label basketStatusLabel;

	    @FXML
	    private Button btnAccount;

	    @FXML
	    private Label branchLabelAtCatalog;

	    @FXML
	    private Button btnHome;

	    @FXML
	    private Button btnCart;

	    @FXML
	    private Label branchLabelAtCancel;
	
	    @FXML
	    private Button customizeBtn;
	    
	    @FXML
	    private TableView<CustomerTransaction> ordersTable;
	    
	    @FXML
	    private TableColumn<CustomerTransaction, Integer> orderIDColmun;
	    
	    @FXML
	    private TableColumn<CustomerTransaction, String> branchNameColmun;

	    @FXML
	    private TableColumn<CustomerTransaction, String> supplyDateColmun;

	    @FXML
	    private TableColumn<CustomerTransaction, String> supplyHourColmun;
	     
	    @FXML
	    private TableColumn<CustomerTransaction, String> priceColmun;
	    
	    
	    @FXML
	    private Button cancelOrderBtn;
	    
	    @FXML
	    void cancelOrderBtnPressed(ActionEvent event) 
	    {

	    }
	    
	    @FXML
	    void customizeBtnPressed(ActionEvent event) 
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
	 			
	 				customizeBtn.getScene().getWindow().hide(); //hiding primary window
	    }

	    @FXML
	    void goHome(ActionEvent event) 
	    {
	    	btnHome.getScene().getWindow().hide(); // hiding primary window
			Stage primaryStage = new Stage();
			CustomerMainWindow aFrame = new CustomerMainWindow();
			try 
			{
				aFrame.start(primaryStage);
			} catch (IOException e) {
				System.out.println("Cannot start Customer main Window");
			}
	    }

	    @FXML
	    void seeAccount(ActionEvent event) 
	    {
	    	btnAccount.getScene().getWindow().hide(); // hiding primary window

			Stage primaryStage = new Stage();
			AccountControl aFrame = new AccountControl();
			try 
			{
				aFrame.start(primaryStage);
			} 
			catch (IOException e) {
				System.out.println("Cannot start Account Window");
			}
	    }

	    @FXML
	    void logoutEvent(ActionEvent event) 
	    {
	    	changeEntry(UserNameToCheck);
			CustomerMainWindow.chosenBranchID="";
			CustomerMainWindow.chosenBranchName="";
			System.out.println("return to main menu"); 
			((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window	
			LoginContol aFrame = new LoginContol(); // create Login Frame
			Stage arg0 = new Stage();
			try {
				aFrame.start(arg0);
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Cannot commit logout");
			}
	    }

	    @FXML
	    void btnCartPressed(ActionEvent event) 
	    {
	    	btnCart.getScene().getWindow().hide(); // hiding primary window
			Stage primaryStage = new Stage();
			OrdersControl aFrame = new OrdersControl();
			try 
			{
				aFrame.start(primaryStage);
			} catch (IOException e) {
				System.out.println("Cannot start Cart Window");
			}
	    }

	    @FXML
	    void btnCatalogPressed(ActionEvent event) 
	    {
	    	System.out.println("I got the event of catalog button");	  

	 	   	Stage primaryStage = new Stage();
	 	   CatalogOrderControl aFrame = new CatalogOrderControl();
	 	  
				try 
				{
					aFrame.start(primaryStage);
				} 
				catch (IOException e) 
				{
					System.out.println("Cannot start catalog Window");
				}
		    	btnCatalog.getScene().getWindow().hide(); //hiding primary window	
	    }

	

	
	public void start(Stage primaryStage)  
	{		
		Parent root;
		try 
		{
			root = FXMLLoader.load(getClass().getResource("/Customer/CancelOrderFrameWindow.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Cancel Order request"); // name of the title of the window
			primaryStage.setScene(scene);
		  	primaryStage.show();
		  	int port = LoginContol.PORT;
			String ip = LoginContol.ServerIP;
			myClient = new ChatClient(ip, port); // create new client
			//myClient.sendRequestToGetAllBranchManagers();
			this.allCustomerOrder.clear();
			myClient.sendRequestToGetAllCustomerOrder(LoginContol.userID,CustomerMainWindow.chosenBranchID);
			//Can't close the window without logout
			primaryStage.setOnCloseRequest( event -> {event.consume();} );
		} 
		catch (IOException e) 
		{
			System.out.println("Cannot open cancel window");
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		branchLabelAtCancel.setText("Your branch: "+CustomerMainWindow.chosenBranchName);
		branchLabelAtCancel.setVisible(true);
		
		orderIDColmun.setCellValueFactory(new PropertyValueFactory<CustomerTransaction, Integer>("OrderID"));
		    
		branchNameColmun.setCellValueFactory(new PropertyValueFactory<CustomerTransaction, String>("branchName"));
		    	    
		supplyDateColmun.setCellValueFactory(new PropertyValueFactory<CustomerTransaction, String>("OrdersupplyDate"));
		    
		supplyHourColmun.setCellValueFactory(new PropertyValueFactory<CustomerTransaction, String>("supplyTimeStr"));
		
		priceColmun.setCellValueFactory(new PropertyValueFactory<CustomerTransaction, String>("flowerPriceWIthCoins"));

		   
		orderIDColmun.setStyle( "-fx-alignment: CENTER;");
		branchNameColmun.setStyle( "-fx-alignment: CENTER;");
		supplyDateColmun.setStyle( "-fx-alignment: CENTER;");
		supplyHourColmun.setStyle( "-fx-alignment: CENTER;");
		priceColmun.setStyle( "-fx-alignment: CENTER;");

		
	}
}
