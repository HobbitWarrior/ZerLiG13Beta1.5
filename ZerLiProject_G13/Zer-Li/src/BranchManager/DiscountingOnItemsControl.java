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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import BranchManager.Reports;
import Customer.CatalogItemGUI;
import client.ChatClient;

public class DiscountingOnItemsControl  extends LoginContol  implements Initializable
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
    private TextField IDItemtext;

    @FXML
    private TextField percenttxt;

    @FXML
    private Button discountingBtn;
    
    @FXML
    private TableView<?> MyTableV;

    @FXML
    private TableColumn<?, ?> ItemIDCol;

    @FXML
    private TableColumn<?, ?> PriceCol;

    @FXML
    private TableColumn<?, ?> BranchIDCol;

	//public static ObservableList<catalogitems> catalogitems= FXCollections.observableArrayList();


    @FXML
    void DisCountingPercent(ActionEvent event) {
 	
 		//   PercentMSG PerMSG =new PercentMSG(IDItemtext.getText(), percenttxt.getText());
 		//   System.out.println(PerMSG);	  

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
	 	   
	 //	   myClient.sendRequestToUpdatePrice(PerMSG); //send request to get all users from db (server)

    	
    }
    
 
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
	btnCreatePaymentAccount.getScene().getWindow().hide(); //hiding primary window
		
 	   	Stage primaryStage = new Stage();
 	   DiscountingOnItemsControl aFrame = new DiscountingOnItemsControl();

				try {
					aFrame.start(primaryStage);
				} catch (Exception e) {
					System.out.println("Cannot start creat Account Window");
				}

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
	 /*  	 int port=5555 ;
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
	 	   myClient.sendRequestToGetAllCatalogItems(); //send request to get all users from db (server)
*/
		
		Parent root = FXMLLoader.load(getClass().getResource("/BranchManager/DiscountingOnItemFrame.fxml"));
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
	 /*   ItemIDCol.setCellValueFactory(new PropertyValueFactory<catalogitems, Integer>("ItemIDCol"));
	        ItemNameCol.setCellValueFactory(new PropertyValueFactory<catalogitems, String>("ItemNameCol"));
	     ItemTypeCol.setCellValueFactory(new PropertyValueFactory<catalogitems, String>("ItemTypeCol"));
	     ItemTypeCol.setCellValueFactory(new PropertyValueFactory<catalogitems, String>("DescriptionCol"));

	       PhotoCol.setCellValueFactory(new PropertyValueFactory<catalogitems, Image>("Image"));
	       PriceCol.setCellValueFactory(new PropertyValueFactory<catalogitems, Double>("PriceCol"));

	       BranchNameCol.setCellValueFactory(new PropertyValueFactory<catalogitems, String>("BranchID")); 
 	     //  tableV.setItems(catalogitems);*/
	}
}
