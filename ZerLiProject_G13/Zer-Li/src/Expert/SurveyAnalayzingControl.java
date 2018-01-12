package Expert;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class SurveyAnalayzingControl
{
	
	
	public void start(Stage primaryStage) throws Exception 
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
