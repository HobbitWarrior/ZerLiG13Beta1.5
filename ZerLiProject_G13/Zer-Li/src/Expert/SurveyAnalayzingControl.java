package Expert;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import Customer.OrdersControl;
import Users.LoginContol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


public class SurveyAnalayzingControl extends LoginContol

{
    @FXML
    private Button btnLogout;

    @FXML
    private Button btnAccount;

    @FXML
    private Button btnHome;
    
    

    @FXML
    void goHome(ActionEvent event) 
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
    
    
    
	
	public void start(Stage primaryStage) throws IOException
	{		
		Parent root = FXMLLoader.load(getClass().getResource("/expert/SurveyAnalayzeFrame.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("expert Main Menu"); // name of the title of the window
		primaryStage.setScene(scene);
	  	primaryStage.show();
	  	
		//Can't close the window without logout
		primaryStage.setOnCloseRequest( event -> {event.consume();} );
	}		
}
