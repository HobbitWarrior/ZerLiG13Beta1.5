package BranchManager;

import java.io.Serializable;
import java.time.Year;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;

public class Reports implements Serializable   {

	
	Integer ReportType ;
	String ReportYear  ; 
	Integer ReportQuarter  ; 
	Image longblob;
	String BranchID  ;
	public Integer getReportType() {
		return ReportType;
	}
	public void setReportType(Integer reportType) {
		ReportType = reportType;
	}
	public String getReportYear() {
		return ReportYear;
	}
	public void setReportYear(String reportYear) {
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
	public Reports(Integer reportType, String reportYear, Integer reportQuarter, Image longblob, String branchID) {
		super();
		ReportType = reportType;
		ReportYear = reportYear;
		ReportQuarter = reportQuarter;
		this.longblob = longblob;
		BranchID = branchID;
	}
	@Override
	public String toString() {
		return "Reports [ReportType=" + ReportType + ", ReportYear=" + ReportYear + ", ReportQuarter=" + ReportQuarter
				+ ", longblob=" + longblob + ", BranchID=" + BranchID + "]";
	}
	
	
	 
	 
	
	
}
