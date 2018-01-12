package Customer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ThreadLabelTxtArea extends Thread
{
    @FXML
    private TextArea txtGreeting;
    @FXML
    private Label messageAfterGreeting;

    
    public ThreadLabelTxtArea(TextArea txtGreeting, Label messageAfterGreeting)
    {
    	this.txtGreeting=txtGreeting;
    	this.messageAfterGreeting = messageAfterGreeting;
    	
    }

    public void run()
    {
    	while(txtGreeting.getText().equals(""));
		messageAfterGreeting.setVisible(true);
    }
}
