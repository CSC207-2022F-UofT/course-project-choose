package login_management_system;

import data_access_storage.UserRepoManager;
import entities.User;

/**
 * This class is responsible to take the inputs/request from users, to fulfill the
 * login request and prepare output for users.
 * Layer: Use Case Layer
 */


public class LoginInteractor implements LoginInputBoundary {

    /** This is an instance of userRepoManager so that we can access UserRepo, our database*/
    final UserRepoManager userRepoManager;

    /** This is an instance of loginOutputBoundary so that we can pass out result, loginResponseModel, out*/
    final LoginOutputBoundary loginOutputBoundary;

    /**
     * Construct a MatcherUIInteractor object.
     * @param loginOutputBoundary a interface that allows LoginInteractor to call
     * LoginPrensenter without knowing its existence.
     * @param userRepoManager a data access interface.
     */

    public LoginInteractor(UserRepoManager userRepoManager, LoginOutputBoundary loginOutputBoundary) {
        this.userRepoManager = userRepoManager;
        this.loginOutputBoundary = loginOutputBoundary;
    }

    /**
     * Take the email and password from users and check whether the user exist in the database
     * and whether the input password matches the record in the database.
     * If so, return a data model containing the user, return error message otherwise.
     * @param requestModel a data model that combines user's input data.
     * @return a data model containing user's information if the login is successful,
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
        String email = requestModel.getName();
        LoginResponseModel responseModel = new LoginResponseModel(user, email);
        return loginOutputBoundary.prepareSuccessView(responseModel);
    }
}
