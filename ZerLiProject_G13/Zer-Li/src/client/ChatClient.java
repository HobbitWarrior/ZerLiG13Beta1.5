package client;

import ocsf.client.*;
import common.*;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.io.*;
import java.time.Year;
import java.util.ArrayList;

import BranchManager.BranchManager;
import BranchManager.BranchManagerMainWindow;
import BranchManager.DiscountingOnItemsControl;
import BranchManager.OwnReportBrowseControl;
import BranchManager.PaymentAccount;
import BranchManager.PercentMSG;
import BranchManager.Reports;
import BranchManager.SpecialBranchesMessage;
import BranchManager.catalogitemsofbranch;
import BranchWorker.Customer;
import BranchWorker.FillSurveyControl;
import BranchWorker.satisfactionSurvey;
import Catalog.CatalogItem;
import ChainManager.BranchReportBrowseControl;
import ChainWorker.CatalogEditControl;
import Customer.CancelOrderControl;
import Customer.CatalogItemGUI;
import Customer.CatalogOrderControl;
import Customer.CustomOrderControl;
import Customer.CustomerMainWindow;
import Customer.CustomerTransaction;
import Customer.Flower;
import Customer.MessgaeCatalogProduct;
import Customer.OrdersControl;
import Customer.TransactionAbort;
import CustomerServiceDepartmentworker.CustomerServiceDepartmentworkerMainWindow;
import CustomerServiceDepartmentworker.complaint;
import CustomerServiceDepartmentworker.complaintProgress;
import CustomerServiceDepartmentworker.complaintRow;
import Expert.SurveyAnalayzingControl;
import Users.LoginContol;
import Users.User;

public class ChatClient extends AbstractClient {
	// Instance variables **********************************************
	private LoginContol login;
	private CatalogOrderControl orderFromCatalog;
	private CatalogEditControl editCatalog; // ************************************************* i added
	private OrdersControl buyingProcess;
	private CustomerMainWindow mainCustomerWindow;
	private CancelOrderControl cancelWindow;
	private SurveyAnalayzingControl AnalayzingControl;
	private FillSurveyControl SurveyControl;
	private String chooseControl; // choose between CatalogEditControl and CatalogOrderControl //
									// ************************************** i added
	// Constructors ****************************************************

	public ChatClient(String host, int port) throws IOException {
		super(host, port); // Call the superclass constructor
	}

	// Instance methods ************************************************

	public void setLoginControl(LoginContol login) {
		this.login = login;
	}

	public void setCatalogOrderControl(CatalogOrderControl CatalogOrder) {
		this.orderFromCatalog = CatalogOrder;
	}

	public void setAnalayzingControl(SurveyAnalayzingControl AnalayzingControl) {
		this.AnalayzingControl = AnalayzingControl;
	}

	public void setSurveyControl(FillSurveyControl SurveyControl) {
		this.SurveyControl = SurveyControl;
	}

	public void setCatalogEditControl(CatalogEditControl CatalogEdit) // ********************* i added
	{
		this.editCatalog = CatalogEdit;
	}

	public void setchooseControl(String Control) // ********************************************* i added
	{
		this.chooseControl = Control;
	}

