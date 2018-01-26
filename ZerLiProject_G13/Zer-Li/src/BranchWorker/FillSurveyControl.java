package BranchWorker;

import java.io.FileWriter;
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
import BranchManager.Reports;
import BranchManager.ordersReportEntry;
/**
 * 
 * @author Sharon & Elias
 *
 */
public class FillSurveyControl extends LoginContol implements Initializable {
	 private static final satisfactionSurvey NULL = null;
	 public static ObservableList<Integer> ListNumbers= FXCollections.observableArrayList();
	 
	 private  static ArrayList<Integer> DBcustomersList = new ArrayList<Integer>();
	 public static  ObservableList<Customer> customersList = FXCollections.observableArrayList();
	 public static ObservableList<Integer> customersIDList= FXCollections.observableArrayList();

	 public static int i=0;   //****************************************************check if need this . if not - delete
	 private ArrayList<satisfactionSurvey> MyFillSurveyList = new ArrayList<satisfactionSurvey>();
	 public static boolean stepAns;
		
	 
	
	 
	 @FXML
	 private Button FillSurveyBtn;
	 @FXML
	    private Label qes1;

	    @FXML
	    private Label qes2;

	    @FXML
	    private Label qes3;

	    @FXML
	    private Label qes4;

	    @FXML
	    private Label qes5;

	    @FXML
	    private Label qes6;


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
    private AnchorPane AnchorPaneNoSurvey;
    
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
    private ComboBox<Integer> pickCustomerComboBox;



