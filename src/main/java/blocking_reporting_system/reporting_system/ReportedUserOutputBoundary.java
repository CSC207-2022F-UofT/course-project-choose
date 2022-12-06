package blocking_reporting_system.reporting_system;

/**
 * This class is the abstraction that allows MatcherUIInteractor to pass
 * the requested email address to MatcherUIPresenter without violating Dependency Rules
 * of clean architecture.
 * Layer: Use Case Layer
 */
public interface ReportedUserOutputBoundary {

    /**
     * Prepare the returned requested email address for viewing
     * @param blockedStatus the requested email address
     * @return the requested email address that is prepared for viewing
     */
    ReportedUserResponseModel prepareView(ReportedUserResponseModel blockedStatus);
}