	public void handleMessageFromServer(Object msg) {
		if (msg instanceof Message) {
			Message ServerMsg;
			ServerMsg = (Message) msg;

			/* complaints list handler */
			if (ServerMsg.getMsgType().equals("ComplaintsList")) {
				// point the active complains that were retrieved from the server to the
				// arrayList in the
				// CustomerServiceDepartmentwokerMainWindow class
				CustomerServiceDepartmentworkerMainWindow.activeComplaints = (ArrayList<complaint>) ServerMsg
						.getMsgObject();
				for (complaint c : CustomerServiceDepartmentworkerMainWindow.activeComplaints) {
					System.out.print("complaint: " + c.getComplaintID() + " " + c.getCustomerID() + " "
							+ c.getDateComplaint() + " " + c.getEmpHandling() + " " + c.getStatus() + " "
							+ c.getTimeComplaint() + " " + c.getTopic() + "\n");// " "+c.getDetails()+
					CustomerServiceDepartmentworkerMainWindow.upgradedList.add(new complaintRow(
							"Customer:" + c.getCustomerID() + " Topic: " + c.getTopic() + "  ",
							CustomerServiceDepartmentworkerMainWindow.activeComplaints.indexOf(c), c.getTimeComplaint(),
							CustomerServiceDepartmentworkerMainWindow.mainStageReference));
				}
				quit();
				return;
			}

			if (ServerMsg.getMsgType().equals("User")) {
				ArrayList<User> AllUsersFromServer = (ArrayList<User>) ServerMsg.getMsgObject();
				for (int i = 0; i < AllUsersFromServer.size(); i++) {
					// System.out.println(""+AllUsersFromServer.get(i));
					LoginContol.AllUsers.add(AllUsersFromServer.get(i));
				}
				quit();
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						login.CheckUserExist();
					}

				});

