package email_request;
/**
 * This class is Output Data. Presenter will use it to prepare View.
 * Use Case Layer
 */
public class EmailConnResponseModel {

 /** the resulted email address that a user requested */
 private final String requestedEmailAddress;

 /**
  * Create Output Data with the resulted email address that a user requested.
  * @param email the resulted email address that a user requested
  */
 public EmailConnResponseModel(String email){
  this.requestedEmailAddress = email;
 }

 /**
  * Get the resulted email address that a user requested.
  * If the result is "", the email request is unsuccessful.
  * @return the resulted email address that a user requested.
  */
 public String getRequestedEmailAddress() {
  return this.requestedEmailAddress;
 }
}
