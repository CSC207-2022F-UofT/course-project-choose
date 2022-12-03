package email_request;

/**
 * This class is responsible to response to button clicks on
 * matching results and bundle the request data.
 * Layer: Interface Adapters
 */
public class EmailConnController {

    final EmailConnInputBoundary userInput;

    /**
     * Create a controller that responses to button clicks on matching results and bundle the request data.
     * @param emailConnInputBoundary The abstraction layer between EmailConnController and EmailConnInteractor
     */
    public EmailConnController(EmailConnInputBoundary emailConnInputBoundary) {
        this.userInput = emailConnInputBoundary;
    }

    /**
     * Check whether the user whose email address is requesterEmail can request the email address targetUserEmail.
     * If so, return the requested email address (targetUserEmail), and empty string otherwise.
     * @param requesterEmail  the email address of the user who requests to see the email address (targetUserEmail).
     * @param targetUserEmail the email address of the user whose email address is requested.
     * @return a data model for showing the requested email or empty string.
     */
    public EmailConnResponseModel create(String requesterEmail, String targetUserEmail){
        EmailConnRequestModel emailConnRequestModel = new EmailConnRequestModel(requesterEmail, targetUserEmail);
        return userInput.create(emailConnRequestModel);
    }

}
