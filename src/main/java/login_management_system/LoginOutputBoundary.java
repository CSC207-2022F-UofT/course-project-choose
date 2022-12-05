package login_management_system;

/**
 * This class is the abstraction that allows LoginInteractor to pass to LoginPresenter
 * Layer: Use Case Layer
 */
public interface LoginOutputBoundary {

    /**
     * Prepare the successful login status for viewing
     * @param loginResponseModel a data model that contains the user and successful login result
     */
    LoginResponseModel prepareSuccessView(LoginResponseModel loginResponseModel);

    /**
     * Prepare the failed login status for viewing
     * @param error failed login result
     */
    LoginResponseModel prepareFailView(String error);

}
