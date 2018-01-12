package BranchWorker;

import java.io.Serializable;
import java.time.Year;

public class Survey  implements Serializable {

	
	Integer CustomerID ; 
	Integer SurviesQuarter ;
	Integer SurviesYear   ;
	Integer BranchWorkerID ;
	Integer Q1  ;
	Integer Q2  ;
	Integer Q3  ; 
	Integer Q4   ; 
	Integer Q5   ; 
	Integer Q6   ;
	public Survey(Integer customerID, Integer surviesQuarter, Integer surviesYear, Integer branchWorkerID, Integer q1,
			Integer q2, Integer q3, Integer q4, Integer q5, Integer q6) {
		super();
		CustomerID = customerID;
		SurviesQuarter = surviesQuarter;
		SurviesYear = surviesYear;
		BranchWorkerID = branchWorkerID;
		Q1 = q1;
		Q2 = q2;
		Q3 = q3;
		Q4 = q4;
		Q5 = q5;
		Q6 = q6;
	}
	public Survey() {
		// TODO Auto-generated constructor stub
	}
	public Integer getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(Integer customerID) {
		CustomerID = customerID;
	}
	public Integer getSurviesQuarter() {
		return SurviesQuarter;
	}
	public void setSurviesQuarter(Integer surviesQuarter) {
		SurviesQuarter = surviesQuarter;
	}
	public Integer getSurviesYear() {
		return SurviesYear;
	}
	public void setSurviesYear(Integer surviesYear) {
		SurviesYear = surviesYear;
	}
	public Integer getBranchWorkerID() {
		return BranchWorkerID;
	}
	public void setBranchWorkerID(Integer branchWorkerID) {
		BranchWorkerID = branchWorkerID;
	}
	public Integer getQ1() {
		return Q1;
	}
	public void setQ1(Integer q1) {
		Q1 = q1;
	}
	public Integer getQ2() {
		return Q2;
	}
	public void setQ2(Integer q2) {
		Q2 = q2;
	}
	public Integer getQ3() {
		return Q3;
	}
	public void setQ3(Integer q3) {
		Q3 = q3;
	}
	public Integer getQ4() {
		return Q4;
	}
	public void setQ4(Integer q4) {
		Q4 = q4;
	}
	public Integer getQ5() {
		return Q5;
	}
	public void setQ5(Integer q5) {
		Q5 = q5;
	}
	public Integer getQ6() {
		return Q6;
	}
	public void setQ6(Integer q6) {
		Q6 = q6;
	}
	@Override
	public String toString() {
		return "Survey [CustomerID=" + CustomerID + ", SurviesQuarter=" + SurviesQuarter + ", SurviesYear="
				+ SurviesYear + ", BranchWorkerID=" + BranchWorkerID + ", Q1=" + Q1 + ", Q2=" + Q2 + ", Q3=" + Q3
				+ ", Q4=" + Q4 + ", Q5=" + Q5 + ", Q6=" + Q6 + "]";
	}
	 
	 
}
