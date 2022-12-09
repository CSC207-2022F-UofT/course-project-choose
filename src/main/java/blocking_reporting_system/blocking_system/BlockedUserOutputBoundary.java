package blocking_reporting_system.blocking_system;

/**
 * the requested block user without violating Dependency Rules
 * of clean architecture.
 * Layer: Use Case Layer
 */
public interface BlockedUserOutputBoundary {

    /**
     * @param blockedStatus the requested email address
     * @return the requested email address that is prepared for viewing
     */
    BlockedUserResponseModel prepareView(BlockedUserResponseModel blockedStatus);
}
