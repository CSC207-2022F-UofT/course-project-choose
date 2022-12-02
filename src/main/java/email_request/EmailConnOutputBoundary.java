package email_request;

/**
 * This class is the abstraction that allows EmailConnInteractor to pass
 * the requested email address to EmailConnPresenter without violating Dependency Rules
 * of clean architecture.
 * Layer: Use Case Layer
 */
public interface EmailConnOutputBoundary {

    /**
     * Prepare the returned requested email address for viewing
     * @param requestedEmail the requested email address
     * @return the requested email address that is prepared for viewing
     */
    EmailConnResponseModel prepareView(EmailConnResponseModel requestedEmail);
}
