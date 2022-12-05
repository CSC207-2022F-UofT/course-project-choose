package login_management_system;

/**
 * This class is responsible to response to button clicks on
 * login and bundle the request data.
 * Layer: Interface Adapters
 */
public class LoginController {
    final LoginInputBoundary userInput;

    /**
     * Create a controller that responses to button clicks on login request and bundle the request data.
     * @param userInput The abstraction layer between LoginController and LoginInteractor.
     */
    public LoginController(LoginInputBoundary userInput) {
        this.userInput = userInput;
    }

    /**
     * Check whether the user's email address exist in Database and whether user's input password matches the
     * password on record.
     * If so, return a data model containing the user, return error message otherwise.
     * @param email user's input username.
     * @param password user's input password.
     * @return a data model containing user if the user logins successfully,
     * and display error message otherwise.
     */

    LoginResponseModel checkValidLogin(String email, String password) {
        LoginRequestModel requestModel = new LoginRequestModel(email, password);
        return userInput.checkValidLogin(requestModel);
    }
}