				return;
			}

			// ************************************************************************
			if (ServerMsg.getMsgType().equals("Satisfaction Survey list")) {
				ArrayList<Float> AllSurveyResults = (ArrayList<Float>) ServerMsg.getMsgObject();
				for (int i = 0; i < AllSurveyResults.size(); i++) {
					// System.out.println(""+AllUsersFromServer.get(i));
					SurveyAnalayzingControl.SurveyResultList.add(AllSurveyResults.get(i));
				}
				quit();

				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						AnalayzingControl.setSurveyResultInfields();
					}

				});

				return;
			}
			// ************************************************************************
			if (ServerMsg.getMsgType().contains("Answer if step is 0")) {
				Boolean ansStepFromServer = (Boolean) ServerMsg.getMsgObject();
				SurveyControl.stepAns = ansStepFromServer;

				quit();
				/*
				 * Platform.runLater(new Runnable() {
				 * 
				 * @Override public void run() {
				 * 
				 * AnalayzingControl. }
				 * 
				 * });
				 */
				return;
			}

			// ************************************************************************
			if (ServerMsg.getMsgType().contains("Answer if step is 1")) {
				Boolean ansStepFromServer = (Boolean) ServerMsg.getMsgObject();
				SurveyAnalayzingControl.stepAns = ansStepFromServer;

				quit();
				/*
				 * Platform.runLater(new Runnable() {
				 * 
				 * @Override public void run() {
				 * 
				 * AnalayzingControl. }
				 * 
				 * });
				 */
				return;
			}

			// ************************************************************************
			if (ServerMsg.getMsgType().contains("Answer if Unique item ID: ")) {
				Boolean ans = (Boolean) ServerMsg.getMsgObject();
				CatalogEditControl.ansUniqueID = ans;

				String cutItemIDFromStringMessage = ServerMsg.getMsgType().substring(26,
						(ServerMsg.getMsgType().length()));
				int id = Integer.parseInt(cutItemIDFromStringMessage);
				// CatalogEditControl.currentID=id;
				quit();

				Platform.runLater(new Runnable() {

					@Override
					public void run() {

						editCatalog.checkUniqueIDResult(id);
					}

				});

				return;
			}

			if (ServerMsg.getMsgType().equals("CatalogItem")) {
				System.out.println("ServerMsg.getMsgType().equals catalogItem");

				ArrayList<CatalogItem> AllCatalogItems = (ArrayList<CatalogItem>) ServerMsg.getMsgObject();
				for (int i = 0; i < AllCatalogItems.size(); i++) // transfer from vector to observable list because
																	// only->*
				{
					// convert from ArrayList<CatalogItem> to ObservableList<CatalogItemGUI> in
					// order to load picture and button into the catalog table
					int itemID = AllCatalogItems.get(i).getItemID();
					String itemName = AllCatalogItems.get(i).getItemName();
					String itemType = AllCatalogItems.get(i).getItemType();
					String itemDescription = AllCatalogItems.get(i).getItemDescription();
					MyFile itemPhoto = AllCatalogItems.get(i).getItemPhoto();
					double Price = AllCatalogItems.get(i).getItemPrice();
					boolean sale = AllCatalogItems.get(i).isSale();

					if (chooseControl.equals("CatalogOrderControl")) // window of haim
					{

						CatalogItemGUI catalogProduct = new CatalogItemGUI(itemID, itemName, itemType, itemDescription,
								itemPhoto, Price, orderFromCatalog);
						Label price = new Label(catalogProduct.getItemPriceWithCoin());
						if (sale == true) {
							price.setTextFill(Color.web("#ff0000"));
							price.setFont(Font.font("Ariel", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 12));
						}
						catalogProduct.setPriceItemLabel(price);
						CatalogOrderControl.catalogList.add(catalogProduct); // ->* observablelist loaded into the table
					}

					if (chooseControl.equals("CatalogEditControl")) // window of sharon
					{

						CatalogItemGUI catalogProduct = new CatalogItemGUI(itemID, itemName, itemType, itemDescription,
								itemPhoto, Price, editCatalog);
						CatalogEditControl.catalogList.add(catalogProduct); // ->* observablelist loaded into the table
						quit(); // this quit is only here because CatalogOrderControl need to get branches
								// too!!!, if we put this quit after this if, CatalogOrderControl (of Haim) will
								// not get branches
					}

				}

				/*
				 * Platform.runLater(new Runnable() {
				 * 
				 * @Override public void run() { if(chooseControl.equals("CatalogOrderControl"))
				 * orderFromCatalog.loadAllCatalogItems(AllCatalogItems); //keep backup
				 * ArrayList into Catalog class if(chooseControl.equals("CatalogEditControl"))
				 * editCatalog.loadAllCatalogItems(AllCatalogItems); //keep backup ArrayList
				 * into Catalog class
				 * 
				 * }
				 * 
				 * 
				 * });
				 * 
				 */

				return;
			} else if (ServerMsg.getMsgType().equals("AllReports")) {

				System.out.println("**Back");

				ArrayList<Reports> AllReportsFromServer = (ArrayList<Reports>) ServerMsg.getMsgObject();
				for (int i = 0; i < AllReportsFromServer.size(); i++) {

					int ReportType = AllReportsFromServer.get(i).getReportType();
					String ReportYear = AllReportsFromServer.get(i).getReportYear();
					int ReportQuarter = AllReportsFromServer.get(i).getReportQuarter();
					String fileCsv = AllReportsFromServer.get(i).getCsvFILE();
					String BranchID = AllReportsFromServer.get(i).getBranchID();
					Reports replist = new Reports(ReportType, ReportYear, ReportQuarter, fileCsv, BranchID);
					BranchReportBrowseControl.ReportList.add(replist);
				}
				quit();

				return;

			} else if (ServerMsg.getMsgType().equals("AllBranchReport")) {

				System.out.println("-Back-");

				ArrayList<catalogitemsofbranch> catalogitemsofbranchFromServer = (ArrayList<catalogitemsofbranch>) ServerMsg
						.getMsgObject();

				for (int i = 0; i < catalogitemsofbranchFromServer.size(); i++) {

					int ItemID = catalogitemsofbranchFromServer.get(i).getItemID();
					String BranchID = catalogitemsofbranchFromServer.get(i).getBranchID();
					double Price = catalogitemsofbranchFromServer.get(i).getPrice();

					catalogitemsofbranch catalogitemslist = new catalogitemsofbranch(ItemID, BranchID, Price);

					System.out.println(catalogitemslist);

					DiscountingOnItemsControl.catalogitemsofbranchlist.add(catalogitemslist);
				}
				quit();

				return;

			} else if (ServerMsg.getMsgType().equals("AllBranchReportE")) {

				System.out.println("-Back-");

				ArrayList<Reports> AllReportsFromServer = (ArrayList<Reports>) ServerMsg.getMsgObject();

				for (int i = 0; i < AllReportsFromServer.size(); i++) {

					int ReportType = AllReportsFromServer.get(i).getReportType();
					String ReportYear = AllReportsFromServer.get(i).getReportYear();
					int ReportQuarter = AllReportsFromServer.get(i).getReportQuarter();
					String fileCsv = AllReportsFromServer.get(i).getCsvFILE();
					String BranchID = AllReportsFromServer.get(i).getBranchID();
					Reports replist = new Reports(ReportType, ReportYear, ReportQuarter, fileCsv, BranchID);
					BranchReportBrowseControl.ReportList.add(replist);
					System.out.println(replist);
					System.out.println("-=-&&" + replist);
					OwnReportBrowseControl.ReportList.add(replist);
				}
				quit();

				return;

			} else if (ServerMsg.getMsgType().equals("all Customer")) {

				ArrayList<Customer> allCustomerFromServer = (ArrayList<Customer>) ServerMsg.getMsgObject();

				for (int i = 0; i < allCustomerFromServer.size(); i++) {

					int id = allCustomerFromServer.get(i).getCustomerID();
					String name = allCustomerFromServer.get(i).getCustomerName();
					String lastname = allCustomerFromServer.get(i).getCustomerlastName();
					String adress = allCustomerFromServer.get(i).getAddress();
					String email = allCustomerFromServer.get(i).getEmail();
					int phonenum = allCustomerFromServer.get(i).getPhoneNumber();
					Customer mycutomer1 = new Customer(id, name, lastname, adress, email, phonenum);
					FillSurveyControl.customersList.add(mycutomer1);

				}

				System.out.println("" + FillSurveyControl.customersList);
				quit();

				return;

			} else if (ServerMsg.getMsgType().equals("AllBranchReport")) {

				System.out.println("-BBack-");

				ArrayList<Reports> AllReportsFromServer = (ArrayList<Reports>) ServerMsg.getMsgObject();

				for (int i = 0; i < AllReportsFromServer.size(); i++) {

					int ReportType = AllReportsFromServer.get(i).getReportType();
					String ReportYear = AllReportsFromServer.get(i).getReportYear();
					int ReportQuarter = AllReportsFromServer.get(i).getReportQuarter();
					String fileCsv = AllReportsFromServer.get(i).getCsvFILE();
					String BranchID = AllReportsFromServer.get(i).getBranchID();
					Reports replist = new Reports(ReportType, ReportYear, ReportQuarter, fileCsv, BranchID);
					BranchReportBrowseControl.ReportList.add(replist);
					System.out.println(replist);

					OwnReportBrowseControl.ReportList.add(replist);
					System.out.println("-=-&&" + replist);

				}
				quit();

				return;

			} else if (ServerMsg.getMsgType().equals("catalog items of branch")) {

				System.out.println("-Back-");

				ArrayList<catalogitemsofbranch> catalogitemsofbranchFromServer = (ArrayList<catalogitemsofbranch>) ServerMsg
						.getMsgObject();

				for (int i = 0; i < catalogitemsofbranchFromServer.size(); i++) {

					int ItemID = catalogitemsofbranchFromServer.get(i).getItemID();
					String BranchID = catalogitemsofbranchFromServer.get(i).getBranchID();
					double Price = catalogitemsofbranchFromServer.get(i).getPrice();

					catalogitemsofbranch catalogitemsofbranchlist = new catalogitemsofbranch(ItemID, BranchID, Price);

					System.out.println(catalogitemsofbranchlist);

					DiscountingOnItemsControl.catalogitemsofbranchlist.add(catalogitemsofbranchlist);
				}
				quit();
				System.out.println("check->" + DiscountingOnItemsControl.catalogitemsofbranchlist);

				return;

			}
			if (ServerMsg.getMsgType().equals("Branch")) {
				ArrayList<Branch> AllBranchesFromServer = (ArrayList<Branch>) ServerMsg.getMsgObject();
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						CustomerMainWindow.AllBranchesNames.clear();

						for (int i = 0; i < AllBranchesFromServer.size(); i++) {
							// System.out.println(""+AllUsersFromServer.get(i));
							CustomerMainWindow.AllBranchesNames.add("" + AllBranchesFromServer.get(i).getBranchName());
							CustomerMainWindow.AllBranches.add(AllBranchesFromServer.get(i));
							BranchManagerMainWindow.allBranches.add(AllBranchesFromServer.get(i));
							// System.out.println("ddd "+AllBranchesFromServer.get(i).getBranchName());
						}
					}

				});

				quit();

				return;
			}

			if (ServerMsg.getMsgType().equals("BranchManager")) {
				ArrayList<BranchManager> AllBranchManagersFromServer = (ArrayList<BranchManager>) ServerMsg
						.getMsgObject();
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						for (int i = 0; i < AllBranchManagersFromServer.size(); i++) {
							// System.out.println("bbb "+AllBranchManagersFromServer.get(i));
							BranchManagerMainWindow.allBrancheManagers.add(AllBranchManagersFromServer.get(i));
						}
					}

				});

				return;
			}

			if (ServerMsg.getMsgType().equals("Flower")) {
				System.out.println("Client got message from server about flowers!!!!!!!!!!");
				ArrayList<Flower> allFlowersFromServer = (ArrayList<Flower>) ServerMsg.getMsgObject();
				;
				for (int i = 0; i < allFlowersFromServer.size(); i++) {
					CustomOrderControl.allFlowers.add(allFlowersFromServer.get(i));
				}
				this.mainCustomerWindow.sendReuestToGetAllBranchesForCustomer();
				return;
			}

			if (ServerMsg.getMsgType().equals("CustomerTransaction")) // this condition is complicated, if you want to
																		// use it, speak with Haim first!! I can give
																		// you a chance to deliver your message, trust
																		// me!!
			{ // be careful with this method!! Elias , Alex Sharon, talk with me before you
				// touch it!!!!
				ArrayList<CustomerTransaction> allOrders = (ArrayList<CustomerTransaction>) ServerMsg.getMsgObject();
				for (int i = 0; i < allOrders.size(); i++) { // Basically , here you can put your condition, but be very
																// careful, talk to me before!!!!
					if (allOrders.get(i).getMsgToClient().equals("show this order on cancellation table")) {
						String dateToChange = "" + allOrders.get(i).getOrdersupplyDate();

						allOrders.get(i).setSupplyDateStr(dateToChange);
						allOrders.get(i).setSupplyTimeStr("" + allOrders.get(i).getOrdersupplyTime());
						CancelOrderControl.allCustomerOrder.add(allOrders.get(i));
						System.out.println("important test ----->" + "" + dateToChange);
					}

				}
				return; // do not put here a call to quit()!!! call it from your own
						// controllers!!!!!!!!!!
			}

		} // end of Message type

		if (msg instanceof CustomerTransaction) {

			CustomerTransaction yourOrder = (CustomerTransaction) msg;
			boolean isAccountApproved = yourOrder.isApproved();
			if (isAccountApproved == false) {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Payment account verefication failed");
						alert.setHeaderText("Your order not placed!");
						alert.setContentText(yourOrder.getMsgToClient());
						alert.showAndWait();
						return;
					}

				});

			}

			else {
				System.out.println("client got approval");
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Transcation approved");
						alert.setHeaderText("Your order been placed!");
						alert.setContentText(yourOrder.getMsgToClient());
						alert.showAndWait();
						buyingProcess.endBuyingProcess();
						return;
					}

				});
			}

		}

		if (msg instanceof SpecialBranchesMessage) {
			System.out.println(
					"client got special message of elias!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			SpecialBranchesMessage branchesAndManagers = (SpecialBranchesMessage) msg;
			// System.out.println(""+branchesAndManagers.getAllBranches());
			// System.out.println(""+branchesAndManagers.getAllBranchManagers());
			ArrayList<Branch> allTheBrnahcesDB = branchesAndManagers.getAllBranches();
			ArrayList<BranchManager> allTheBrnahcesManagersDB = branchesAndManagers.getAllBranchManagers();

			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < allTheBrnahcesDB.size(); i++) {
						BranchManagerMainWindow.allBranches.add(allTheBrnahcesDB.get(i));
					}

					for (int j = 0; j < allTheBrnahcesManagersDB.size(); j++) {
						BranchManagerMainWindow.allBrancheManagers.add(allTheBrnahcesManagersDB.get(j));
					}
				}

			});
			System.out.println("" + BranchManagerMainWindow.allBranches);
			System.out.println("" + BranchManagerMainWindow.allBrancheManagers);

			return;
		}

		if (msg instanceof TransactionAbort) {
			TransactionAbort orderCancellation = (TransactionAbort) msg;
			if (orderCancellation.isCommit() == false) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Cannot cancel your order");
				alert.setHeaderText("Server has problem with your request");
				alert.setContentText("Please check the subject with system manager");
				alert.showAndWait();
			} else {
				Platform.runLater(new Runnable() {

					@Override
					public void run() {
						cancelWindow.actionAfterPositiveAbort(orderCancellation);
					}
				});
			}
			return;
		}

	} // end of handle message from server

	public void sendRequestToGetAllUsers() {
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			sendToServer("Give Me All Users");
		} catch (IOException e) {
			System.out.println("Cannot connect to server to get all users");
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Cannot connect to server");
			alert.setHeaderText("Cannot connect to server");
			alert.setContentText("Please check with system manger if serev is open");

			alert.showAndWait();
		}

	}

	public void sendRequestToChangeEntry(String UserName) {
		System.out.println("server got request to change entry");

		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			String requestToChangeEntry = "Please change Entry of user: " + UserName;
			sendToServer(requestToChangeEntry);
		} catch (IOException e) {
			System.out.println("Cannot connect to server");

		}
		quit();
	}

	public void sendRequestToGetAllCatalogItems() {
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			System.out.println("Send Message to get all catalogItems");

			sendToServer("Give Me All CatalogItems");
		} catch (IOException e) {
			System.out.println("Cannot connect to server to get CatalogItems");

		}

	}

	public void sendRequestToDeleteItem(int itemID) {
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			String requestToDeleteItem = "Please delete item with ID: " + itemID;
			sendToServer(requestToDeleteItem);
		} catch (IOException e) {
			System.out.println("Cannot connect to server");
		}
		quit();
	}

	public void sendRequestToCheckUniqueID(int itemID) {
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			String requestToCheckUniqueID = "Please Check if Unique ID:  " + itemID;
			sendToServer(requestToCheckUniqueID);
		} catch (IOException e) {
			System.out.println("Cannot connect to server");
		}
	}

	// ****************************************check!!!!!! giboi
	/*
	 * public void sendRequestToAddItem(CatalogItem newItem) { try {
	 * this.openConnection(); }
	 * 
	 * catch (IOException e1) { System.out.println("Cannot open connection"); }
	 * 
	 * try { sendToServer(newItem); } catch (IOException e) {
	 * System.out.println("Cannot connect to server"); } quit(); }
	 */

	public void sendRequestToAddOrEditItem(CatalogItem newItem) {
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			sendToServer(newItem);
		} catch (IOException e) {
			System.out.println("Cannot connect to server");
		}
		quit();
	}

	// **************************************** end check

	public void sendRequestToGetSatisfactionSurveyResult() {
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			System.out.println("Send Message to get all Satisfaction Survey Results");

			sendToServer("Give Me All Satisfaction Survey Results");
		} catch (IOException e) {
			System.out.println("Cannot connect to server");
		}
	}

	public void sendRequestToCheckStep0() {
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			System.out.println("Send Message to get check if surveys results exist"); // step = 1 in DB
			String requestToCheckStep0 = "Please Check if step = 0";
			sendToServer(requestToCheckStep0);
		} catch (IOException e) {
			System.out.println("Cannot connect to server");
		}
	}

	public void sendRequestToCheckStep1() {
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			System.out.println("Send Message to get check if surveys results exist"); // step = 1 in DB
			String requestToCheckStep1 = "Please Check if step = 1";
			sendToServer(requestToCheckStep1);
		} catch (IOException e) {
			System.out.println("Cannot connect to server");
		}
	}

	public void sendRequestToGetAllReports(String msg) {
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			System.out.println("Send Message to get all Reports");

			sendToServer(msg);
		} catch (IOException e) {
			System.out.println("Cannot connect to server to get Reports");

		}

	}

	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
			System.out.println("Cannot close connection");
		}
	}

	public void sendRequestToSaveObjectOnDB(Object OB) {

		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			sendToServer(OB);
		} catch (IOException e) {
			System.out.println("Cannot connect to server to set Payment Account");

		}

	}

	/*
	 * (AZ) this method requests all the active complaints from the server
	 */
	public void sendRequestForComplaintsList() {
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			sendToServer("ComplaintsList");
		} catch (IOException e) {
			System.out.println("Error! could'nt retrive active complaints, Cannot connect to server.");
			e.printStackTrace();
		}
	}

	public void sendRequestToGetAllBranches() {
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			System.out.println("Send Message to get all Branches");

			sendToServer("Give Me All Branches");
		} catch (IOException e) {
			System.out.println("Cannot connect to server to get all Branches");

		}
	}

	public void sendRequestToGetAllBranchManagers() {
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			System.out.println("Send Message to get all BranchManagers");

			sendToServer("Give Me All Branches managers");
		} catch (IOException e) {
			System.out.println("Cannot connect to server to get Branches managers");

		}

	}

	public void sendRequestToGetAllCatalogItemsOfBranch(
			String chosenBranchID) { /** this method ask from server to get all catalog items of branch */
		MessgaeCatalogProduct getCatalog = new MessgaeCatalogProduct(chosenBranchID);

		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			System.out.println("Send Message to get all catalogItems");

			sendToServer(getCatalog);
		} catch (IOException e) {
			System.out.println("Cannot connect to server to get Branches managers");

		}
	}

	public void sendRequestToSaveCustomerOrder(CustomerTransaction newDeal) {
		newDeal.setMsgToServer("Save this order in db");
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			System.out.println("Send Message to get save order in db");

			sendToServer(newDeal);
		} catch (IOException e) {
			System.out.println("Cannot connect to server to save order");

		}
	}

	public void sendRequestToGetAllBranchManagersAndBranches(SpecialBranchesMessage branchMessage) {
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			System.out.println("Send Message to get all branches and branches managers and  in db");

			sendToServer(branchMessage);
		} catch (IOException e) {
			System.out.println("Cannot connect to server to save order");

		}
	}

	public void sendRequestToUpdatePrice(PercentMSG perMSG) {
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			System.out.println("Send Message to Update Price");

			sendToServer(perMSG);
		} catch (IOException e) {
			System.out.println("Cannot connect to server to Update Price");

		}

	}

	public void setOrderControlOfBuyningProcess(OrdersControl ordersControl) {
		this.buyingProcess = ordersControl;
	}

	public void sendRequestToGetAllFlowers() {
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			System.out.println("Send Message to get all flowers from server");
			Flower tempFlower = new Flower();
			sendToServer(tempFlower);
		} catch (IOException e) {
			System.out.println("Cannot connect to server to get all flowers");

		}
	}

	/**
	 * the following method will request from the server to send all the current
	 * active complaints from the DB
	 * 
	 * @param customerMainWindow
	 */

	public void setMainCustomerControler(CustomerMainWindow customerMainWindow) {
		this.mainCustomerWindow = customerMainWindow;
	}

	public void sendRequestToGetAllCustomerOrder(int userID, String chosenBranchID, String chosenBranchName) {
		CustomerTransaction myOrder = new CustomerTransaction();
		myOrder.setCustomerID(userID);
		myOrder.setBranchName(chosenBranchName);
		myOrder.setOrderbranchID(chosenBranchID);
		myOrder.setMsgToServer("Give me all customer active orders");
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			System.out.println("Send Message to get all flowers from server");
			sendToServer(myOrder);
		} catch (IOException e) {
			System.out.println("Cannot connect to server to get all customer order");

		}
	}

	public void sendRequestToGetAllCustomer() {
		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}

		try {
			System.out.println("Send Message to get all Customers from server");
			Customer myCustomer = new Customer();
			sendToServer(myCustomer);
		} catch (IOException e) {
			System.out.println("Cannot connect to server to get all Customers");

		}
	}

	public void setCancelControl(CancelOrderControl cancelOrderControl) {
		this.cancelWindow = cancelOrderControl;
	}

	public void sendRequestToCancelOrder(TransactionAbort cancelOrder) {

		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}
		try {
			System.out.println("Send Message to cancel order of customer");
			sendToServer(cancelOrder);
		} catch (IOException e) {
			System.out.println("Cannot connect to server to get cancel customer order");

		}
	}

	public void AddNewReportToDB(Reports newReport) {

		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}
		try {
			System.out.println("Send Message to add report");
			sendToServer(newReport);
		} catch (IOException e) {
			System.out.println("Cannot connect to server to get add report");

		}

	}

	// ---- Send Request to Server To Save Survey Result
	public void sendRequestToSaveSurveyResult(satisfactionSurvey surveyAVG) {

		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}
		try {
			System.out.println("Send Message to add satisfaction Survey");
			sendToServer(surveyAVG);
		} catch (IOException e) {
			System.out.println("Cannot connect to server to get add satisfaction Survey");

		}

	}

	public void sendRequestUpdateComplaint(complaint c) {
		/***
		 * <h1>send a request to update a complaint</h1>
		 * <p>
		 * sends a request to the server to update a complaint entry
		 * 
		 * @author Alex
		 *         </p>
		 **/

		try {
			this.openConnection();
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}
		try {
			System.out.println("Asking the server to update a comlaint");
			sendToServer(c);
		} catch (IOException e) {
			System.out.println("Cannot connect to server in order to update a complaint entry");

		}

	}

	public void sendRequestForANewQuarterlySurvey() {
		/***
		 * <h1>send request for a new quarterly report</h1>
		 * <p>
		 * this method asks the survey to generate a new quarterly report no @param
		 * none @return none @author Alex
		 * </p>
		 ***/

		try {
			this.openConnection();
			
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}
		try {
			System.out.println("Asking the server to generate a new quarterly report");
			sendToServer("generateANewQuarterlyReport");
		} catch (IOException e) {
			System.out.println("Cannot connect to server in order to generate a new quarterly report");

		}

	}
	public void sendRequestSaveProgress(complaintProgress cp)
	{
		/***
		 * <h1>send request to add a new progress for a complaint</h1>
		 * <p>
		 * this method asks asks to add a new entry in the progress complaint table 
		 *  @return none  @param complaintProgress @author Alex
		 * </p>
		 ***/

		try {
			this.openConnection();
			
		}

		catch (IOException e1) {
			System.out.println("Cannot open connection");
		}
		try {
			System.out.println("Asking the server to generate a complaint Progress");
			sendToServer("AddNewComlaintProgress");
		} catch (IOException e) {
			System.out.println("Cannot connect to server in order to generate a new complaint Progress");

		}
	}

}