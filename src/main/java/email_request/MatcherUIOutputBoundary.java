package email_request;

/**
 * This class is the abstraction that allows MatcherUIInteractor to pass
 * the requested email address to MatcherUIPresenter without violating Dependency Rules
 * of clean architecture.
 * Layer: Use Case Layer
 */
public interface MatcherUIOutputBoundary {

    /**
     * Prepare the returned requested email address for viewing
     * @param requestedEmail the requested email address
     * @return the requested email address that is prepared for viewing
     */
    MatcherUIResponseModel prepareView(MatcherUIResponseModel requestedEmail);
}
