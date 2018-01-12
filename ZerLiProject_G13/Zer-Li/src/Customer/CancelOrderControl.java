package Customer;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CancelOrderControl 
{
	public void start(Stage primaryStage) throws Exception 
	{		
		Parent root = FXMLLoader.load(getClass().getResource("/Customer/CancelOrderFrame.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Cancel Order request"); // name of the title of the window
		primaryStage.setScene(scene);
	  	primaryStage.show();
		//Can't close the window without logout
		primaryStage.setOnCloseRequest( event -> {event.consume();} );
	}
}
