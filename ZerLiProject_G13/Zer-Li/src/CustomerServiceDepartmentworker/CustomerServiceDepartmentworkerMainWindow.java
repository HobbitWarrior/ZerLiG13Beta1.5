package CustomerServiceDepartmentworker;

import java.net.URL;
import java.util.ResourceBundle;
import java.lang.*;
import javafx.concurrent.Task;
import Customer.CatalogItemGUI;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.beans.binding.*;

public class CustomerServiceDepartmentworkerMainWindow implements Initializable {

	public static // a version with a complaintRow class instead of a String
	ObservableList<complaintRow> upgradedList = FXCollections.observableArrayList(new complaintRow("this is a sad"),
			new complaintRow("about a list "), new complaintRow("that its only purpose is"),
			new complaintRow("to store angry customers complaints :("), new complaintRow());

	@FXML
	public Button newComplaint;

	@FXML
	public ListView<complaintRow> complaintsList;

	@FXML
	private GridPane Griddy;

	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass()
				.getResource("/CustomerServiceDepartmentworker/CustomerServiceDepartmentworkerMainWindow.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Customer Service Department Worker Main Menu"); // name of the title of the window
		primaryStage.setScene(scene);
		primaryStage.show();

		// testing run later--for the fututre it will call the timers
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				System.out.println("just running later, Chill Bro:)");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				upgradedList.add(new complaintRow("added by run later"));
				upgradedList.get(2).timerTextSetter("23:59");
			}

		});

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
		Button button = new Button("edit>)");

		complaintRow lastItem;

		public XCell() {
			super();
			time.paddingProperty().setValue(new Insets(0, 10, 0, 0));
			hbox.getChildren().addAll(label, pane, time, button);
			HBox.setHgrow(pane, Priority.ALWAYS);
			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.out.println(lastItem + " : " + event);
				}
			});
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
						/*call the edit button click from the complaintRow instance
						 * it will open a new window or generate a new stage 
						 */
						item.buttonEvent();
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
		newComplaint.setText("Dunno");

		upgradedList.add(new complaintRow("just adding an item to a static list"));
		// point the complaintlist to the observable upgradedList
		complaintsList.setItems(upgradedList);
		// define the cell style
		complaintsList.setCellFactory(new Callback<ListView<complaintRow>, ListCell<complaintRow>>() {
			@Override
			public ListCell<complaintRow> call(ListView<complaintRow> param) {
				return new XCell();
			}
		});


		Task<Integer> task = new Task<Integer>() {
		    @Override protected Integer call() throws Exception {
		        int iterations;
		        for (iterations = 0; iterations < 1000; iterations++) {
		            if (isCancelled()) {
		                updateMessage("Cancelled");
		                break;
		            }
		            updateMessage("Iteration " + iterations);
		            updateProgress(iterations, 1000);
		 
		            //Block the thread for a short time, but be sure
		            //to check the InterruptedException for cancellation
		            try {
		                Thread.sleep(100);
		            } catch (InterruptedException interrupted) {
		                if (isCancelled()) {
		                    updateMessage("Cancelled");
		                    break;
		                }
		            }
		        }
		        return iterations;
		    }
		};
		upgradedList.get(0).timerTextSetter(task.getMessage());

	}
}