    @FXML
    private Button PlusBtn;


    

    
    //events:
    
    
    @FXML
    void goHome(ActionEvent event) 
    {
    	
    	btnHome.getScene().getWindow().hide(); //hiding primary window
	   	Stage primaryStage = new Stage();
	   	Pane root=null;
		FillSurveyControl aFrame = new FillSurveyControl();
		try 
		{
			aFrame.start(primaryStage);
		} catch (IOException e) 
		{
			System.out.println("Cannot start branchworker Window");
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
	    	AnchorPanePickCustomer.setVisible(true);
    		AnchorPaneFillAns.setVisible(false);
    		
    		satisfactionSurvey Surveytemp = new satisfactionSurvey() ; 
         
   		 Surveytemp.setCustomerID(pickCustomerComboBox.getValue());
   		Surveytemp.setStep(1);
   		Surveytemp.setQarSurvey(1);
   		Surveytemp.setSurveyYear("2018");
   		Surveytemp.setQ1(Combo1.getValue());
  		Surveytemp.setQ2(Combo2.getValue());
  		Surveytemp.setQ3(Combo3.getValue());
  		Surveytemp.setQ4(Combo4.getValue());
  		Surveytemp.setQ5(Combo5.getValue());
  		Surveytemp.setQ6(Combo6.getValue());

        MyFillSurveyList.add(Surveytemp);
        System.out.println(MyFillSurveyList);

        customersIDList.remove(pickCustomerComboBox.getValue());
    	
     
		 
         	
	    	
	    	
	    }
	    
	    

	    @FXML
	    void pickCustomerFromComboBox(ActionEvent event) 
	    {
	//  	getCustomerIdList();
	    }
	    
	    
	    @FXML
	    void AddNewFill(ActionEvent event)
	    {
	    	if(stepAns) //stepAns=true , meaning service department created survey - we can fill surveys.
	    	{
	    		
	    		AnchorPanePickCustomer.setVisible(false);
	    		AnchorPaneFillAns.setVisible(true);
	    		
		    	if(!(pickCustomerComboBox.getSelectionModel().isEmpty())) //check if we selected customer
		    	{
		    		if(customersList.contains(pickCustomerComboBox.getSelectionModel().getSelectedItem())) // check if we already fill this customer
		    		{    
		       		    
 	  
		    		}
		    		else
		    		{
		    			//error msg***********************
		    		}
		    	}
		    	else //no selected customer
		    	{
		    		//error msg***********************
		    	}
	    	}
	    	else  //stepAns is false (branch worker didn't fill all surveys) we can't see survey result
	    	{
	    		AnchorPanePickCustomer.setVisible(false);
	    		AnchorPaneNoSurvey.setVisible(true);    		
	    	}


	    }


	    @FXML
	    void SaveOnDB(ActionEvent event) 
	    {
	    	if(!(MyFillSurveyList.isEmpty()))
	    	{
	    		satisfactionSurvey SurveyAVG = new satisfactionSurvey() ;
	    		SurveyAVG.setStep(1);
	    		SurveyAVG.setQarSurvey(MyFillSurveyList.get(i).getQarSurvey());
	    		SurveyAVG.setSurveyYear(MyFillSurveyList.get(i).getSurveyYear());
	    		int i;
	    		float q1=0,q2=0,q3=0,q4=0,q5=0,q6=0;
	    	    for (i=0;i<MyFillSurveyList.size();i++)
	    	    {
	    	    	 q1+=MyFillSurveyList.get(i).getQ1();
	    	    	 q2+=MyFillSurveyList.get(i).getQ2();
	    	    	 q3+=MyFillSurveyList.get(i).getQ3();
	    	    	 q4+=MyFillSurveyList.get(i).getQ4();
	    	    	 q5+=MyFillSurveyList.get(i).getQ5();
	    	    	 q6+=MyFillSurveyList.get(i).getQ6();
	    	    }  
	    	    SurveyAVG.setQ1(q1/MyFillSurveyList.size());
	    	    SurveyAVG.setQ2(q2/MyFillSurveyList.size());
	    	    SurveyAVG.setQ3(q3/MyFillSurveyList.size());
	    	    SurveyAVG.setQ4(q4/MyFillSurveyList.size());
	    	    SurveyAVG.setQ5(q5/MyFillSurveyList.size());
	    	    SurveyAVG.setQ6(q6/MyFillSurveyList.size());
	    		System.out.println(SurveyAVG);	 

	   	 int port=PORT;
		   String ip=ServerIP;
		   try 
		   {
				myClient = new ChatClient(ip,port);	//create new client to get all users in db (server)
				myClient.setLoginControl(this); //**********************************************************to check if need this ??!
		   } 
		   catch (IOException e) 
		   {
			   System.out.println("Cannot create client");	  
		   }
  	         myClient.sendRequestToSaveSurveyResult(SurveyAVG); 
  	         
  	          
  	       writeToCSV(SurveyAVG, SurveyAVG.getQarSurvey()  ,Integer.parseInt(SurveyAVG.getSurveyYear()) );
  	         
  	         
  	         
	    	}
	    	else {
	    		System.out.println("No Fills !");	 
	    		
	    	}
	  /* 	int NumberOfCustomers =DBcustomersList.size();
	    	int NumberOfSurveiesFilled = customersList.size();
	    	if(NumberOfSurveiesFilled==NumberOfCustomers)
	    	{
		     System.out.println("aaaa");   // to delete this !!*******************************
		     
		     
		     int port=PORT;
			   String ip=ServerIP;
			   try 
			   {
					myClient = new ChatClient(ip,port);	//create new client to get all users in db (server)
					myClient.setLoginControl(this); //**********************************************************to check if need this ??!
			   } 
			   catch (IOException e) 
			   {
				   System.out.println("Cannot create client");	  
			   }
			   int sumQ1=0,sumQ2=0,sumQ3=0,sumQ4=0,sumQ5=0,sumQ6=0;
			   for(int j=0;j<MyFillSurveyList.size();j++)
			   {
				    
				   sumQ1+=MyFillSurveyList.get(j).getQ1();
				   sumQ2+=MyFillSurveyList.get(j).getQ2();	 
			       sumQ3+=MyFillSurveyList.get(j).getQ3();
				   sumQ4+=MyFillSurveyList.get(j).getQ4();
				   sumQ5+=MyFillSurveyList.get(j).getQ5();
				   sumQ6+=MyFillSurveyList.get(j).getQ6();
			   }
		   
			   
			   Survey SurveyResult = new Survey() ; 
			   

	//		   SurveyInfo.setBranchWorkerID(LoginContol.userID);
			   SurveyResult.setQ1(sumQ1/MyFillSurveyList.size());
			   SurveyResult.setQ2(sumQ2/MyFillSurveyList.size());
			   SurveyResult.setQ3(sumQ3/MyFillSurveyList.size());
			   SurveyResult.setQ4(sumQ4/MyFillSurveyList.size());
			   SurveyResult.setQ5(sumQ5/MyFillSurveyList.size());
			   SurveyResult.setQ6(sumQ6/MyFillSurveyList.size());
			   
			   
			   System.out.println(sumQ1/MyFillSurveyList.size());	  
	
			   System.out.println(sumQ1);	 
			   System.out.println(sumQ2);	
			   System.out.println(sumQ3);	
	
			   System.out.println(SurveyResult);	  
	*/
		// 	   myClient.sendRequestToSaveObjectOnDB(SurveyResult); //send request to get all users from db (server)
	       
			  // while( myClient.isConnected());	//wait until client (this class) get all users from the db!
	    /*	}
	    	else
	    	{
	    		//error msg -you didn't finish to fill all customers 
	    	}*/
			  
	    }
	    
		 


		
		
	    public void checkIfStep0() //check if branch worker finish to fill surveys (step = 1 in DB table of satisfactionsurvies)
	    {
		 	   int port=PORT;
		 	   String ip=ServerIP;
		 	   try 
		 	   {
		 		 myClient = new ChatClient(ip,port);	//create new client
		 		 myClient.setSurveyControl(this);
		 	   } 
		 	   catch (IOException e) 
		 	   {
		 		   System.out.println("Cannot create client");	  
		 	   }
		 	   
		 	   	myClient.sendRequestToCheckStep0(); //send request to change entry in db (server) 	
		 	   	
	    }
		
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) 
		{
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
			 
	     
			for(int i=0;i<customersList.size();i++)
			{
				System.out.println(customersList.get(i).getCustomerID());	

				customersIDList.add(customersList.get(i).getCustomerID());
				 
			}
			 
			 
 			System.out.println(customersList);	

			System.out.println(customersIDList);	
			pickCustomerComboBox.setItems(customersIDList);
		 
	    }
	    
