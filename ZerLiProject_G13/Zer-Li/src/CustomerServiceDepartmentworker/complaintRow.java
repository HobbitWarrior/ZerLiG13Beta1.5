package CustomerServiceDepartmentworker;

import java.util.Random;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
    
public class complaintRow {

	public Stage mainstage;
	private StringProperty labelText;
	private StringProperty timerText;

	// complaint opening time
	private int hours = 0;
	private int minutes = 0;
	private int seconds = 0;

	public complaintRow() {
		// default Values
		labelText = new SimpleStringProperty("Guess what? this is a complaint");
		timerText = new SimpleStringProperty("00:20");

		// generate random time, demi values for demo
		Random rn = new Random();
		hours = rn.nextInt(24);
		minutes = rn.nextInt(60);
		seconds = rn.nextInt(60);
	}

	public complaintRow(String complaintText, String time, Stage stg) {
		this(stg);
		complaintLabelSetter(complaintText);
		GetComplaintOpeningTime(time);
	}

	public complaintRow(Stage stg) {
		this();
		mainstage = stg;

	}

	// List row elements binding
	public StringProperty complaintLabelGetter() {
		return labelText;
	}

	public StringProperty timerTextGetter() {
		return timerText;
	}

	public void complaintLabelSetter(String str) {
		if (!str.isEmpty())
			labelText.set(str);
	}

	public void timerTextSetter(String Hours, String Minutes, String Seconds) {

		int hh = Integer.parseInt(Hours) - hours;
		int mm = Integer.parseInt(Minutes) - minutes;
		int ss = Integer.parseInt(Seconds) - seconds;
		// add leading zero's if the time digit is less than 10
		String HH = "";
		String MM = "";
		String SS = "";
		if (hh < 10)
			HH = "0";
		if (mm < 10)
			MM = "0";
		if (ss < 10)
			SS = "0";
		timerText.set(HH + hh + ":" + MM + mm + " : " + SS + ss);
	}

	//parse time to 'hours','minutes' & 'seconds' of type int
	public void GetComplaintOpeningTime(String time) {

		String[] Time=time.split(":");
		hours=Integer.parseInt(Time[0]);
		minutes=Integer.parseInt(Time[1]);
	}

	
	
	
	
	// event handler for the button
	public void buttonEventHandler() {
		// open a new edit complaint, opens the "ManageComplaintFrame"
		//demi complaint key values
		ManageComplaintController editFrame = new ManageComplaintController();
		try {
			editFrame.start(new Stage());
		} catch (Exception e) {
			System.out.print("Could not open an edit window\n");
			e.printStackTrace();
			if (mainstage != null)
				mainstage.toBack();
		}
	}

}
