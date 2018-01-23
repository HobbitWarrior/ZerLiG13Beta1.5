package BranchWorker;

import java.io.IOException;


import Users.LoginContol;
import client.ChatClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
 

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.time.Year;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.ImageIcon;

import BranchManager.BranchManagerMainWindow;
import BranchWorker.surveyResultControl;
import ChainManager.ChainManagerMainWindow;
import ChainWorker.CatalogEditControl;
import Customer.CustomerMainWindow;
import CustomerServiceDepartmentworker.CustomerServiceDepartmentworkerMainWindow;
import Expert.SurveyAnalayzingControl;
import ServerDB.EchoServer;
import ServerDB.ServerGuiApp;
import SystemManager.ManagmentControl;
import client.ChatClient;
import common.ChatIF;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ocsf.client.AbstractClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import Users.LoginContol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import BranchManager.PaymentAccount;

public class FillSurveyControl extends LoginContol implements Initializable {
	 private static final Survey NULL = null;
		public static ObservableList<Integer> ListNumbers= FXCollections.observableArrayList();

		
	 @FXML
	 private Button FillSurveyBtn;
	 

	 @FXML
	 private Button NextBtn;

	@FXML
    private Button FillSurvey;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnAccount;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnCart;

    @FXML
    private Label UserNameLabel;

    @FXML
    private Label Password;

    @FXML
    private Button ConnectBtn;

    @FXML
    private Label UserNameLabel1;

    @FXML
    private Label UserNameLabel2;

    @FXML
    private Label UserNameLabel3;

    @FXML
    private Label UserNameLabel4;

    @FXML
    private Label UserNameLabel5;

    @FXML
    private Label UserNameLabel6;

    @FXML
    private Label UserNameLabel7;

    @FXML
    private TextField txtf1;

    @FXML
    private TextField txtf2;

    @FXML
    private TextField txtf4;

    @FXML
    private TextField txtf3;

    @FXML
    private Label UserNameLabel71;

    @FXML
    private TextField txtf5;

    @FXML
    private TextField txtf6;

    @FXML
    private TextField txtf7;

    @FXML
    private TextField txtf8;

    @FXML
    private TextField txtf9;

    @FXML
    private TextField txtf10;
    
    


    @FXML
    private AnchorPane AnchorPanePickCustomer;

    @FXML
    private AnchorPane AnchorPaneFillAns;

    @FXML
    private ComboBox<Integer> Combo1;

    @FXML
    private ComboBox<Integer> Combo2;

    @FXML
    private ComboBox<Integer> Combo3;

    @FXML
    private ComboBox<Integer> Combo4;

    @FXML
    private ComboBox<Integer> Combo5;

    @FXML
    private ComboBox<Integer> Combo6;



    @FXML
    private Button PlusBtn;

    public static int i=0;
   
    ArrayList<Survey> MyFillSurveyList = new ArrayList<Survey>();
    
