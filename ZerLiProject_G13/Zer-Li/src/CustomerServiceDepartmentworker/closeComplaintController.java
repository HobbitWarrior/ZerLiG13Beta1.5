package CustomerServiceDepartmentworker;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Users.LoginContol;
import client.ChatClient;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**closeComplaint Gui Controller class, handles all the data manipulation and display of
 * the open complaint process
 * @author Alex
 *
 */
public class closeComplaintController extends LoginContol implements Initializable {
	@FXML
	public TextField reportDetails;
	@FXML
	private Button SaveAndCLose;

	public static closingComplaintEntry cce;

	public void start(Stage primaryStage) {
		Parent root;
		try {
			root = FXMLLoader
					.load(getClass().getResource("/CustomerServiceDepartmentworker/closeComplaintWindow.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Close Complaint Window"); // name of the title of the window
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		int index = CustomerServiceDepartmentworkerMainWindow.pressedComplaintIndex;
		// instantiate a new closing complaint entry
		cce = new closingComplaintEntry(
				CustomerServiceDepartmentworkerMainWindow.activeComplaints.get(index).getComplaintID(),
				CustomerServiceDepartmentworkerMainWindow.activeComplaints.get(index).getCustomerID());
		// reset the pressedComplaintIndex
		CustomerServiceDepartmentworkerMainWindow.pressedComplaintIndex = -1;
		// bind it to the GUI
		reportDetails.textProperty().bindBidirectional(cce.getDetails());
		reportDetails.textProperty().addListener((observable, oldValue, newValue) -> {
			System.out.println("textfield changed from " + oldValue + " to " + newValue + "     values in the report:"
					+ cce.getDetails().getValue());
		});

		// call the method for a closing complaint from the server
		SaveAndCLose.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					SaveAndCloseComplaint(event);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
/**SaveAndClose button event handler
 * 
 * @param event
 * @throws IOException
 */
	public void SaveAndCloseComplaint(ActionEvent event) throws IOException {

		closingComplaint cc = new closingComplaint(cce);
		int port = LoginContol.PORT;
		String ip = LoginContol.ServerIP;
		myClient = new ChatClient(ip, port); // create new client
		myClient.sendRequestSaveAndCloseComplaint(cc);
	}

}
