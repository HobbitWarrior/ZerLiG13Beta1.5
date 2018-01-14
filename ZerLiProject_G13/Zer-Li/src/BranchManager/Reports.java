package BranchManager;

import java.io.Serializable;
import java.time.Year;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;

public class Reports implements Serializable   {

	
	Integer ReportType ;
	Year ReportYear  ; 
	Integer ReportQuarter  ; 
	Image longblob;
	String BranchID  ;
	//String ReportYearStr  ;

	public Integer getReportType() {
		return ReportType;
	}
	public void setReportType(Integer reportType) {
		ReportType = reportType;
	}
	public Year getReportYear() {
		return ReportYear;
	}
	public void setReportYear(Year reportYear) {
		ReportYear = reportYear;
	}
	public Integer getReportQuarter() {
		return ReportQuarter;
	}
	public void setReportQuarter(Integer reportQuarter) {
		ReportQuarter = reportQuarter;
	}
	public Image getLongblob() {
		return longblob;
	}
	public void setLongblob(Image longblob) {
		this.longblob = longblob;
	}
	public String getBranchID() {
		return BranchID;
	}
	public void setBranchID(String branchID) {
		BranchID = branchID;
	}
	
	/*public String getReportYearStr()
	{
		return this.ReportYearStr;
	}
	
	public void setReportYearStr(String ReportYearStr)
	{
		 this.ReportYearStr=ReportYearStr;
	}*/
	
	
	
	@Override
	public String toString() {
		return "Reports [ReportType=" + ReportType + ", ReportYear=" + ReportYear + ", ReportQuarter=" + ReportQuarter
				+ ", longblob=" + longblob + ", BranchID=" + BranchID + "]";
	}
	
	
	
	
	public Reports(Integer reportType, Year reportYear, Integer reportQuarter, Image longblob, String branchID) {
		super();
		ReportType = reportType;
		ReportYear = reportYear;
		//ReportYearStr=""+ReportYear;
		ReportQuarter = reportQuarter;
		this.longblob = longblob;
		BranchID = branchID;
	}
	public Reports() {
		ReportType = 100;
		ReportYear = null;
		ReportQuarter = 120;
		this.longblob = null;
		BranchID = "s10";
		//ReportYearStr=""+ReportYear;
		
	}
	 
	
	
}
