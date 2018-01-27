package CustomerServiceDepartmentworker;

import java.io.Serializable;

public class expertReport implements Serializable  {
	
	
	public expertReport(int ExpertId,int Quarter,int Year,String Report)
	{
		setExpertID(ExpertId);
		setQuarter(Quarter);
		setYear(Year);
		setReport(Report);
	}
	
	private int expertID;
	private int quarter;
	private int year;
	private String report;
	public int getExpertID() {
		return expertID;
	}
	public void setExpertID(int expertID) {
		this.expertID = expertID;
	}
	public int getQuarter() {
		return quarter;
	}
	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	

}
