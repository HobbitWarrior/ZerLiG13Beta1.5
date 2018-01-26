package BranchWorker;

import java.io.Serializable;
import java.time.Year;
/**
 * 
 * @author Sharon & elias
 *
 */
public class satisfactionSurvey  implements Serializable {


	int customerID;
	int step;
	int QarSurvey;
	String surveyYear;
	float  Q1  ;
	float Q2  ;
	float Q3  ; 
	float Q4   ; 
	float Q5   ; 
	float Q6   ;
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getQarSurvey() {
		return QarSurvey;
	}
	public void setQarSurvey(int qarSurvey) {
		QarSurvey = qarSurvey;
	}
	public String getSurveyYear() {
		return surveyYear;
	}
	public void setSurveyYear(String surveyYear) {
		this.surveyYear = surveyYear;
	}
	public float getQ1() {
		return Q1;
	}
	public void setQ1(float q1) {
		Q1 = q1;
	}
	public float getQ2() {
		return Q2;
	}
	public void setQ2(float q2) {
		Q2 = q2;
	}
	public float getQ3() {
		return Q3;
	}
	public void setQ3(float q3) {
		Q3 = q3;
	}
	public float getQ4() {
		return Q4;
	}
	public void setQ4(float q4) {
		Q4 = q4;
	}
	public float getQ5() {
		return Q5;
	}
	public void setQ5(float q5) {
		Q5 = q5;
	}
	public float getQ6() {
		return Q6;
	}
	public void setQ6(float q6) {
		Q6 = q6;
	}
	public satisfactionSurvey(int customerID, int step, int qarSurvey, String surveyYear, float q1, float q2, float q3, float q4,
			float q5, float q6) {
		super();
		this.customerID = customerID;
		this.step = step;
		QarSurvey = qarSurvey;
		this.surveyYear = surveyYear;
		Q1 = q1;
		Q2 = q2;
		Q3 = q3;
		Q4 = q4;
		Q5 = q5;
		Q6 = q6;
	}
	public satisfactionSurvey() {
		super();
	}
	@Override
	public String toString() {
		return "Survey [customerID=" + customerID + ", step=" + step + ", QarSurvey=" + QarSurvey + ", surveyYear="
				+ surveyYear + ", Q1=" + Q1 + ", Q2=" + Q2 + ", Q3=" + Q3 + ", Q4=" + Q4 + ", Q5=" + Q5 + ", Q6=" + Q6
				+ "]";
	}
	
	 
	
	
	
	
	
 
}
