package user_register_system;
/**
 * This class handles the function of comparing two email addresses returned by UserRegUIInteractor,
 * and prepare the progress of register for viewing purpose.
 * Layer: Use Case Layer
 */
public class UserRegUIPresenter implements UserRegUIOutputBoundary{

    /**
     * Prepare the returned requested email address for viewing
     * @param regMessage the register email address
     * @return the register message (succeed / error message).
     */
    @Override
    public UserRegUIResponseModel prepareView(UserRegUIResponseModel regMessage) {
        return regMessage;
    }
}
