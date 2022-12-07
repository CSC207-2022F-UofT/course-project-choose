package blocking_reporting_system.blocking_system;

/**
 * This class allows us to decouple BlockUsercontroller and MactherUIInteractor.
 * Layer: Use Case Layer
 */
public interface BlockedUserInputBoundary {

    /**
     * Take the email request from users and decide whether
     * the requesters can see the requested email address.
     * If so, return the requested email address, and empty string otherwise.
     * @param requestModel a data model for the email request
     * @return a data model for showing the requested email or empty string.
     */
    BlockedUserResponseModel updateBlocked(BlockedUserRequestModel requestModel);
}
