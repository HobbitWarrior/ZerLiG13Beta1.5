package BranchManager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import Customer.CustomerMainWindow;
import Users.LoginContol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class BranchManagerMainWindow extends LoginContol
{
/*
    @FXML
    private Button btnEditCatalog;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnDeals;

    @FXML
    private Button btnCreateAcounts;

    @FXML
    private Button btnReport;

    @FXML
    private Button btnAccount;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnBrowseBranchReport;

    @FXML
    private Button btnDiscountingOnItem;

    @FXML
    private Button btnCreatePaymentAccount;
    */

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
		primaryStage.show();
		
		//Can't close the window without logout
		primaryStage.setOnCloseRequest( event -> {event.consume();} );
	} 
}
