package Customer;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Users.LoginContol;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class CustomOrderControl extends LoginContol implements Initializable
{
	public static ObservableList<Flower> allFlowers= FXCollections.observableArrayList();

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

	    }

	    @FXML
	    void DominantColorComboPressed(ActionEvent event) 
	    {

	    }

	    @FXML
	    void createItemBtnPressed(ActionEvent event) 
	    {

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
		for(int i=0 ; i< allFlowers.size() ; i++)
		{
			String currentColor = allFlowers.get(i).getFlowerColor();
			if(! allFlowerColors.contains(currentColor))	//if there is no coloer in the list of combobox
									allFlowerColors.add(currentColor);
		}
		DominantColorCombo.setItems(allFlowerColors);
		
	}
}
