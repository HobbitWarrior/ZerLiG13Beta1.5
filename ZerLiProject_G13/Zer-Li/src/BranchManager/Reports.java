package BranchManager;

import java.io.Serializable;
import java.time.Year;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;

public class Reports implements Serializable   {

	
	Integer ReportType ;
	String ReportYear  ; 
	Integer ReportQuarter  ; 
	String  CsvFILE;
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
	public String getCsvFILE() {
		return CsvFILE;
	}
	public void setCsvFILE(String csvFILE) {
		CsvFILE = csvFILE;
	}
	public String getBranchID() {
		return BranchID;
	}
	public void setBranchID(String branchID) {
		BranchID = branchID;
	}
	@Override
	public String toString() {
		return "Reports [ReportType=" + ReportType + ", ReportYear=" + ReportYear + ", ReportQuarter=" + ReportQuarter
				+ ", CsvFILE=" + CsvFILE + ", BranchID=" + BranchID + "]";
	}
	public Reports(Integer reportType, String reportYear, Integer reportQuarter, String csvFILE, String branchID) {
		super();
		ReportType = reportType;
		ReportYear = reportYear;
		ReportQuarter = reportQuarter;
		CsvFILE = csvFILE;
		BranchID = branchID;
	}
	 
	 
	 
	
	
}
