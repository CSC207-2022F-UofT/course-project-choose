package login_management_system;


/**
 * This class handles the Login Status returned by LoginManager,
 * and prepare the Login Status for viewing purpose.
 * Layer: Use Case Layer
 */

public class LoginPresenter implements LoginOutputBoundary {

    /**
     * Prepare the successful login status for viewing
     * @param responseModel successful login result.
     * @return a data model that include user's information.
     */
    @Override
    public LoginResponseModel prepareSuccessView(LoginResponseModel responseModel) {
        responseModel.setLoginStatus();
        return responseModel;
    }

    /**
     * Prepare the failed login status for viewing
     * @param error the error message that displays when login failed.
     * @return a login failed exception
     */
    @Override
    public LoginResponseModel prepareFailView(String error) {
        throw new LoginFailedException(error);
    }

}

