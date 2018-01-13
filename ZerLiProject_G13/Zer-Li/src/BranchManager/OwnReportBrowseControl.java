package BranchManager;

import java.io.IOException;
import java.time.Year;
import java.util.Vector;

import Users.LoginContol;
import Users.User;
import Users.LoginContol;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class OwnReportBrowseControl  extends LoginContol
{
	public static Vector<Reports> AllReports=new Vector<Reports>();
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
    private static TableView<Reports> tableV;

    @FXML
    private static TableColumn<Reports,Integer> ReportTypeCol;

    @FXML
    private static TableColumn<Reports, Year> ReportYearCol;

    @FXML
    private static TableColumn<Reports, Integer> ReportQuarterCol;

    @FXML
    private static TableColumn<Reports, Image> ImageCol;

    @FXML
    private static TableColumn<Reports, String> BranchIDCol;

	public static ObservableList<Reports> ReportList= FXCollections.observableArrayList();

	 @FXML 
    void BrowseBranchReport(ActionEvent event) {
    	 int port=5555 ;
  	   String ip="localhost";
  	   try 
  	   {
  		myClient = new ChatClient(ip,port);	//create new client to get all users in db (server)
  		myClient.setLoginControl(this);
  	   } 
  	   catch (IOException e) 
  	   {
  		   System.out.println("Cannot create client");	  
  	   }
  	    	  

  	   myClient.sendRequestToGetAllReports("Give Me All Reports"); //send request to get all users from db (server)
    	
    	
    	System.out.println("[list]");
     	
     Reports rp=new Reports();
      Reports rp1=new Reports();
      
      ReportList.add(rp);
      ReportList.add(rp1);
      
  /*    ReportTypeCol.setCellValueFactory(new PropertyValueFactory<Reports, Integer>("ReportType"));
      ReportYearCol.setCellValueFactory(new PropertyValueFactory<Reports, Year>("ReportYear"));
      ReportQuarterCol.setCellValueFactory(new PropertyValueFactory<Reports, Integer>("ReportQuarter"));
      ImageCol.setCellValueFactory(new PropertyValueFactory<Reports, Image>("Image"));
      BranchIDCol.setCellValueFactory(new PropertyValueFactory<Reports, String>("BranchID"));
   	tableV.setItems(ReportList);*/
   	  
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
		Parent root = FXMLLoader.load(getClass().getResource("/BranchManager/SelfBrowseReportFrame.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Open New Payment Account To Customer"); // name of the title of the window
		primaryStage.setScene(scene);
	  	primaryStage.show();

		//Can't close the window without logout
		primaryStage.setOnCloseRequest( event -> {event.consume();} );
		 
	}

 

	public static void SetReportsInList() {
		// TODO Auto-generated method stub
		int i;
	    for(i=0 ; i< AllReports.size() ; i++)			 
	   	   {
	    	Reports Rep =new Reports();
	    	 Rep = AllReports.get(i) ; 
	    	System.out.println(Rep);
	    	ReportList.add(Rep);
	   	   }
    	System.out.println(ReportList);
  /*    ReportTypeCol.setCellValueFactory(new PropertyValueFactory<Reports, Integer>("ReportType"));
	      ReportYearCol.setCellValueFactory(new PropertyValueFactory<Reports, Year>("ReportYear"));
	      ReportQuarterCol.setCellValueFactory(new PropertyValueFactory<Reports, Integer>("ReportQuarter"));
	      ImageCol.setCellValueFactory(new PropertyValueFactory<Reports, Image>("Image"));
	      BranchIDCol.setCellValueFactory(new PropertyValueFactory<Reports, String>("BranchID")); 
	   	tableV.setItems(ReportList); */
	    
	}
}
