package BranchWorker;

import java.io.Serializable;

public class Survey   implements Serializable 
{
	private boolean ansStep;
	private int QarSurvey;
	private String surveyYear;
	 
	 public Survey()
	 {

	 }
	
	 public Survey(boolean ansStep, int QarSurvey,String surveyYear)
	 {
			super();
			this.ansStep = ansStep;
			this.QarSurvey = QarSurvey;
			this.surveyYear = surveyYear;
	 }
	 
		public boolean getansStep() {
			return ansStep;
		}
		public void setansStep(boolean ansStep) {
			this.ansStep = ansStep;
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
		
		@Override
		public String toString() {
			return "Survey [stepis0=" + ansStep + ", QarSurvey=" + QarSurvey + ", surveyYear=" + surveyYear + "]";
		}
}
