package reporting_system;
/**
 * This class is Output Data. Presenter will use it to prepare View.
 * Use Case Layer
 */
public class BlockedUserResponseModel {

 /** the resulted status that a user blocked */
 private Boolean blockedStatus;

 /**
  * Create Output Data with the resulted email address that a user requested.
  * @param blockedStatus the resulted email address that a user requested
  */
 public BlockedUserResponseModel(Boolean blockedStatus){
  this.blockedStatus = blockedStatus;
 }

 /**
  * Get the resulted email address that a user requested.
  * If the result is "", the email request is unsuccessful.
  * @return the resulted email address that a user requested.
  */
 public Boolean getBlockedStatus() {
  return this.blockedStatus;
 }
}
