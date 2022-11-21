package email_request;


/**
 * This class handles the requested email address returned by MatcherUIInteractor,
 * and prepare the requested email address for viewing purpose.
 * Layer: Use Case Layer
 */
public class MatcherUIPresenter implements MatcherUIOutputBoundary {

    @Override
    /**
     * Prepare the returned requested email address for viewing
     * @param requestedEmail the requested email address
     * @return the requested email address that is prepared for viewing
     */
    public MatcherUIResponseModel prepareView(MatcherUIResponseModel requestedEmail) {
        return requestedEmail;
    }
}