    //events:
    
    
    @FXML
    void goHome(ActionEvent event) 
    {

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
    
    
    
    
  

	    @FXML
	    void Q1ComboSet(ActionEvent event) {

	    }

	    @FXML
	    void Q2ComboSet(ActionEvent event) {

	    }

	    @FXML
	    void Q3ComboSet(ActionEvent event) {

	    }

	    @FXML
	    void Q4ComboSet(ActionEvent event) {

	    }

	    @FXML
	    void Q5ComboSet(ActionEvent event) {

	    }

	    @FXML
	    void Q6ComboSet(ActionEvent event) {

	    }
	    
	    
	    
	    @FXML
	    void FillSurvey(ActionEvent event) {

	    }
	    
	    
	    @FXML
	    void nextFill(ActionEvent event) {

	    }
	    
	    
	    @FXML
	    void AddNewFill(ActionEvent event) {
	          if( txtf1.getText().isEmpty() ||
             		 txtf2.getText().isEmpty()  ||
             		 txtf3.getText().isEmpty()     )
         
              {
             	 //error msg 
              }
              else
              {
            	  
       		   Survey Surveytemp = new Survey() ; 

       		Surveytemp.setQ1(Combo1.getValue());
       		Surveytemp.setQ2(Combo2.getValue());
       		Surveytemp.setQ3(Combo3.getValue());
       		Surveytemp.setQ4(Combo4.getValue());
       		Surveytemp.setQ5(Combo5.getValue());
       		Surveytemp.setQ6(Combo6.getValue());
      	 
             	 i++;
             	 txtf1.clear();
             	 txtf2.clear();
             	 txtf3.clear();
             	MyFillSurveyList.add(Surveytemp);
             	 System.out.println(MyFillSurveyList);	  
              }
	    }


	    @FXML
	    void SaveOnDB(ActionEvent event) {
	     System.out.println("aaaa");
	     
	     
	     int port=PORT;
		   String ip=ServerIP;
		   try 
		   {
			myClient = new ChatClient(ip,port);	//create new client to get all users in db (server)
			myClient.setLoginControl(this);
		   } 
		   catch (IOException e) 
		   {
			   System.out.println("Cannot create client");	  
		   }
		   int avgQ1=0,avgQ2=0,avgQ3=0,avgQ4=0,avgQ5=0,avgQ6=0;
		   for(int j=0;j<MyFillSurveyList.size();j++)
		   {
			    
			   avgQ1+=MyFillSurveyList.get(j).getQ1();
			   avgQ2+=MyFillSurveyList.get(j).getQ2();	 
		       avgQ3+=MyFillSurveyList.get(j).getQ3();
			   avgQ4+=MyFillSurveyList.get(j).getQ4();
			   avgQ5+=MyFillSurveyList.get(j).getQ5();
			   avgQ6+=MyFillSurveyList.get(j).getQ6();
		   }
		   
		   
		   Survey SurveyInfo = new Survey() ; 
		   
		//   Year y1=Year.of(Integer.parseInt(txtf3.getText()));
		    
		   
		   SurveyInfo.setCustomerID(Integer.parseInt(txtf1.getText()));
		   SurveyInfo.setSurviesQuarter(Integer.parseInt(txtf2.getText()) );
		   SurveyInfo.setSurviesYear( Integer.parseInt(txtf3.getText()));
		   SurveyInfo.setBranchWorkerID(LoginContol.userID);
		   SurveyInfo.setQ1(avgQ1/MyFillSurveyList.size());
		   SurveyInfo.setQ2(avgQ2/MyFillSurveyList.size());
		   SurveyInfo.setQ3(avgQ3/MyFillSurveyList.size());
		   SurveyInfo.setQ4(avgQ4/MyFillSurveyList.size());
		   SurveyInfo.setQ5(avgQ5/MyFillSurveyList.size());
		   SurveyInfo.setQ6(avgQ6/MyFillSurveyList.size());
		   System.out.println(avgQ1/MyFillSurveyList.size());	  

		   System.out.println(avgQ1);	 
		   System.out.println(avgQ2);	
		   System.out.println(avgQ3);	

		   System.out.println(SurveyInfo);	  

		   myClient.sendRequestToSaveObjectOnDB(SurveyInfo); //send request to get all users from db (server)
		 
		  // while( myClient.isConnected());	//wait until client (this class) get all users from the db!
		  
	    }
	    
		 

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			for(int i=1;i<11;i++)
			{
				ListNumbers.add(i);
 			}
			Combo1.setItems(ListNumbers);
			Combo2.setItems(ListNumbers);
			Combo3.setItems(ListNumbers);
			Combo4.setItems(ListNumbers);
			Combo5.setItems(ListNumbers);
			Combo6.setItems(ListNumbers);
			

		}
		
		
		public void start(Stage primaryStage) throws IOException 
		{	
			
		    
			
			Parent root = FXMLLoader.load(getClass().getResource("/BranchWorker/FillSurvey.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Branch Worker - Survey"); // name of the title of the window
			primaryStage.setScene(scene);
		  	primaryStage.show();
		   
		  	  
			//Can't close the window without logout
			primaryStage.setOnCloseRequest( event -> {event.consume();} );
			
			
		 	 
		}
		


	
}
