package BranchManager;

import java.io.IOException;
import java.net.URL;
import java.time.Year;
import java.util.ResourceBundle;
import java.util.Vector;

import Users.LoginContol;
import Users.User;
import Users.LoginContol;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import BranchManager.Reports;
import Customer.CatalogItemGUI;
import client.ChatClient;

public class OwnReportBrowseControl  extends LoginContol  implements Initializable
{
	 
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
    private Button btnCart;

    @FXML
    private Button BrowseBtn;

    @FXML
    private   TableView<Reports> tableV;

    @FXML
    private   TableColumn<Reports,Integer> ReportTypeCol;

    @FXML
    private   TableColumn<Reports, Year> ReportYearCol;

    @FXML
    private   TableColumn<Reports, Integer> ReportQuarterCol;

    @FXML
    private   TableColumn<Reports, Image> ImageCol;
    @FXML
     private   TableColumn<Reports, String> BranchIDCol;

	public static ObservableList<Reports> ReportList= FXCollections.observableArrayList();

	 @FXML 
    void BrowseBranchReport(ActionEvent event) {
    	
  
   	  
      
    }

    @FXML
    void CreatePaymentAccount(ActionEvent event) {

    }

    @FXML
    void DiscountingOnItem(ActionEvent event) {

    }

    @FXML
    void GetBranchReports(ActionEvent event) {

    }

    @FXML
    void goHome(ActionEvent event) {

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
	public void start(Stage primaryStage) throws  IOException 
	{		
	   	 int port=5555 ;
	 	   String ip="localhost",ThisBranchId,MSG;
	 	  ReportList.clear();
	 	   try 
	 	   {
	 		myClient = new ChatClient(ip,port);	//create new client to get all users in db (server)
	 		myClient.setLoginControl(this); 
	 	   } 
	 	   catch (IOException e) 
	 	   {
	 		   System.out.println("Cannot create client");	  
	 	   }
	 	   
	 	   
	 	    ThisBranchId=BranchManagerMainWindow.getBranchIdOfBranchManager();
	 	   System.out.println(ThisBranchId);
	 	   MSG="Give me all ReportBranch"+ThisBranchId;
	 	  System.out.println(MSG.substring(0,24));
	 	 myClient.sendRequestToGetAllReports(MSG); 

		
		Parent root = FXMLLoader.load(getClass().getResource("/BranchManager/SelfBrowseReportFrame.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Open New Payment Account To Customer"); // name of the title of the window
		primaryStage.setScene(scene);
	  	
 	   
		
		primaryStage.show();

		//Can't close the window without logout
		primaryStage.setOnCloseRequest( event -> {event.consume();} );
		 
	}

 



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		
		

		// TODO Auto-generated method stub
		 ReportTypeCol.setCellValueFactory(new PropertyValueFactory<Reports, Integer>("ReportType"));
	      ReportYearCol.setCellValueFactory(new PropertyValueFactory<Reports, Year>("ReportYear"));
	      ReportQuarterCol.setCellValueFactory(new PropertyValueFactory<Reports, Integer>("ReportQuarter"));
	    //  ImageCol.setCellValueFactory(new PropertyValueFactory<Reports, Image>("Image"));
	     BranchIDCol.setCellValueFactory(new PropertyValueFactory<Reports, String>("BranchID")); 
	     tableV.setItems(ReportList);
	}
}
