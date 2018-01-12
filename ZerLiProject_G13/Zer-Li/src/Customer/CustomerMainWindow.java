package Customer;

import java.io.IOException;

import ServerDB.ServerGuiApp;
import Users.LoginApplication;
import Users.LoginContol;
import client.ChatClient;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class CustomerMainWindow extends LoginContol
{

    @FXML
    private Button btnCancelOrder;

    @FXML
    private Button btnView1;

    @FXML
    private Button btnView2;

    @FXML
    private Button btnView3;

    @FXML
    private Button btnView4;

    @FXML
    private Button btnCart;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnCustomise;

    @FXML
    private Button btnAddToCart4;

    @FXML
    private Button btnLogout;

    @FXML
    private ImageView geaturedProduct1;

    @FXML
    private Button btnDeals;


    @FXML
    private Button btnCatalog;


   

    @FXML
    private Label labelPrice1;

    @FXML
    private Label labelPrice2;

    @FXML
    private Label labelPrice3;

    @FXML
    private Label labelPrice4;

    @FXML
    private Button btnAccount;

    @FXML
    private ImageView background;

    @FXML
    private ImageView geaturedProduct2;

    @FXML
    private ImageView geaturedProduct3;

    @FXML
    private ImageView geaturedProduct4;
    
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
		
		//Can't close the window without logout
		primaryStage.setOnCloseRequest( event -> {event.consume();} );
	} 

}
