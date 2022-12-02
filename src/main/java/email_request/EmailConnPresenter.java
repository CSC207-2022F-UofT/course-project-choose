package email_request;


/**
 * This class handles the requested email address returned by EmailConnInteractor,
 * and prepare the requested email address for viewing purpose.
 * Layer: Use Case Layer
 */
public class EmailConnPresenter implements EmailConnOutputBoundary {

    /**
     * Prepare the returned requested email address for viewing
     * @param requestedEmail the requested email address
     * @return the requested email address that is prepared for viewing
     */
    @Override
    public EmailConnResponseModel prepareView(EmailConnResponseModel requestedEmail) {
        return requestedEmail;
    }
}
