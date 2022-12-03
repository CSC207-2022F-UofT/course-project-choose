package login_management_system;


/**
 * This class handles the Login Status returned by LoginManager,
 * and prepare the Login Status for viewing purpose.
 * Layer: Use Case Layer
 */

public class LoginPresenter implements LoginOutputBoundary {
    @Override
    public LoginResponseModel prepareSuccessView(LoginResponseModel responseModel) {
        responseModel.setLoginStatus();
        return responseModel;
    }

    @Override
    public LoginResponseModel prepareFailView(String error) {
        throw new LoginFailedException(error);
    }

}

