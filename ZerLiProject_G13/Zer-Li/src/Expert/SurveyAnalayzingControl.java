package Expert;



import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import Customer.CustomOrderControl;
import Customer.OrdersControl;
import Users.LoginContol;
import Users.User;
import client.ChatClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class SurveyAnalayzingControl extends LoginContol implements Initializable

{
	public static Vector<Float> SurveyResultList=new Vector<Float>();
	public static boolean stepAns;
	
    @FXML
    private Button btnLogout;

    @FXML
    private Button btnAccount;

    @FXML
    private Button btnHome;
    
    
    
    // questions:
    

    @FXML
    private AnchorPane AnchorPaneNoSurvey;
    
    @FXML
    private AnchorPane AnchorPaneShowResult;
    
    @FXML
    private Label q1Result;

    @FXML
    private Label q2Result;
    
    @FXML
    private Label q3Result;
    
    @FXML
    private Label q4Result;

    @FXML
    private Label q5Result;
    
    @FXML
    private Label q6Result;
    
    @FXML
    private Button seeResult;
    
    

    @FXML
    void goHome(ActionEvent event) 
    {
    		btnHome.getScene().getWindow().hide(); //hiding primary window
 	   		Stage primaryStage = new Stage();
 	   		Pane root=null;
		   SurveyAnalayzingControl aFrame = new SurveyAnalayzingControl();
		   try {
			   		aFrame.start(primaryStage);
		   } catch (Exception e1) {
			   		System.out.println("cannot start Expert Window");
		   }
    	

    }

    @FXML
    void logoutEvent(ActionEvent event) throws IOException 
    {
    	changeEntry(UserNameToCheck);
    	
		System.out.println("return to main menu");
		((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window	
		LoginContol aFrame = new LoginContol(); // create Login Frame
		Stage arg0 = new Stage();
		aFrame.start(arg0);
    }



    public void getSurveyResultList()
    {
	 	   int port=PORT;
	 	   String ip=ServerIP;
	 	   try 
	 	   {
	 		 myClient = new ChatClient(ip,port);	//create new client
	 		 myClient.setAnalayzingControl(this);
	 	   } 
	 	   catch (IOException e) 
	 	   {
	 		   System.out.println("Cannot create client");	  
	 	   }
	 	   
	 	   	myClient.sendRequestToGetSatisfactionSurveyResult(); //send request to change entry in db (server)

    }
    
    
    
    public void setSurveyResultInfields()
    {
    	
    	if(SurveyResultList.size()>0)
    	{
    		
    		float q1 = (float) (Math.round(SurveyResultList.get(0)*10.0)/10.0);
    		float q2 = (float) (Math.round(SurveyResultList.get(1)*10.0)/10.0);
    		float q3 = (float) (Math.round(SurveyResultList.get(2)*10.0)/10.0);
    		float q4 = (float) (Math.round(SurveyResultList.get(3)*10.0)/10.0);
    		float q5 = (float) (Math.round(SurveyResultList.get(4)*10.0)/10.0);
    		float q6 = (float) (Math.round(SurveyResultList.get(5)*10.0)/10.0);
    		
    		
	    	System.out.println(SurveyResultList);
	    	String q1STR = String.valueOf(q1);
	    	String q2STR = String.valueOf(q2);
	    	String q3STR = String.valueOf(q3);
	    	String q4STR = String.valueOf(q4);
	    	String q5STR = String.valueOf(q5);
	    	String q6STR = String.valueOf(q6);
	
			q1Result.setText(q1STR);
			q2Result.setText(q2STR);
			q3Result.setText(q3STR);
			q4Result.setText(q4STR);
			q5Result.setText(q5STR);
			q6Result.setText(q6STR);
    	}
    	seeResult.setVisible(false);
    	AnchorPaneShowResult.setVisible(true);
    	
    }
    
    
    
    
    
    @FXML
    void askForResult(ActionEvent event) 
    {
    	
    	if (stepAns) //if stepAns is true (branch worker filled all surveys) we can see survey result
    	{
    		getSurveyResultList();
    	}
    	else //stepAns is false (branch worker didn't fill all surveys) we can't see survey result
    	{
    		seeResult.setVisible(false);
    		AnchorPaneNoSurvey.setVisible(true);
    	}
    	
    }
    
    public void checkIfStep1() //check if branch worker finish to fill surveys (step = 1 in DB table of satisfactionsurvies)
    {
	 	   int port=PORT;
	 	   String ip=ServerIP;
	 	   try 
	 	   {
	 		 myClient = new ChatClient(ip,port);	//create new client
	 		 myClient.setAnalayzingControl(this);
	 	   } 
	 	   catch (IOException e) 
	 	   {
	 		   System.out.println("Cannot create client");	  
	 	   }
	 	   
	 	   	myClient.sendRequestToCheckStep1(); //send request to change entry in db (server)
    }
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
//		checkIfStep1(); //check if branch worker finish to fill surveys (step = 1 in DB table of satisfactionsurvies)            //********* can delete this
		seeResult.setVisible(true);
		AnchorPaneNoSurvey.setVisible(false);
		AnchorPaneShowResult.setVisible(false);
	}
	
    
	
	public void start(Stage primaryStage) throws IOException
	{		
		Parent root = FXMLLoader.load(getClass().getResource("/expert/SurveyAnalayzeFrame.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("expert Main Menu"); // name of the title of the window
		primaryStage.setScene(scene);
	  	primaryStage.show();

	  	
	  	checkIfStep1(); //check if branch worker finish to fill surveys (step = 1 in DB table of satisfactionsurvies)
	  	
		//Can't close the window without logout
		primaryStage.setOnCloseRequest( event -> {event.consume();} );
	}		
}
