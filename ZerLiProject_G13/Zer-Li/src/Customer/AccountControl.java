package Customer;


import java.io.IOException;

import Users.LoginContol;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AccountControl  extends LoginContol 
{
    @FXML
    private Button btnAccount;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnCatalog;

    @FXML
    private Button btnCancelOrder;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnCart;

    @FXML
    private Button btnCustomise;

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
    	
    	btnHome.getScene().getWindow().hide(); //hiding primary window
		
 	   	Stage primaryStage = new Stage();
 	   	CustomerMainWindow aFrame = new CustomerMainWindow();
			try {
				aFrame.start(primaryStage);
			} catch (IOException e) {
				System.out.println("Cannot start Customer main Window");
			}
    }
    
	public void start(Stage primaryStage) throws IOException  
	{		
	  	Pane root = FXMLLoader.load(getClass().getResource("/Customer/AccountFrame.fxml"));
		Scene scene = new Scene(root);			
		primaryStage.setTitle("Customer Account"); // name of the title of the window
		primaryStage.setScene(scene);		
		primaryStage.show();
		
		//Can't close the window without logout
		primaryStage.setOnCloseRequest( event -> {event.consume();} );
	} 
}
