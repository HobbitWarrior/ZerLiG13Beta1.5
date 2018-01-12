package CustomerServiceDepartmentworker;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OpenComplaintController 
{

	

    @FXML
    private Button newComplaint;


	
	
	
	
	public void start(Stage primaryStage) throws IOException 
	{		
		Parent root = FXMLLoader.load(getClass().getResource("/CustomerServiceDepartmentworker/NewComplaintsFrame.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Open Complaint Ticket"); // name of the title of the window
		primaryStage.setScene(scene);
	  	primaryStage.show();
	}
	
	
	
	
    @FXML
    void KillMe(ActionEvent event) {

    }
}

