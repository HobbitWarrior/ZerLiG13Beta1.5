package Customer;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import Users.LoginContol;
import client.ChatClient;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class OrdersControl extends LoginContol implements Initializable
{
	public static ObservableList<ItemInOrder> ItemsInOrderList= FXCollections.observableArrayList();
	public static ObservableList<String> oneBranchName= FXCollections.observableArrayList();

	private static int totalQuantity=0;
	private static double totalPrice=0;
	private static boolean checkboxFilled=false;
	private static String textGreeting="";
	private static Date  supplyTimeDate  ;
	private static Date  completedTransactionDate ;
	private static Time supplyTime;
	private static Time completedTransactionDateTime;
	private static String selfArrivalBranch="";
	private static boolean expeditedSupplying=false;
	private static Delivery myShipment;	
	private ObservableList<String> hourList = FXCollections.observableArrayList();
	private ObservableList<String> MinutesList = FXCollections.observableArrayList();
	private LocalDateTime now;

	@FXML
    private TableView<ItemInOrder> ItemInOrderTable;		//screen1
	
    @FXML
    private TableColumn<ItemInOrder, Integer> itemInOrderIDcolmun;  //screen1
    
    @FXML
    private TableColumn<ItemInOrder, String> itemInOrderNameColmuns;	//screen1
    
    @FXML
    private TableColumn<ItemInOrder, Integer> itemInOrderQtyColmun;		//screen1
    
    @FXML
    private TableColumn<ItemInOrder, String> itemInOrderPriceColumns;	//screen1
    @FXML
    private  TextArea txtGreeting;	//screen1

    @FXML
    private Button logoutBtn;

    @FXML
    private Button accountBtn;

    @FXML
    private Button btnCatalog;

    @FXML
    private CheckBox AddGreetingChkBox; 	//screen1
   
    @FXML
    private Button goToDelivery;	//screen1


    @FXML
    private Button btnHome;

    @FXML
    private Label totalPriceLabel;	//screen1
    
    @FXML
    private Label totalProductsAmountLabel; //screen1
    
    @FXML
    private Label yourinvoiceLabel; //screen1
    
    @FXML
    private Label YourcartLabel; //screen1
    
    @FXML
    private Label DeliverLabel; 

    @FXML
    private Label CheckoutLabel;
    
    @FXML
    private Label messageAfterGreeting; //screen1

    @FXML
    private Button BackToCartBtn; //screen2
    
    @FXML
    private Button goToCheckoutBtn; //screen2
    

    @FXML
    private Label dateLabel; //screen2
    
    @FXML
    private Label SupplyTimeLabel; //screen2
    
    @FXML
    private Label ShipmentLabel; //screen2
    
    @FXML
    private Label HourLabel; //screen2

    @FXML
    private DatePicker ComboDate;  //screen2
    
    
    @FXML
    private ComboBox<String> comboBoxHour;  //screen2
    
    @FXML
    private RadioButton branchRadio;  //screen2
    
    @FXML
    private RadioButton privateAdressRadio;  //screen2
    
    @FXML
    private Label aditionalCostLabel;	//screen2
    
    @FXML
    private Label adressShipmentLabel;	//screen2
    
    @FXML
    private Label adresseeShipmentLabel;	//screen2
    
    @FXML
    private Label phoneNumberShipmentLabel;	//screen2
    
    @FXML
    private TextField phoneNumberTxt;	//screen2

    @FXML
    private TextField adressShipmentTxt;	//screen2
    
    @FXML
    private TextField adresseeShipmentTxt;	//screen2
    
    @FXML
    private ComboBox<String> KidometPhone;	//screen2
    
    @FXML
    private ComboBox<String> comboBranch;	//screen2
    
    @FXML
    private Label makafKidometNumPhone; 	//screen2
    

    @FXML
    private ToggleGroup delivery;			//screen 2

    
    @FXML
    void KidometChosen(ActionEvent event) 
    {
    	
    		phoneNumberTxt.setDisable(false);
    
    }
    
    @FXML
    void branchRadioChosen(ActionEvent event) //if customer chose a self arrival delivery
    {
    	this.comboBranch.setDisable(false);
    	this.comboBoxHour.setDisable(false);
    	this.adressShipmentTxt.setDisable(true);
    	this.adresseeShipmentTxt.setDisable(true);
    	this.KidometPhone.setDisable(true);
    	this.phoneNumberTxt.setDisable(true);
    	this.adressShipmentTxt.clear();
    	this.adresseeShipmentTxt.clear();
    	this.phoneNumberTxt.clear();
    	KidometPhone.valueProperty().set(null);

    	
    	
    }

    @FXML
    void privateAdressRadioChosen(ActionEvent event) 
    {
    	comboBranch.valueProperty().set(null);
    	this.comboBranch.setDisable(true);
    	this.comboBoxHour.setDisable(false);
    	this.adressShipmentTxt.setDisable(false);
    	this.adresseeShipmentTxt.setDisable(false);
    	this.KidometPhone.setDisable(false);
    	this.phoneNumberTxt.setDisable(true);
    	this.adressShipmentTxt.clear();
    	this.adresseeShipmentTxt.clear();
    	this.phoneNumberTxt.clear();
    	
    	
    }
    
    
    @FXML
    void comboBoxDatePressed(ActionEvent event) 
    {
    	supplyTimeDate=null;
    	supplyTime=null;
    	hourList.clear();
    	 MinutesList.clear();
    	supplyTimeDate= new Date(ComboDate.getValue().getYear(), ComboDate.getValue().getMonthValue(), ComboDate.getValue().getDayOfMonth());
    	comboBoxHour.setDisable(false);
    	comboBoxHour.setDisable(false);
    	LocalDateTime now = LocalDateTime.now(); 

    	if(supplyTimeDate.getYear()==now.getYear() && supplyTimeDate.getMounth() == now.getMonthValue() && supplyTimeDate.getDay() == now.getDayOfMonth())	//in case customer chose curretn day
    	{
    		int hourTime= now.getHour();	
    		for (int i = hourTime+1 ; i<24;i++)	//it will show him the next hour up to 23 Oclock
    		{
    			if(i<10)
    				hourList.add("0"+i);
    			else
    				hourList.add(""+i);

    		}
    	}
    	
    	else	//if user chose the future, it will show him all hour per day
    	{
    		for (int i = 0 ; i<10;i++)
    		{
    			hourList.add("0"+i);
    		}
    		
    		for (int i = 10 ; i<24;i++)
    		{
    			hourList.add(""+i);
    		}
    	}
    	comboBoxHour.setItems(hourList); 

    }
    
    
    
    @FXML
    void comboBoxHourPressed(ActionEvent event) 
    {
    	supplyTime=null;
    	System.out.println(""+supplyTimeDate);
    	System.out.println(""+supplyTime);
		
    }
    
    
    
    @FXML
    void goToCheckoutBtnPressed(ActionEvent event) 
    {
    	String ErrorMsg="";
    	if(ComboDate.getValue() == null)	//check is customer picked date
    		ErrorMsg=ErrorMsg+"Supply date.\n";
    	
    	if(comboBoxHour.getValue() == null)	//check is customer picked hour
    		ErrorMsg=ErrorMsg+"Supply time.\n";
    	
    	if(delivery.getSelectedToggle() ==null ) //check is customer picked kind of any delivery
    		ErrorMsg=ErrorMsg+"Delivery.\n";
    	else 	//if user did pick a king of delivery, then....
    		{
    			if(branchRadio.isSelected() == true)	//if he chose self arrival delivery,
    			{
    				if(comboBranch.getValue()== null)	//check if customer picked a branch in combobox
    				{	//not picked
    		    		ErrorMsg=ErrorMsg+"Branch to self arrival delivery.\n";
    				}
    			}
    			
    			else if(privateAdressRadio.isSelected() == true)	//if he chose self arrival delivery,
    			{
    				if(adressShipmentTxt.getText().equals(""))	//check if customer entered adress to text field
    				{	//not picked
    		    		ErrorMsg=ErrorMsg+"Adress for private shipment.\n";
    				}
    				if(adresseeShipmentTxt.getText().equals(""))	//check if customer entered adressee to text field
    				{	//not picked
    		    		ErrorMsg=ErrorMsg+"Adressee for private shipment.\n";
    				}
    				
    				if(KidometPhone.getValue() ==null) //check if customer entered phone number by check kidomet
    				{
    		    		ErrorMsg=ErrorMsg+"Phone number.\n";

    				}
    				
    				else
    				{
    					if(phoneNumberTxt.getText().equals(""))
        		    		ErrorMsg=ErrorMsg+"Phone number.\n";

    				}
    			}
    			calculateTotalPriceAndQuantity();
    			
    		
    		}
    	
    	if(!ErrorMsg.equals(""))	//if there is an error (at least one) show error message and get out from this method, to prevent customer to arrive to payments level
    	{
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("You cannot procced to checkout!");
    		alert.setHeaderText("The folowing details are false or missing:");
    		alert.setContentText(ErrorMsg);
    		alert.showAndWait();
    		return;
    	}
    	int chosenYear=ComboDate.getValue().getYear();
    	int chosenMounth=ComboDate.getValue().getMonthValue();
    	int chosenDay=ComboDate.getValue().getDayOfMonth();
        LocalDateTime now = LocalDateTime.now(); 	//here we will check if customer picked expedited delivery for boolean value of customerorder class
    	int nowYear=now.getYear();
    	int nowMounth=now.getMonthValue();
    	int nowDay=now.getDayOfMonth();
    	supplyTimeDate =new Date(chosenYear ,chosenMounth , chosenDay);	//here we create date of supplying for customerOrder class
    	supplyTime = new Time(comboBoxHour.getValue(), "00", "00");	//here we keep the date of supplying that customer wanted

    	
    	if(nowYear == chosenYear && nowMounth == chosenMounth && nowDay== chosenDay) //if customer want the supplying today....
    	{
    		int nowHour = now.getHour();
    		int supplyHour = Integer.parseInt(supplyTime.getHour());
    		if ((supplyHour-nowHour) <=3 )	//if customer want his order in the next 3 hours, then define this order to be expedited
    		{
    			expeditedSupplying=true;
    		}
    		
    		else
    		{
    			expeditedSupplying=false;		//if customer want his order in more than 3 hours, then this order is not expedited

    		}
    	}

    	else
    	{
			expeditedSupplying=false;	//if customer want his order in more than 1 day later, then this order is not expedited

    	}
        
     
    	if(branchRadio.isSelected())
    	{
    		String myBranchName=comboBranch.getValue();	
    		String myBranchAdress="";
    		for (int i=0; i < CustomerMainWindow.AllBranches.size() ; i++)	//we look for the address of the branch's name
    		{
    			String checkBranchName=CustomerMainWindow.AllBranches.get(i).getBranchName();	//keep the current scanned branch
    			if(checkBranchName.equals(myBranchName))
    			{
    				myBranchAdress=CustomerMainWindow.AllBranches.get(i).getBrancAdress();
    				break;
    			}
    		}
    		
    		myShipment=new BranchShipment(myBranchName,myBranchAdress);	//create delivery of self arrival, 
    		System.out.println(""+((BranchShipment)myShipment).getBranchName()+", "+ ((BranchShipment)myShipment).getBranchAdress());
    	}
    	
    	else if(privateAdressRadio.isSelected())
    	{
    		String Address=adressShipmentTxt.getText();
    		String Adressee=adresseeShipmentTxt.getText();
    		String PhoneNum=KidometPhone.getValue()+"-"+phoneNumberTxt.getText();
    		myShipment = new PrivateShipment(14.99,Adressee, Address, PhoneNum);  
    		System.out.println(((PrivateShipment)myShipment).getAddressee()+", " +((PrivateShipment)myShipment).getPhoneNumber()+", "+((PrivateShipment)myShipment).getAddress());
    	}
    	
    	

    }
    
    @FXML
    void BackToCartBtnPressed(ActionEvent event) 
    {
    	/*yourinvoiceLabel.setVisible(true);
    	ItemInOrderTable.setVisible(true);
    	totalProductsAmountLabel.setVisible(true);
    	totalPriceLabel.setVisible(true);
    	AddGreetingChkBox.setVisible(true);
    	txtGreeting.setVisible(true);
    	YourcartLabel.setTextFill(Color.web("#34fffc"));
    	DeliverLabel.setTextFill(Color.WHITE);
    	BackToCartBtn.setVisible(false);
    	goToDelivery.setVisible(true);
		*/
    	ShowScreenONE();
    }
    
    @FXML
    void goToDeliveryPressed(ActionEvent event) 
    {
    	ShowScreenTWO();
    	
    }
    
    
    @FXML
    void AccountBtnPressed(ActionEvent event) 
    {
    	checkboxFilled =AddGreetingChkBox.isSelected();
    	textGreeting = txtGreeting.getText();
    	accountBtn.getScene().getWindow().hide(); // hiding primary window
    	Stage primaryStage = new Stage();
    	AccountControl aFrame = new AccountControl();
    	try {
    		aFrame.start(primaryStage);
    		} 
    	catch (IOException e) 
    	{
		System.out.println("Cannot start Account Window");
    	}

    }
    
    
    @FXML
    void logoutPressed(ActionEvent event)throws IOException 
	{
    	
		changeEntry(UserNameToCheck);
		System.out.println("return to main menu");
		((Node) event.getSource()).getScene().getWindow().hide(); // hiding primary window
		LoginContol aFrame = new LoginContol(); // create Login Frame
		Stage arg0 = new Stage();
		OrdersControl.ItemsInOrderList.clear();
		aFrame.start(arg0);

	}

    @FXML
    void HomePresssed(ActionEvent event) 
    {
    	checkboxFilled =AddGreetingChkBox.isSelected();
    	textGreeting = txtGreeting.getText();
		btnHome.getScene().getWindow().hide(); // hiding primary window
		Stage primaryStage = new Stage();
		CustomerMainWindow aFrame = new CustomerMainWindow();
		try 
		{
			aFrame.start(primaryStage);
		} 
		catch (IOException e) 
		{
			System.out.println("Cannot start Customer main Window");
		}
    }



    @FXML
    void textFieldfilled(ActionEvent event) 
    {
    
    }
    
    
    
    @FXML
    void ChkBoxPressed(ActionEvent event) 
    {

    	if(AddGreetingChkBox.isSelected())
    	{
    		if(ItemsInOrderList.isEmpty())
    		{
    			Alert alert = new Alert(AlertType.ERROR);
    			alert.setTitle("Your cart is empty!");
    			alert.setHeaderText("Your invoice is empty");
    			alert.setContentText("You did not selected any product");
    			alert.showAndWait();
    			AddGreetingChkBox.setSelected(false);
    			return;
    		}
    		
    		txtGreeting.setDisable(false);
    		ThreadLabelTxtArea preparLabel = new ThreadLabelTxtArea(this.txtGreeting, this.messageAfterGreeting);
    		preparLabel.start();
    	}
    	
    	else
    	{
    		
    		txtGreeting.setDisable(true);
    		//messageAfterGreeting.setVisible(false);


    	}
    }
	
	
	public void start(Stage primaryStage) throws IOException 
	{
		Pane root = FXMLLoader.load(getClass().getResource("/Customer/OrdersControl.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Create an order"); // name of the title of the window
		primaryStage.setScene(scene);
		primaryStage.show();
		//int port = 5555;
		//String ip = "localhost";
		//myClient = new ChatClient(ip, port); // create new client
		

		// Can't close the window without logout
		primaryStage.setOnCloseRequest(event -> {
			event.consume();
		});
	}

	
	public static void calculateTotalPriceAndQuantity()
	{
		int amountItems = 0;
		  double totaPprice=0;
		  ObservableList<ItemInOrder> allItemToBuy = ItemsInOrderList;
		  for(int i=0 ; i< allItemToBuy.size(); i++)
		  {
			  amountItems = amountItems + allItemToBuy.get(i).getItemQty();
			  totaPprice = totaPprice + allItemToBuy.get(i).getTotalPrice();
		  }
		   totalQuantity = amountItems;
		   totalPrice = totaPprice;
		  
	}
	
	
	  public static String CutDoubleNumUpToTwoDigitAfterPoint(double num)
	  {
		  String cutDoubleNum = "" +num;
		  String result="";
		  for (int i = 0; i < cutDoubleNum.length();i++)
		  {
			  if(cutDoubleNum.charAt(i) == '.')
			  {
				  result=result+""+cutDoubleNum.charAt(i);
				  if((i+2) < cutDoubleNum.length())
				  {
					  result=result+""+cutDoubleNum.charAt(i+1) +""+cutDoubleNum.charAt(i+2);	//cut up to 2 digits after point, in case there is more than 2 digits after point
					  break;
				  }
				  else
				  {
					  result=result+""+cutDoubleNum.charAt(i+1); //cut up to 1 digits after point, in case there is less than 2 digits after point
					  break;

				  }
				  
			  }
			  else
			  {
				  result=result+""+cutDoubleNum.charAt(i);
			  }
		  }
		  return result;
	  }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		ShowScreenONE();
		itemInOrderIDcolmun.setCellValueFactory(new PropertyValueFactory<ItemInOrder, Integer>("itemID"));
		itemInOrderNameColmuns.setCellValueFactory(new PropertyValueFactory<ItemInOrder, String>("itemName"));
		itemInOrderQtyColmun.setCellValueFactory(new PropertyValueFactory<ItemInOrder, Integer>("itemQty"));
		itemInOrderPriceColumns.setCellValueFactory(new PropertyValueFactory<ItemInOrder,  String>("itemTotalPriceWithCoin"));
		itemInOrderIDcolmun.setStyle( "-fx-alignment: CENTER;");
		itemInOrderNameColmuns.setStyle( "-fx-alignment: CENTER;");
		itemInOrderQtyColmun.setStyle( "-fx-alignment: CENTER;");
		itemInOrderPriceColumns.setStyle( "-fx-alignment: CENTER;");
	    ItemInOrderTable.setItems(ItemsInOrderList);
	    calculateTotalPriceAndQuantity();
	    double totalPrice = getTotalPrice();
		int totalQuantity = getTotalQuantity();
		  String fixNum = "" +CutDoubleNumUpToTwoDigitAfterPoint(totalPrice);  
	    totalProductsAmountLabel.setText("Total products: " + totalQuantity + " items.");
	    totalPriceLabel.setText("Toal price: "+ fixNum +"$.");
	    //checkboxFilled 
	    if (ItemsInOrderList.isEmpty()) //in case invoice is empte, we clear checkbox and text area, no matta what contend they had from previous stages (in case we kept data there and then we deleted items in the invoice, then we should delete check box and text area and start over)
	    {
	    	goToDelivery.setDisable(true);
	    	checkboxFilled=false;
	    	textGreeting="";
    		txtGreeting.setDisable(true);
    		AddGreetingChkBox.setSelected(checkboxFilled); 
    		txtGreeting.setText(textGreeting);
	    }
	    else	//in case invoice is not empty! (invoice = items in the table!)
	    {
	    	if(checkboxFilled)	//if checkbox left open at the previous stage restore content of checkbox and text area (which means the greeting we inserted
	    	{
	    		AddGreetingChkBox.setSelected(checkboxFilled); 
	    		txtGreeting.setText(textGreeting);
	    		txtGreeting.setDisable(false);
	    	}
	    
	    	else  //in case we inserted greeting, but canceled the check box
	    	{
	    		txtGreeting.setText(textGreeting);
	    		txtGreeting.setDisable(true);
	    	}
	    }
	    
    	BackToCartBtn.setVisible(false);
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now(); 
        comboBranch.setItems(this.oneBranchName); //**************
    	LocalDate minDate = LocalDate.of(now.getYear(), now.getMonth(), now.getDayOfMonth());
        LocalDate maxDate = LocalDate.of(2100, Month.DECEMBER, 31);
        ComboDate.setDayCellFactory((p) -> new DateCell() {
           
        	
        	@Override
            public void updateItem(LocalDate ld, boolean bln) 	//this part is making dates to be disabled before the current day
            {
                super.updateItem(ld, bln);
                setDisable(ld.isBefore(minDate) || ld.isAfter(maxDate));
            }
        });
        Platform.runLater(() -> {
        	ComboDate.getEditor().clear();
        });
        ComboDate.setDisable(false);
          comboBoxHour.setDisable(true);
          ObservableList<String> phoneKidomet= FXCollections.observableArrayList("02","03","02","04","08","09","050","052","053","054","055","058");
     	 KidometPhone.setItems(phoneKidomet);
	}

	
	
	public static int getTotalQuantity() 
	{
		return totalQuantity;
	}

	public static void setTotalQuantity(int totalQuantity) 
	{
		OrdersControl.totalQuantity = totalQuantity;
	}

	public static double getTotalPrice() 
	{
		return totalPrice;
	}

	public static void setTotalPrice(double totalPrice) 
	{
		OrdersControl.totalPrice = totalPrice;
	}
	
	private void ShowScreenONE()
	{
		goToDelivery.setVisible(true);
		BackToCartBtn.setVisible(false);
		yourinvoiceLabel.setVisible(true);
    	ItemInOrderTable.setVisible(true);
    	totalProductsAmountLabel.setVisible(true);
    	totalPriceLabel.setVisible(true);
    	AddGreetingChkBox.setVisible(true);
    	txtGreeting.setVisible(true);
    	YourcartLabel.setTextFill(Color.web("#34fffc"));
       	DeliverLabel.setTextFill(Color.WHITE);
    	BackToCartBtn.setVisible(false);
    	goToDelivery.setVisible(true);
    	messageAfterGreeting.setVisible(false);
    	SupplyTimeLabel.setVisible(false);	//from here it is the second part of window = delivery
    	dateLabel.setVisible(false);
    	ComboDate.setVisible(false);
    	HourLabel.setVisible(false);
    	comboBoxHour.setVisible(false);
    	ShipmentLabel.setVisible(false);
    	branchRadio.setVisible(false);
    	comboBranch.setVisible(false);
    	privateAdressRadio.setVisible(false);
    	aditionalCostLabel.setVisible(false);
    	adressShipmentLabel.setVisible(false);
    	adressShipmentTxt.setVisible(false);
    	adresseeShipmentLabel.setVisible(false);
    	adresseeShipmentTxt.setVisible(false);
    	phoneNumberShipmentLabel.setVisible(false);
    	KidometPhone.setVisible(false);
    	phoneNumberTxt.setVisible(false);
    	phoneNumberTxt.setDisable(true);
    	goToCheckoutBtn.setVisible(false);
    	//end of screen 2 = delivery
	}
	
	private void ShowScreenTWO()
	{
		goToDelivery.setVisible(false);
		goToCheckoutBtn.setVisible(true);
		yourinvoiceLabel.setVisible(false);
    	ItemInOrderTable.setVisible(false);
    	totalProductsAmountLabel.setVisible(false);
    	totalPriceLabel.setVisible(false);
    	AddGreetingChkBox.setVisible(false);
    	txtGreeting.setVisible(false);
    	YourcartLabel.setTextFill(Color.WHITE);
    	DeliverLabel.setTextFill(Color.web("#34fffc"));
    	BackToCartBtn.setVisible(true);
    	goToDelivery.setVisible(false);
    	messageAfterGreeting.setVisible(false);
    	SupplyTimeLabel.setVisible(true);	//from here it is the second part of window = delivery
    	dateLabel.setVisible(true);
    	ComboDate.setVisible(true);
    	HourLabel.setVisible(true);
    	comboBoxHour.setVisible(true);
    	ShipmentLabel.setVisible(true);
    	branchRadio.setVisible(true);
    	comboBranch.setVisible(true);
    	privateAdressRadio.setVisible(true);
    	aditionalCostLabel.setVisible(true);
    	adressShipmentLabel.setVisible(true);
    	adressShipmentTxt.setVisible(true);
    	adresseeShipmentLabel.setVisible(true);
    	adresseeShipmentTxt.setVisible(true);
    	phoneNumberShipmentLabel.setVisible(true);
    	KidometPhone.setVisible(true);
    	phoneNumberTxt.setVisible(true);
    	phoneNumberTxt.setDisable(true);
    	//end of screen 2 = delivery
    	
	}
}