		public void writeToCSV(satisfactionSurvey satisfaction, int quarter, int year) {
			String FileHeader = "Q1,Q2,Q3,Q4,Q5,Q6\n";
			String csvFileName =  System.getProperty("user.dir")+"\\ZerLiProject_G13\\Zer-Li\\src\\Reports\\satisfactionSurvey_Report_" + String.valueOf(quarter) + "-" + String.valueOf(year)+".csv";
			System.out.println("the set file name plus path is: "+csvFileName);
			try {
				FileWriter writer = new FileWriter(csvFileName);

				//append headers
				writer.append(new StringBuilder(FileHeader).toString());
				/*add all the existing entries from the DB to the CVS file
				each field is separated by a comma, new line with '\n'
				currently the CSV file is saved to the main directory
				for example C:\\*/
				 
					StringBuilder sb = new StringBuilder();
					sb.append(String.valueOf(satisfaction.getQ1()));
					sb.append(",");
					sb.append(String.valueOf(satisfaction.getQ2()));
					sb.append(",");
					sb.append(String.valueOf(satisfaction.getQ3()));
					sb.append(",");
					sb.append(String.valueOf(satisfaction.getQ4()));
					sb.append(",");
					sb.append(String.valueOf(satisfaction.getQ5()));
					sb.append(",");
					sb.append(String.valueOf(satisfaction.getQ6()));
					sb.append(",");
					sb.append("\n");
					System.out.println("currently appending to csv: " + sb.toString());
					writer.append(sb.toString());
				 
				//force save the CVS to the drive
				writer.flush();
				writer.close();
				
			   addNewReport(4,year+"",quarter,csvFileName,"211");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void addNewReport(int reporttype, String year ,int qar,String csvFile,String branchid )
		{
			Reports newReport=new Reports(reporttype,year,qar,csvFile,branchid);
			System.out.println(newReport);
			 int port=PORT ;
		 	   String ip=ServerIP ;
	 	 	   try 
		 	   {
		 		myClient = new ChatClient(ip,port);	//create new client to get all users in db (server)
		 		myClient.setLoginControl(this); 
		 	   } 
		 	   catch (IOException e) 
		 	   {
		 		   System.out.println("Cannot create client");	  
		 	   }
		 	    
	 	 	 myClient.AddNewReportToDB(newReport); 

			
			
			
			
		}
		public void start(Stage primaryStage) throws IOException 
		{	
			 
			int port=PORT;
			   String ip=ServerIP;
			   try 
			   {
					myClient = new ChatClient(ip,port);	//create new client to get all users in db (server)
					myClient.setLoginControl(this); //**********************************************************to check if need this ??!
			   } 
			   catch (IOException e) 
			   {
				   System.out.println("Cannot create client");	  
			   }
	    	myClient.sendRequestToGetAllCustomer(); 
			
			Parent root = FXMLLoader.load(getClass().getResource("/BranchWorker/FillSurvey.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Branch Worker - Survey"); // name of the title of the window
			primaryStage.setScene(scene);
		  	primaryStage.show();
		   
		  	 
		  	checkIfStep0(); //check if branch worker finish to fill surveys (step = 1 in DB table of satisfactionsurvies)
		  	
			//Can't close the window without logout
			primaryStage.setOnCloseRequest( event -> {event.consume();} );
			
			
		 	 
		}
		


	
}
