package BranchManager;

import java.io.Serializable;

public class PaymentAccount  implements Serializable {
	 
	String UserName          ;
	int  CustomerID        ;
	  String  Password          ;
	  String  PaymentType      ;
	  String  CreditCardNum     ;
	  String  CreditCardExpDate  ;
	  int CvvCreditCardNum  ; 
	  String CreditCardType     ;
	  String SubscriptionType  ;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPaymentType() {
		return PaymentType;
	}
	public void setPaymentType(String paymentType) {
		PaymentType = paymentType;
	}
	public String getCreditCardNum() {
		return CreditCardNum;
	}
	public void setCreditCardNum(String creditCardNum) {
		CreditCardNum = creditCardNum;
	}
	public String getCreditCardExpDate() {
		return CreditCardExpDate;
	}
	public void setCreditCardExpDate(String creditCardExpDate) {
		CreditCardExpDate = creditCardExpDate;
	}
	public int getCvvCreditCardNum() {
		return CvvCreditCardNum;
	}
	public void setCvvCreditCardNum(int cvvCreditCardNum) {
		CvvCreditCardNum = cvvCreditCardNum;
	}
	public String getCreditCardType() {
		return CreditCardType;
	}
	public void setCreditCardType(String creditCardType) {
		CreditCardType = creditCardType;
	}
	public String getSubscriptionType() {
		return SubscriptionType;
	}
	public void setSubscriptionType(String subscriptionType) {
		SubscriptionType = subscriptionType;
	}
	public PaymentAccount(String userName, int customerID, String password, String paymentType, String creditCardNum,
			String creditCardExpDate, int cvvCreditCardNum, String creditCardType, String subscriptionType) {
		super();
		UserName = userName;
		CustomerID = customerID;
		Password = password;
		PaymentType = paymentType;
		CreditCardNum = creditCardNum;
		CreditCardExpDate = creditCardExpDate;
		CvvCreditCardNum = cvvCreditCardNum;
		CreditCardType = creditCardType;
		SubscriptionType = subscriptionType;
	}
	public PaymentAccount() {
		UserName = null;
		CustomerID = 0;
		Password = null;
		PaymentType = null;
		CreditCardNum = null;
		CreditCardExpDate = null;
		CvvCreditCardNum = 0;
		CreditCardType = null;
		SubscriptionType = null;
	}
	@Override
	public String toString() {
		return "PaymentAccount [UserName=" + UserName + ", CustomerID=" + CustomerID + ", Password=" + Password
				+ ", PaymentType=" + PaymentType + ", CreditCardNum=" + CreditCardNum + ", CreditCardExpDate="
				+ CreditCardExpDate + ", CvvCreditCardNum=" + CvvCreditCardNum + ", CreditCardType=" + CreditCardType
				+ ", SubscriptionType=" + SubscriptionType + "]";
	} 
	  
}
