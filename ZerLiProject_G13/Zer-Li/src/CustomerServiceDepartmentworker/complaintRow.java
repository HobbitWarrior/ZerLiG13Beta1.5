package CustomerServiceDepartmentworker;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
<<<<<<< HEAD
=======
import javafx.stage.Stage;
>>>>>>> parent of 2bccff0... just trying to commit my changes :P

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
<<<<<<< HEAD
 
	// event handler for the button
	public void buttonEventHandler() {
		// open a new edit complaint, opens the "ManageComplaintFrame"
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
<<<<<<< HEAD
=======
	
	
	
	//event handler for the button
	public void buttonEvent()
	{
		System.out.print("\ni was just called from the complaintRow class, pretty cool huh?\n"); 
	}
}
>>>>>>> parent of 89bba59... Customer service menu updates so far
=======
>>>>>>> parent of 2bccff0... just trying to commit my changes :P
