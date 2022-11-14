package email_request;
// output data
// use case layer
public class ConnViaEmailResponseModel {

 private String requestedEmailAddress;

 public ConnViaEmailResponseModel(String email){
  this.requestedEmailAddress = email;
 }

 public String getRequestedEmailAddress() {
  return this.requestedEmailAddress;
 }
}
