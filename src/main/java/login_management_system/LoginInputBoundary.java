package login_management_system;


/**
 * Layer: Use Case Layer
 */
public interface LoginInputBoundary {

    /**
     * Take the email and password from users and check whether
     * the user exist and whether the input password matches the record.
     * If so, return successful login message and direct the user to HomePageUI, and return error message otherwise.
     * @param requestModel a data model that combines user's input data.
     * @return a data model for showing the successful login message and direct the user to HomePageUI,
     * or display error message otherwise.
     */
    LoginResponseModel checkValidLogin(LoginRequestModel requestModel);
}
