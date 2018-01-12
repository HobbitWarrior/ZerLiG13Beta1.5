package CustomerServiceDepartmentworker;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class complaintRow {
	public Button editButton;

	private StringProperty labelText;
	private StringProperty timerText;

	public complaintRow() {
		// defualt Values
		labelText = new SimpleStringProperty("Guess what? this is a complaint");
		timerText = new SimpleStringProperty("00:20");
	}

	public complaintRow(String complaintText) {
		this();
		complaintLabelSetter(complaintText);
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

	public void timerTextSetter(String str) {
		if (!str.isEmpty()) {
			timerText.set(str);
		}
	}
	
	
	
	//event handler for the button
	public void buttonEvent()
	{
		System.out.print("\ni was just called from the complaintRow class, pretty cool huh?\n"); 
	}
}
