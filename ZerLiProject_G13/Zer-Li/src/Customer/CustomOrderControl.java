package Customer;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.ResourceBundle;

import Users.LoginContol;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class CustomOrderControl extends LoginContol implements Initializable
{
	public static ObservableList<Flower> allFlowers= FXCollections.observableArrayList();
	public static int numberOfColors=0;
	private String ItemType  ="";
	private int min=0;
	private int max=0;
	private String ItemColor ="";
	
	
	
		@FXML
	    private Label minLabel;

	    @FXML
	    private Button btnLogout;

	    @FXML
	    private Button createItemBtn;

	    @FXML
	    private ComboBox<String> DominantColorCombo;

	    @FXML
	    private Label itemTypeLabel;

	    @FXML
	    private Label MaxLabel;

	    @FXML
	    private ImageView imgController;

	    @FXML
	    private Label PriceRangeLabel;

	    @FXML
	    private Label DominantColorLabel;

	    @FXML
	    private ComboBox<String> itemTypeCombo;

	    @FXML
	    private TextField priceRangeMinTxt;

	    @FXML
	    private Button btnAccount;

	    @FXML
	    private Button btnHome;

	    @FXML
	    private Button btnCart;

	    @FXML
	    private TextField priceRangeMaxTxt;

	   

	    @FXML
	    void goHome(ActionEvent event) 
	    {
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
			((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window	

	    }

	    @FXML
	    void seeAccount(ActionEvent event) 
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
	    void btnCartPressed(ActionEvent event) 
	    {
	      	Stage primaryStage = new Stage();
	       	OrdersControl aFrame = new OrdersControl();
 			this.btnCart.getScene().getWindow().hide(); //hiding primary window

	 			try 
	 			{
	 				aFrame.start(primaryStage);
	 			} 
	 			catch (IOException e) 
	 			{
	 				System.out.println("Cannot start catalog Window");
	 			}
				((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window	

	    }

	    @FXML
	    void itemTypeComboPressed(ActionEvent event) 
	    {
	    	this.ItemType=itemTypeCombo.getValue();
	    }

	    @FXML
	    void DominantColorComboPressed(ActionEvent event) 
	    {
	    	this.ItemColor=DominantColorCombo.getValue();
	    }

	    @FXML
	    void createItemBtnPressed(ActionEvent event) 
	    {
	    	
	    	if( this.ItemType.equals("") || this.priceRangeMinTxt.getText().equals("") || this.priceRangeMaxTxt.getText().equals(""))
	    	{
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setTitle("You forgot to insert data of serach");
	    		alert.setHeaderText("Please fill all necessary fields!");
	    		alert.showAndWait();
	    		return;
	    	}
	    	
	    	Integer minField = new Integer(this.priceRangeMinTxt.getText());
	    	int tempIntMin = (int)minField;
	    	Integer maxField = new Integer(this.priceRangeMaxTxt.getText());
	    	int tempIntMax = (int)maxField;
	    	int result = tempIntMax - tempIntMin;
	    	if( result <= 0 )
	    	{
	    		Alert alert = new Alert(AlertType.ERROR);
	    		alert.setTitle("You inserted wrong values of price range");
	    		alert.setHeaderText("Your max range is lower than min range");
	    		alert.setContentText("Ooops, You inserted wrong range");
	    		alert.showAndWait();
	    		return;
	    	}
	    	
	    	if(tempIntMax >250)
	    	{
	    		Alert alert = new Alert(AlertType.WARNING);
	    		alert.setTitle("Sorry, There are some limits...");
	    		alert.setHeaderText("There is a limit for a custom product.");
	    		alert.setContentText("Our chain allowes a price up to 250$");
	    		alert.showAndWait();
	    		return;
	    	}
	    	
	    	this.max=tempIntMax;
	    	this.min=tempIntMin;
	    	ArrayList<Flower> flowerComposion = new ArrayList<Flower>();
	    	sortFlowers();
			System.out.println("all flowers before sorting:\n" +this.allFlowers+"\n\n");

	    	
	    	if(ItemColor.equals(""))
	    	{
	    		flowerComposion = createCompositeWithoutAnyColor(flowerComposion);
	    	}
	    	else
	    	{
	    		flowerComposion = createCompositeWithtColor(flowerComposion);

	    	}

	    }

	
	
	
	
	
	
	private ArrayList<Flower> createCompositeWithtColor(ArrayList<Flower> flowerComposion) //flowerComposion = basket 
	{
		
		
		
			return null;
	}

	private ArrayList<Flower> createCompositeWithoutAnyColor(ArrayList<Flower> flowerComposion) 
	{
		try
		{
		ArrayList<String> colorsInserted = new ArrayList<String>();
		double priceOfcomposite=0;
		for(int i=0 ; i < this.allFlowers.size() ; i++)	//scan all flower and put in the basket all of the cheapest flowers in different colors
		{
			if( ! colorsInserted.contains( allFlowers.get(i).getFlowerColor() ))	//if the color didn't count already
			{
				if(priceOfcomposite < this.max)	//if the total price of our composition is lower than the lower limit that customer choose put the flower in the basket
				{
					flowerComposion.add(this.allFlowers.get(i));
					priceOfcomposite=priceOfcomposite+this.allFlowers.get(i).getFlowerPrice();
					colorsInserted.add(this.allFlowers.get(i).getFlowerColor());
				}
				else
				{
					break;
				}
				
			}	
		}
		Random rand = new Random();

	
		while(priceOfcomposite<this.min || priceOfcomposite>this.max)
		{
			while(priceOfcomposite < this.max )	// if still we didn`t reach to the lower limit, take a random flower
			{
				int  myRandomNum = rand.nextInt(this.allFlowers.size()-1) ;
				flowerComposion.add(this.allFlowers.get(myRandomNum));
				priceOfcomposite=priceOfcomposite+this.allFlowers.get(myRandomNum).getFlowerPrice();
			}
		
			while(priceOfcomposite > this.max )	// if still we didn`t reach to the lower limit, take a random flower
			{
				int  myRandomNum = rand.nextInt(flowerComposion.size()-1) ;
				flowerComposion.remove(myRandomNum);
				priceOfcomposite=priceOfcomposite-this.allFlowers.get(myRandomNum).getFlowerPrice();
			}
		}
		
		//here we get all cheapest flowers from different colors
		System.out.println("total price of composiotn is : " +priceOfcomposite +" quantity of flowers is:"+flowerComposion.size());
		System.out.println("all flowers are:\n" +flowerComposion);
		}
		
		catch(Exception e)
		{
			System.out.println("Cannot find composition");
	    	ArrayList<Flower> flowerComposionSafe = new ArrayList<Flower>();
	    	return flowerComposionSafe;

			
		}
		return flowerComposion;
		}

	private static void sortFlowers()
	{
		FXCollections.sort(allFlowers, new Comparator<Flower>()
		{

			@Override
			public int compare(Flower firstFlower, Flower anotherFlower) {
				double comparePrice =  anotherFlower.getFlowerPrice();
				double result = firstFlower.getFlowerPrice() - comparePrice;
				if(result ==0)
					return 0;
				else if(result >0)
							return 1;
				else
					return -1;
			}
	
		});
	}
	
	
	
	
	
	
	public void start(Stage primaryStage) throws IOException  
	{		
		Parent root = FXMLLoader.load(getClass().getResource("/Customer/CustomOrderFrame.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Customer Custom Order"); // name of the title of the window
		primaryStage.setScene(scene);
	  	primaryStage.show();
		//Can't close the window without logout
		primaryStage.setOnCloseRequest( event -> {event.consume();} );
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		ObservableList<String> allTypes= FXCollections.observableArrayList("Bridal Bouquet","Flower Arrangement","Cluster Flowers","Flowering Plant");		
		itemTypeCombo.setItems(allTypes);
		ObservableList<String> allFlowerColors= FXCollections.observableArrayList();
		allFlowerColors.add("");	//an optional to not pick a color
		this.numberOfColors=0;
		for(int i=0 ; i< allFlowers.size() ; i++)
		{
			String currentColor = allFlowers.get(i).getFlowerColor();
			if(! allFlowerColors.contains(currentColor))	//if there is no coloer in the list of combobox
			{
				allFlowerColors.add(currentColor);
				this.numberOfColors++;

			}
		}
		
		
		DominantColorCombo.setItems(allFlowerColors);
		priceRangeMinTxt.textProperty().addListener(new ChangeListener<String>() 
		{
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		        	priceRangeMinTxt.setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		});
		
		priceRangeMaxTxt.textProperty().addListener(new ChangeListener<String>() 
		{
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		        	priceRangeMaxTxt.setText(newValue.replaceAll("[^\\d]", ""));
		        }
		    }
		});
		
	}
}
