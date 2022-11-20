package email_request;

/**
 * This class is responsible to response to button clicks on
 * matching results and bundle the request data.
 * Layer: Interface Adapters
 */
public class MatcherUIController {

    final MatcherUIInputBoundary userInput;

    /**
     * Create a controller that responses to button clicks on matching results and bundle the request data.
     * @param matcherUIInputBoundary The abstraction layer between MatcherUIController and MatcherUIInteractor
     */
    public MatcherUIController(MatcherUIInputBoundary matcherUIInputBoundary) {
        this.userInput = matcherUIInputBoundary;
    }

    /**
     * Check whether the user whose email address is requesterEmail can request the email address targetUserEmail.
     * If so, return the requested email address (targetUserEmail), and empty string otherwise.
     * @param requesterEmail  the email address of the user who requests to see the email address (targetUserEmail).
     * @param targetUserEmail the email address of the user whose email address is requested.
     * @return a data model for showing the requested email or empty string.
     */
    public MatcherUIResponseModel create(String requesterEmail, String targetUserEmail){
        MatcherUIRequestModel matcherUIRequestModel = new MatcherUIRequestModel(requesterEmail, targetUserEmail);
        return userInput.create(matcherUIRequestModel);
    }

}
