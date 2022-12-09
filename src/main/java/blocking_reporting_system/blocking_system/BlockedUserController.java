package blocking_reporting_system.blocking_system;

/**
 * This class is responsible to response to button clicks on
 * reporting results and bundle the request data.
 * Layer: Interface Adapters
 */
public class BlockedUserController {

    final BlockedUserInputBoundary blockedUserInput;

    /**
     * Create a controller that responses to button clicks on matching results and bundle the request data.
     * @param blockUserInputBoundary The abstraction layer between BlockUserController and BlockUserInteractor
     */
    public BlockedUserController(BlockedUserInputBoundary blockUserInputBoundary) {
        this.blockedUserInput = blockUserInputBoundary;
    }

    /**
     * @param mail  the email address of the user who requests to see the email address (targetUserEmail).
     * @param blockedEmail the email address of the user whose email address is requested.
     * @return a data model for showing the requested email or empty string.
     */
    public BlockedUserResponseModel updateBlocked(String mail, String blockedEmail){
        BlockedUserRequestModel blockedUserRequestModel = new BlockedUserRequestModel(mail, blockedEmail);
        return blockedUserInput.updateBlocked(blockedUserRequestModel);
    }

}
