package blocking_reporting_system.blocking_system;

/**
 * This class is the abstraction that allows MatcherUIInteractor to pass
 * the requested email address to MatcherUIPresenter without violating Dependency Rules
 * of clean architecture.
 * Layer: Use Case Layer
 */
public interface BlockedUserOutputBoundary {

    /**
     * Prepare the returned requested email address for viewing
     * @param blockedStatus the requested email address
     * @return the requested email address that is prepared for viewing
     */
    BlockedUserResponseModel prepareView(BlockedUserResponseModel blockedStatus);
}
