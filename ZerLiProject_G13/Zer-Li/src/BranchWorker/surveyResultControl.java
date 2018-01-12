package BranchWorker;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class surveyResultControl 
{
	
	
	
	public void start(Stage primaryStage) throws IOException  
	{		
	  	Pane root = FXMLLoader.load(getClass().getResource("/BranchWorker/surveyResultFrame.fxml"));
		Scene scene = new Scene(root);			
		primaryStage.setTitle("Branch Worker Main Menu"); // name of the title of the window
		primaryStage.setScene(scene);		
		primaryStage.show();
		
		//Can't close the window without logout
		primaryStage.setOnCloseRequest( event -> {event.consume();} );
	} 

}
