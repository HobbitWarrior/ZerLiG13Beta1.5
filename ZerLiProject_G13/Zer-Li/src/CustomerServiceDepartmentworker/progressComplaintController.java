package CustomerServiceDepartmentworker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Users.LoginContol;
import client.ChatClient;
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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Users.LoginContol;

public class progressComplaintController extends LoginContol implements Initializable {
	@FXML
	private Label topicTitle;
	@FXML
	private Label DetailsTitle;
	@FXML
	private TextField topic;
	@FXML
	private TextField details;
	@FXML
	private Button Save;
	@FXML
	private Button CloseComplaint;
	public static progressEntry pEntry;

	public void start(Stage primaryStage) {
		Parent root;
		try {
			root = FXMLLoader
					.load(getClass().getResource("/CustomerServiceDepartmentworker/progressComplaintWindow.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Manage Open Complaint"); // name of the title of the window
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		int index=CustomerServiceDepartmentworkerMainWindow.pressedComplaintIndex;
		pEntry=new progressEntry(CustomerServiceDepartmentworkerMainWindow.activeComplaints.get(index));
		//reset the pressedComplaintIndex
		CustomerServiceDepartmentworkerMainWindow.pressedComplaintIndex=-1;
		topic.textProperty().bindBidirectional(pEntry.getTopic());
		details.textProperty().bindBidirectional(pEntry.getDetails());
		
		
		
		//remove later just cheking binging AZ
		topic.textProperty().addListener((observable, oldValue, newValue) -> {
		    System.out.println("textfield changed from " + oldValue + " to " + newValue+"     values in the currentCompliant:"+pEntry.getTopic().getValue());
		});
		details.textProperty().addListener((observable, oldValue, newValue) -> {
		    System.out.println("textfield changed from " + oldValue + " to " + newValue+"     values in the currentCompliant:"+pEntry.getDetails().getValue());
		});
	}
	
	
	
	public void SaveButtonClickHandler(ActionEvent event) throws IOException
	{
		//save the new data to a new complaintProgress and send it to the server
		complaintProgress cp=new complaintProgress(ManageComplaintController.currentComplaint.getCompliantID().getValue(), ManageComplaintController.currentComplaint.getEmpHandlingID().getValue(), pEntry.getTopic().getValue(), pEntry.getDetails().getValue());
		//mark complaint as an edited one
	
		int port = LoginContol.PORT;
		String ip = LoginContol.ServerIP;
		myClient = new ChatClient(ip, port); // create new client
		myClient.sendRequestSaveProgress(cp);
	}
	
	

}
