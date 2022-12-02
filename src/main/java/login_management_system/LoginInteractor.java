package login_management_system;


import data_access_storage.UserRepoManager;
import entities.User;

public class LoginInteractor implements LoginInputBoundary {

    final UserRepoManager userRepoManager;
    final LoginOutputBoundary loginOutputBoundary;

    /**
     * Construct a MatcherUIInteractor object.
     * @param loginOutputBoundary a interface that allows LoginInteractor to call
     *                                LoginPrensenter without knowing its existence.
     * @param userRepoManager a data access interface
     */

    public LoginInteractor(UserRepoManager userRepoManager, LoginOutputBoundary loginOutputBoundary) {
        this.userRepoManager = userRepoManager;
        this.loginOutputBoundary = loginOutputBoundary;
    }

    /**
     * Take the email and password from users and check whether the user exist in the database
     * and whether the input password matches the record in the database.
     * If so, return successful login message and direct the user to HomePageUI, and return error message otherwise.
     * @param requestModel a data model that combines user's input data.
     * @return a data model for showing the successful login message and direct the user to HomePageUI,
     * and display error message otherwise.
     */

    @Override
    public LoginResponseModel checkValidLogin(LoginRequestModel requestModel){
        // get information from database in order to determine whether the user exists.
        if (!userRepoManager.existsByEmail(requestModel.getName())){
            return loginOutputBoundary.prepareFailView("You have entered an invalid username.");
        }
        // get information from database to determine if the password in record matches user's input.
        else if (!userRepoManager.matchingPassword(requestModel.getName(), requestModel.getPassword())) {
            return loginOutputBoundary.prepareFailView("You have entered an invalid password.");
        }
        // else, the username exist and the input password matches its result.
        User user = userRepoManager.getUserAccount(requestModel.getName()).getUserAccount().getUser();
        LoginResponseModel responseModel = new LoginResponseModel(user);
        return loginOutputBoundary.prepareSuccessView(responseModel);
    }
}
