package email_request;


/**
 * This class is responsible to response to button clicks on
 * bundle
 */
public class ProfileViewUIController{
    final ProfileViewUIInputBoundary userInput;

    public ProfileViewUIController(ProfileViewUIInputBoundary profileViewGateway) {
        this.userInput = profileViewGateway;
    }

    ConnViaEmailResponseModel create(String requesterEmail, String targetUserEmail){
        ConnViaEmailRequestModel connViaEmailRequestModel = new ConnViaEmailRequestModel(requesterEmail, targetUserEmail);
        return userInput.create(connViaEmailRequestModel);
    }

}
