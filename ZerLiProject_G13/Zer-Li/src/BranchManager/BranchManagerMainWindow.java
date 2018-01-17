package BranchManager;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Customer.CustomerMainWindow;
import Users.LoginContol;
import client.ChatClient;
import common.Branch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class BranchManagerMainWindow extends LoginContol implements Initializable
{
	public static ObservableList<Branch> allBranches= FXCollections.observableArrayList();
	public static ObservableList<BranchManager> allBrancheManagers= FXCollections.observableArrayList();


   

    @FXML
    private Button btnBrowseBranchReport;

    @FXML
    private Button btnDiscountingOnItem;

    @FXML
    private Button btnCreatePaymentAccount;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnAccount;

    @FXML
    private Button btnLogout;

    @FXML
    void BrowseBranchReport(ActionEvent event) {

    	btnBrowseBranchReport.getScene().getWindow().hide(); //hiding primary window
		
 	   	Stage primaryStage = new Stage();
 	   OwnReportBrowseControl aFrame = new OwnReportBrowseControl();

				try {
					aFrame.start(primaryStage);
				} catch (Exception e) {
					System.out.println("Cannot start creat report Window");
				}

    }

    
    @FXML
    void CreatePaymentAccount(ActionEvent event)
    {
    	btnCreatePaymentAccount.getScene().getWindow().hide(); //hiding primary window
		
 	   	Stage primaryStage = new Stage();
 	   CreatePaymentAccountController aFrame = new CreatePaymentAccountController();

				try {
					aFrame.start(primaryStage);
				} catch (Exception e) {
					System.out.println("Cannot start creat Account Window");
				}

				
    }

    @FXML
    void DiscountingOnItem(ActionEvent event) {

    }
    @FXML
    void seeAccount(ActionEvent event) 
    {

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
    void goHome(ActionEvent event) 
    {

    }
    
    
	public void start(Stage primaryStage) throws IOException  
	{		
	  	Pane root = FXMLLoader.load(getClass().getResource("/BranchManager/BranchManagerMainFrame.fxml"));
		Scene scene = new Scene(root);			
		primaryStage.setTitle("Branch Manager Main Window"); // name of the title of the window
		primaryStage.setScene(scene);	
		int port=5555;
		   String ip="localhost";
		   try 
		   {
			myClient = new ChatClient(ip,port);	//create new client to get all users in db (server)

			myClient.sendRequestToGetAllBranchManagers();

			allBranches.clear();  
		
		
		   
			myClient.sendRequestToGetAllBranches();
		   } 
		   catch (IOException e) 
		   {
			   System.out.println("Cannot create client");	  
		   }
		
		primaryStage.show();
		
		//Can't close the window without logout
		primaryStage.setOnCloseRequest( event -> {event.consume();} );
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		System.out.println(""+this.allBrancheManagers);
		System.out.println(""+this.allBranches);

		
	} 
}
