package reporting_system;


/**
 * This class handles the requested email address returned by MatcherUIInteractor,
 * and prepare the requested email address for viewing purpose.
 * Layer: Use Case Layer
 */
public class BlockedUserPresenter implements BlockedUserOutputBoundary {

    @Override
    /**
     * Prepare the returned requested email address for viewing
     * @param requestedEmail the requested email address
     * @return the requested email address that is prepared for viewing
     */
    public BlockedUserResponseModel prepareView(BlockedUserResponseModel blockStatus) {
        return blockStatus;
    }
}
