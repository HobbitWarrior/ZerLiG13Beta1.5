package CustomerServiceDepartmentworker;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.lang.*;
import javafx.concurrent.Task;
import Customer.CatalogItemGUI;
import client.ChatClient;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import javafx.scene.image.ImageView;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.beans.binding.*;

public class CustomerServiceDepartmentworkerMainWindow implements Initializable {

	public static Stage mainStageReference;
	public static // a version with a complaintRow class instead of a String
	ObservableList<complaintRow> upgradedList = FXCollections.observableArrayList();
	public static ArrayList<complaint> activeComplaints;

	@FXML
	public Button newComplaint;

	@FXML
	public ListView<complaintRow> complaintsList;

	@FXML
	private GridPane Griddy;

	static int iterations;

	// the unique key of the complaint, sent from the caller
	public static int complaintID;
	public static int customerServiceID;

	//create a chatClient instance, for com with the server
	public ChatClient cClient;
	public void start(Stage primaryStage) throws Exception {

		//will be used to track back to the main window
		mainStageReference = primaryStage;
		
		ChatClient cClient=new ChatClient("localhost",5555);
		cClient.sendRequestForComplaintsList();

		Parent root = FXMLLoader.load(getClass()
				.getResource("/CustomerServiceDepartmentworker/CustomerServiceDepartmentworkerMainWindow.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Customer Service Department Worker Main Menu"); // name of the title of the window
		primaryStage.setScene(scene);
		primaryStage.show();

		Thread updateTimersThread = new Thread() {
			public void run() {
				for (int i = 0; i < 10000000; i++) {
					iterations = i;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Platform.runLater(new Runnable() {

						@Override
						public void run() {

							// get current time
							// seconds:
							DateTimeFormatter seconds = DateTimeFormatter.ofPattern("ss");
							LocalDateTime now = LocalDateTime.now();
							// minutes:
							DateTimeFormatter minutes = DateTimeFormatter.ofPattern("MM");
							// hours:
							DateTimeFormatter hours = DateTimeFormatter.ofPattern("HH");

							// upgradedList.get(0).timerTextSetter(hours.format(now),minutes.format(now),seconds.format(now));
							for (complaintRow row : upgradedList)
								row.timerTextSetter(hours.format(now), minutes.format(now), seconds.format(now));
						}
					});
				}
			}
		};
		updateTimersThread.start();

		// Can't close the window without logout
		// primaryStage.setOnCloseRequest( event -> {event.consume();} );
	}

	/*
	 * Stackoverflow add button to list hack
	 * https://stackoverflow.com/questions/15661500/javafx-listview-item-with-an-
	 * image-button
	 */

	// listview cell personalization
	static class XCell extends ListCell<complaintRow> {
		HBox hbox = new HBox();

		// probably all of this is redundant (AZ)
		Label label = new Label("(empty)");
		Pane pane = new Pane();

		// (AZ) adding a timer label
		Label time = new Label("00:00");
		Button button = new Button("update...>)");

		complaintRow lastItem;

		public XCell() {
			super();
			time.paddingProperty().setValue(new Insets(0, 10, 0, 0));
			hbox.getChildren().addAll(label, pane, time, button);
			HBox.setHgrow(pane, Priority.ALWAYS);
		}

		@Override
		protected void updateItem(complaintRow item, boolean empty) {
			super.updateItem(item, empty);// calls the xCell constructor, must be useful too bro
			setText(null); // No text in label of super class
			if (empty) {
				lastItem = null;
				setGraphic(null);
			} else {
				lastItem = item;
				label.textProperty().bind(item.complaintLabelGetter());
				time.textProperty().bind(item.timerTextGetter());
				button.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						System.out.println(lastItem + " : " + event);
						/*
						 * call the edit button click from the complaintRow instance it will open a new
						 * window or generate a new stage
						 */
						item.buttonEventHandler();

					}
				});
				setGraphic(hbox);
			}
		}
	}

	@FXML
	void KillMe(ActionEvent event) {
		System.out.print("Life Is shit");

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		newComplaint.setText("New Complaint...");

		upgradedList.add(new complaintRow("just adding an item to a static list","13:10", mainStageReference));

		/*
		 * new complaintRow("this is a sad"), new complaintRow("about a list "), new
		 * complaintRow("that its only purpose is"), new
		 * complaintRow("to store angry customers complaints :("), new complaintRow()
		 */
		upgradedList.add(new complaintRow("this is a sad","17:48", mainStageReference));
		upgradedList.add(new complaintRow("that its only purpose is","17:40", mainStageReference));
		upgradedList.add(new complaintRow("to store angry customers complaints :(", "15:35",mainStageReference));
		upgradedList.add(new complaintRow(mainStageReference));
		
		// point the complaintList to the observable upgradedList
		complaintsList.setItems(upgradedList);
		// define the cell style
		complaintsList.setCellFactory(new Callback<ListView<complaintRow>, ListCell<complaintRow>>() {
			@Override
			public ListCell<complaintRow> call(ListView<complaintRow> param) {
				return new XCell();
			}
		});
	}
	
	public void loadListOfComplaintsFromServer()
	{
		
	}
}