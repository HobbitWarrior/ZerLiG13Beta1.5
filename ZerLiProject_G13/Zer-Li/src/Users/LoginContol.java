package Users;

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
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.ImageIcon;

import BranchManager.BranchManagerMainWindow;
import BranchWorker.FillSurveyControl;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ocsf.client.AbstractClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class LoginContol  
{
	
	public static Vector<User> AllUsers=new Vector<User>();
	
    protected static String UserNameToCheck;

	protected ChatClient myClient;
	
	@FXML
    private Label TitleLabel;

    @FXML
    private Button LoginBtn;

    @FXML
    private Label UserNameLabel;

    @FXML
    private ImageView ImageZerli;

    @FXML
    private Label Password;
    
    @FXML
    private TextField txtUserName;
    
    @FXML
    private PasswordField txtPassword;
    
    @FXML
    private Button btnExit;

    
  
    @FXML
    void Exit(ActionEvent event) 
    {
		System.out.println("exit Zer-li Application");
		System.exit(0);	
    }
    
    
    
    
    
   @FXML
    void ConnectToSystemEvent(ActionEvent event) 
    {
	   int port=5555;
	   String ip="localhost";
	   try 
	   {
		myClient = new ChatClient(ip,port);	//create new client to get all users in db (server)
		myClient.setLoginControl(this);
	   } 
	   catch (IOException e) 
	   {
		   System.out.println("Cannot create client");	  
	   }
	   
	   myClient. sendRequestToGetAllUsers()   ;
	 
	  // while( myClient.isConnected());	//wait until client (this class) get all users from the db!
	 
	   
	}
   
    
   public void CheckUserExist()
   {
	   String userPermition="";
//	   String UserNameToCheck = txtUserName.getText();		//get username from textfield********************************************* need to delete
	   
//	   System.out.println("UserNameToCheck: "+UserNameToCheck); //********************************************* need to delete
	   UserNameToCheck = txtUserName.getText();		//get username from textfield
//	   System.out.println("UserNameToCheck: "+UserNameToCheck); //********************************************* need to delete
	   
	   String PasswordToCheck = txtPassword.getText();		//get password from passwordfield (kind of textfield)
	   int userEntry=1;
	   int i=0;
	   
	   
	   for(i=0 ; i< AllUsers.size() ; i++)				//scan all user to check the details we just got from human
	   {
		   User person= AllUsers.get(i);
		   if(person.getUserName().equals(UserNameToCheck))		//if you found the userName in the list (vector) of users
		   {
			   

				   if(person.getPassword().equals(PasswordToCheck)) //then check if his password correct
				   {
					   //password here is correct
					   if(person.getStatus()==false)	//check if the system manager blocked this account
					   {
						   //error message on borbidden account
						   Alert BorbbidenAccountAlert = new Alert(AlertType.WARNING);
						   BorbbidenAccountAlert.setTitle("Account forbidden");
						   BorbbidenAccountAlert.setHeaderText("Your account has been blocked");
						   BorbbidenAccountAlert.setContentText("Please contact the system manager!");
						   BorbbidenAccountAlert.showAndWait();
					   }
					   else	
					   {
						   userPermition = person.getPermition(); 	//all details approved
						   
						   if(person.getEntry()==1)	//check if the account already in use
						   {
							   //error message on borbidden account
							   Alert BorbbidenAccountAlert = new Alert(AlertType.WARNING);
							   BorbbidenAccountAlert.setTitle("Account already in use");
							   BorbbidenAccountAlert.setHeaderText("Your account already in use");
							   BorbbidenAccountAlert.setContentText("Please logout! in any problame, contact the system manager.");
							   BorbbidenAccountAlert.showAndWait();
						   }
						   else	
						   {
							   userEntry = person.getEntry(); 	//all details approved  
							  
						   }	
						  
					   }
					  				   			   
					   
					   break;
				   }
			   
				   else
				   {
					   //password here is incorrect
					   Alert WrongPassword = new Alert(AlertType.ERROR);
					   WrongPassword.setTitle("Wrong password");
					   WrongPassword.setHeaderText("You inserted a wrong password!");
					   WrongPassword.setContentText("Please, try again.");
					   WrongPassword.showAndWait();
					   break;

				   }
				  
			 }
	   }
	   
	   if( i== AllUsers.size())
	   {
		   //userName here is incorrect
		   Alert WrongPassword = new Alert(AlertType.ERROR);
		   WrongPassword.setTitle("Wrong UserName");
		   WrongPassword.setHeaderText("You inserted a invalid username!");
		   WrongPassword.setContentText("Please, try again.");
		   WrongPassword.showAndWait();
	   }
	   
	   
	   myClient=null;		//safe step
	   AllUsers.clear(); 		//delete all users that we got in order to get updated list of users in the next pressing on the button
	   txtUserName.clear();
	   txtPassword.clear();
	   
	   //from here we will open new window according to the permition
	   //only 1 user with same username and password can enter
	   
	   
//**********************************************************************************************	   
	   //for me to check
//	   System.out.println("user untry: "+userEntry);
//	   System.out.println("userPermition: "+userEntry);
//	   System.out.println("UserNameToCheck: "+UserNameToCheck);
//**********************************************************************************************

	   if( (! userPermition.equals("") )&& userEntry==0 )
	   {
		   LoginBtn.getScene().getWindow().hide(); //hiding primary window
//	   }
	   Stage primaryStage = new Stage();
		Pane root=null;
	   
	   if(userPermition.equals("expert"))
	   {
		   changeEntry(UserNameToCheck); //user loged in - change the entry in DB to 1

		   SurveyAnalayzingControl aFrame = new SurveyAnalayzingControl();
		   try {
			   		aFrame.start(primaryStage);
		   } catch (Exception e1) {
			   		System.out.println("cannot start Expert Window");
		   }
		   
	   }
	   
	   
	   
	   else if(userPermition.equals("systemmanager"))
	   {
		   
		   changeEntry(UserNameToCheck); //user loged in - change the entry in DB to 1

		   ManagmentControl aFrame = new ManagmentControl();
		   try {
			   		aFrame.start(primaryStage);
		   } catch (Exception e1) {
			   		System.out.println("cannot start SystemManager Window");
		   }
	   }
	   
	   
	   else if(userPermition.equals("branchworker"))
	   {		
			   changeEntry(UserNameToCheck); //user loged in - change the entry in DB to 1

			   FillSurveyControl aFrame = new FillSurveyControl();
				try {
					aFrame.start(primaryStage);
				} catch (IOException e) {
					System.out.println("Cannot start branchworker Window");
				}
			
	   }
	   
	   
	   else if(userPermition.equals("branchmanager"))
	   {			
			   changeEntry(UserNameToCheck); //user loged in - change the entry in DB to 1

			   BranchManagerMainWindow aFrame = new BranchManagerMainWindow();
				try {
					aFrame.start(primaryStage);
				} catch (IOException e) {
					System.out.println("cannot start BranchManager Window");
				}
	   }
	   
	   
	   else if(userPermition.equals("chainworker"))
	   {
			changeEntry(UserNameToCheck); //user loged in - change the entry in DB to 1

			CatalogEditControl aFrame = new CatalogEditControl();

			try {
					aFrame.start(primaryStage);
			} catch (Exception e) {
					System.out.println("Cannot start chain worker Window");
			}
					
	   }
	   
	   else if(userPermition.equals("customer") )
	   {
		   changeEntry(UserNameToCheck); //user loged in - change the entry in DB to 1

		   CustomerMainWindow aFrame = new CustomerMainWindow();
			try {
				aFrame.start(primaryStage);
			} catch (IOException e) {
				System.out.println("cannot start CustomerMainWindow");
			}
	   }
	   
	   else if(userPermition.equals("customerservicedepartmentemployee"))
	   {
		   
		   changeEntry(UserNameToCheck); //user loged in - change the entry in DB to 1

		   CustomerServiceDepartmentworkerMainWindow aFrame = new CustomerServiceDepartmentworkerMainWindow();
		   try {
			   		aFrame.start(primaryStage);
		   } catch (Exception e) {
					System.out.println("cannot start customer service department employee Window");
		   }
	   }
	   
	   
	   else if(userPermition.equals("chainmanager"))
	   {		
			   changeEntry(UserNameToCheck); //user loged in - change the entry in DB to 1

			   ChainManagerMainWindow aFrame = new ChainManagerMainWindow();
				try {
					aFrame.start(primaryStage);
				} catch (IOException e) {
					System.out.println("cannot start chain Manager Window");
				}
	   }
	   }
	   
   }
   
   
   

   public void changeEntry(String UserName)
   {
	   int port=5555;
	   String ip="localhost";
	   try 
	   {
		 myClient = new ChatClient(ip,port);	//create new client
		 //myClient.setLoginControl(this);
	   } 
	   catch (IOException e) 
	   {
		   System.out.println("Cannot create client");	  
	   }
	   
	   	myClient.sendRequestToChangeEntry(UserName); //send request to change entry in db (server)
   }
  

   
   
   
	public void start(Stage primaryStage) throws IOException  
	{		
		Parent root = FXMLLoader.load(getClass().getResource("/Users/LoginWindow.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Login To The System"); // name of the title of the window
		primaryStage.setScene(scene);
	  	primaryStage.show();
	}

	 
}
