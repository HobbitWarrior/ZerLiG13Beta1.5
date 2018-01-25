package CustomerServiceDepartmentworker;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.beans.binding.*;

public class ManageComplaintController implements Initializable  {
	@FXML
	public Label topic;
	@FXML
	public Label details;
	@FXML
	public Label customerID;
	@FXML
	public TextField topicField;
	@FXML
	public TextField detailsField;
	@FXML
	public TextField customerIDField;
	@FXML
	public Button save;
	@FXML
	public Label title;
 	
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader
				.load(getClass().getResource("/CustomerServiceDepartmentworker/ManageComplaintFrame.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Manage Open Complaint"); // name of the title of the window
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(CustomerServiceDepartmentworkerMainWindow.pressedComplaintIndex!=-1)
		{
			int index=CustomerServiceDepartmentworkerMainWindow.pressedComplaintIndex;
			//reset the pressedComplaintIndex
			CustomerServiceDepartmentworkerMainWindow.pressedComplaintIndex=-1;
			//bind the GUI fields
		//	title.textProperty().bindBidirectional(CustomerServiceDepartmentworkerMainWindow.activeComplaints.get(index).ComplaintTopicGUIGetter());
		}
		
			
			

	}
}
