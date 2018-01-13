package CustomerServiceDepartmentworker;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ManageComplaintController {
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
}
