package blocking_reporting_system.blocking_system;


/**
 * This class handles the requested email address returned by MatcherUIInteractor,
 * and prepare the requested email address for viewing purpose.
 * Layer: Use Case Layer
 */
public class BlockedUserPresenter implements BlockedUserOutputBoundary {

    /**
     * Prepare the returned requested email address for viewing
     * @param blockStatus the requested email address
     * @return the requested email address that is prepared for viewing
     */
    @Override
    public BlockedUserResponseModel prepareView(BlockedUserResponseModel blockStatus) {
        return blockStatus;
    }
}
