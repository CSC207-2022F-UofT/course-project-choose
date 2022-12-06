package blocking_reporting_system.reporting_system;
/**
 * This class is Output Data. Presenter will use it to prepare View.
 * Use Case Layer
 */
public class ReportedUserResponseModel {

 /** the resulted status that a user reporteded */
 private Boolean reportedStatus;

 /**
  * Create Output Data with the resulted email address that a user requested.
  * @param reportedStatus the resulted email address that a user requested
  */
 public ReportedUserResponseModel(Boolean reportedStatus){
  this.reportedStatus = reportedStatus;
 }

 /**
  * Get the resulted email address that a user requested.
  * If the result is "", the email request is unsuccessful.
  * @return the resulted email address that a user requested.
  */
 public Boolean getReportedStatus() {
  return this.reportedStatus;
 }
}
