package Customer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ServerDB.ServerGuiApp;
import Users.LoginApplication;
import Users.LoginContol;
import client.ChatClient;
import common.Branch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class CustomerMainWindow extends LoginContol implements Initializable
{
	public static ObservableList<Branch> AllBranches= FXCollections.observableArrayList();
	public static ObservableList<String> AllBranchesNames= FXCollections.observableArrayList();
    @FXML
    private Button btnCancelOrder;

    @FXML
    private Button btnCart;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnCustomise;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnCatalog;



    @FXML
    private Button PickBranchBtn;

 

    @FXML
    private Button btnAccount;

    @FXML
    private ImageView background;

    @FXML
    private ComboBox<String> comboBranch;
    
    @FXML
    void btnCartPressedEvenet(ActionEvent event)
    {
       	Stage primaryStage = new Stage();
       	OrdersControl aFrame = new OrdersControl();
  	  
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
    
    @FXML
    void logoutEvent(ActionEvent event) throws IOException
    {
    	changeEntry(UserNameToCheck);
    	
		System.out.println("return to main menu");
		((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window	
		LoginContol aFrame = new LoginContol(); // create Login Frame
		Stage arg0 = new Stage();
		aFrame.start(arg0);
		
    }
    
    @FXML
    void showCatalog(ActionEvent event) 
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
    
    @FXML
    void seeAccount(ActionEvent event) 
    {
    	btnAccount.getScene().getWindow().hide(); //hiding primary window
    	
 	   	Stage primaryStage = new Stage();
		AccountControl aFrame = new AccountControl();
			try 
			{
				aFrame.start(primaryStage);
			} 
			catch (IOException e) 
			{
				System.out.println("Cannot start Account Window");
			}
		
    }   
    
    
	public void start(Stage primaryStage) throws IOException  
	{		
	  	Pane root = FXMLLoader.load(getClass().getResource("/Customer/CustomerMainFrame.fxml"));
		Scene scene = new Scene(root);			
		primaryStage.setTitle("Customer Main Menu"); // name of the title of the window
		primaryStage.setScene(scene);		
		primaryStage.show();
		
		int port = 5555;
		String ip = "localhost";
		myClient = new ChatClient(ip, port); // create new client
		myClient.sendRequestToGetAllBranchManagers();
		AllBranches.clear();
		myClient.sendRequestToGetAllBranches();

		//Can't close the window without logout
		primaryStage.setOnCloseRequest( event -> {event.consume();} );
		
	} 

	

    @FXML
    void PickBranchBtnPressed(ActionEvent event) 
    {

    }
    
    @FXML
    void PickBranchComboPressed(ActionEvent event) 
    {
    	OrdersControl.oneBranchName.add(comboBranch.getValue());	//we transfer the branch name to the branch list of delivery, customer will be able to pick order in one single branch (if self arrival chosen)
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		comboBranch.setItems(AllBranchesNames);	
		
	}
}
