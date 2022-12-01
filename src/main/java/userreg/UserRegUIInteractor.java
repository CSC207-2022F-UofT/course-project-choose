package userreg;

import data_access_storage.RequestModel;
import data_access_storage.UserRepoManager;
import entities.UofTStudentEmailVerifier;
import entities.UserAccount;
/**
 * This class is responsible to take the inputs/request from users, interact with
 * entities to fulfill the request and prepare output for users.
 * Layer: Use Case
 */
public class UserRegUIInteractor implements UserRegUIInputBoundary{

    final UserRegUIOutputBoundary userRegUIOutputBoundary;
    final UserRepoManager userRepoManager;
    /**
     * Construct a MatcherUIInteractor object.
     * @param userRegUIOutputBoundary an interface that allows UserRegUIInteractor to call
     *                                UserRegUIPrenseter without knowing its existence.
     * @param userRepoManager a data access interface
     */
    public UserRegUIInteractor(UserRegUIOutputBoundary userRegUIOutputBoundary, UserRepoManager userRepoManager){
        this.userRegUIOutputBoundary=userRegUIOutputBoundary;
        this.userRepoManager=userRepoManager;
    }

    /**
     * Take the data input from users and decide whether
     * the register is success or not.
     * Return the data showing whether register is success or not.
     * @param requestModel a data model for the User Register
     * @return a data model for showing whether register is succeed or not.
     */

    @Override
    public UserRegUIResponseModel create(UserRegUIRequestModel requestModel) {
        UserRegUIResponseModel userRegUIResponseModel=null;
        UserAccount ua=requestModel.userAccout;
        String email=ua.getEmail();

        UofTStudentEmailVerifier ev=new UofTStudentEmailVerifier();
        // Case register fail, reason: email invalid
        if (!ev.verify(email)){
            userRegUIResponseModel=new UserRegUIResponseModel("ERR001");
            return this.userRegUIOutputBoundary.prepareView(userRegUIResponseModel);
        }
        // Case register fail, reason: email existed
        if (this.userRepoManager.existsByEmail(email)){
            userRegUIResponseModel=new UserRegUIResponseModel("ERR002");
            return this.userRegUIOutputBoundary.prepareView(userRegUIResponseModel);
        }
        RequestModel rm=new RequestModel(ua);

        this.userRepoManager.save(rm);
        // Case register success
        userRegUIResponseModel=new UserRegUIResponseModel("SUCCESS");


        return this.userRegUIOutputBoundary.prepareView(userRegUIResponseModel);
    }
}
