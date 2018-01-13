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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class OrdersControl extends LoginContol implements Initializable
{
	public static ObservableList<ItemInOrder> ItemsInOrderList= FXCollections.observableArrayList();
	
	private static int totalQuantity=0;
	private static double totalPrice=0;
	private static boolean checkboxFilled=false;
	private static String textGreeting="";
	private static Date  supplyTimeDate  ;
	private static Date  completedTransactionTime ;

	
	private LocalDateTime now;

	@FXML
    private TableView<ItemInOrder> ItemInOrderTable;
	
    @FXML
    private TableColumn<ItemInOrder, Integer> itemInOrderIDcolmun;
    
    @FXML
    private TableColumn<ItemInOrder, String> itemInOrderNameColmuns;
    
    @FXML
    private TableColumn<ItemInOrder, Integer> itemInOrderQtyColmun;
    
    @FXML
    private TableColumn<ItemInOrder, String> itemInOrderPriceColumns;
    @FXML
    private  TextArea txtGreeting;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button accountBtn;

    @FXML
    private Button btnCatalog;

    @FXML
    private CheckBox AddGreetingChkBox;
   
    @FXML
    private Button goToDelivery;


    @FXML
    private Button btnHome;

    @FXML
    private Label totalPriceLabel;
    
    @FXML
    private Label totalProductsAmountLabel;
    
    @FXML
    private Label yourinvoiceLabel;
    
    @FXML
    private Label YourcartLabel;
    
    @FXML
    private Label DeliverLabel;

    @FXML
    private Label CheckoutLabel;
    
    @FXML
    private Label messageAfterGreeting;

    @FXML
    private Button BackToCartBtn;
    
    @FXML
    private Button goToCheckoutBtn;
    

    @FXML
    private Label dateLabel;
    
    @FXML
    private Label SupplyTimeLabel;
    
    @FXML
    private Label ShipmentLabel;
    
    @FXML
    private Label HourLabel;

    @FXML
    private DatePicker ComboDate;
    
    @FXML
    private Label minutesLabel;
    
    @FXML
    private ComboBox<Date> comboBoxHour;
    
    @FXML
    private ComboBox<Date> ComboBoxMinutes;
    
    
    
    @FXML
    void comboBoxDatePressed(ActionEvent event) 
    {
    	//DatePicker ComboDate;
    	supplyTimeDate= new Date(ComboDate.getValue().getYear(), ComboDate.getValue().getMonthValue(), ComboDate.getValue().getDayOfMonth());
    	
    	System.out.println("" + supplyTimeDate);

    //	System.out.println("" + supplyTimeDate.MONTH );
    	

    	
    }
    
    
    
    @FXML
    void comboBoxHourPressed(ActionEvent event) 
    {

    }
    
    @FXML
    void ComboBoxMinutesPressed(ActionEvent event) 
    {

    }
    
    @FXML
    void goToCheckoutBtnPressed(ActionEvent event) 
    {

    }
    
    @FXML
    void BackToCartBtnPressed(ActionEvent event) 
    {
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

    }
    
    @FXML
    void goToDeliveryPressed(ActionEvent event) 
    {
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
		Pane root = FXMLLoader.load(getClass().getResource("/Customer/ordersCatalogCustomWindow.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Create an order"); // name of the title of the window
		primaryStage.setScene(scene);
		primaryStage.show();
		int port = 5555;
		String ip = "localhost";
		//myClient = new ChatClient(ip, port); // create new client
		//myClient.setCatalogOrderControl(this);
		//myClient.sendRequestToGetAllCatalogItems();

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
       
    	LocalDate minDate = LocalDate.of(now.getYear(), now.getMonth(), now.getDayOfMonth());
        LocalDate maxDate = LocalDate.of(2100, Month.DECEMBER, 31);
        ComboDate.setDayCellFactory((p) -> new DateCell() {
            @Override
            public void updateItem(LocalDate ld, boolean bln) {
                super.updateItem(ld, bln);
                setDisable(ld.isBefore(minDate) || ld.isAfter(maxDate));
            }
        });
        Platform.runLater(() -> {
        	ComboDate.getEditor().clear();
        });
        ComboDate.setDisable(false);
          comboBoxHour.setDisable(true);
         ComboBoxMinutes.setDisable(true);
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
}
