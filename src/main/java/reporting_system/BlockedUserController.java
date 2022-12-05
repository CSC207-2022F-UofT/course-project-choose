package reporting_system;

/**
 * This class is responsible to response to button clicks on
 * matching results and bundle the request data.
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
     * Check whether the user whose email address is requesterEmail can request the email address targetUserEmail.
     * If so, return the requested email address (targetUserEmail), and empty string otherwise.
     * @param mail  the email address of the user who requests to see the email address (targetUserEmail).
     * @param blockedEmail the email address of the user whose email address is requested.
     * @return a data model for showing the requested email or empty string.
     */
    BlockedUserResponseModel updateBlocked(String mail, String blockedEmail){
        BlockedUserRequestModel blockedUserRequestModel = new BlockedUserRequestModel(mail, blockedEmail);
        return blockedUserInput.updateBlocked(blockedUserRequestModel);
    }

}
