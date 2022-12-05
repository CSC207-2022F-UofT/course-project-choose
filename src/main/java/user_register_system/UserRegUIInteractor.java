package user_register_system;

import data_access_storage.RequestModel;
import data_access_storage.UserRepoManager;
import email_verifier_strategy_pattern.UofTStudentEmailVerifier;
import entities.User;
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
     *                                UserRegUIPresenter without knowing its existence.
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
        UserRegUIResponseModel userRegUIResponseModel;

        User user=new User(requestModel.getName(),requestModel.getGender(),requestModel.getAge(),requestModel.getHeight(),requestModel.getProgramOfStudy(),requestModel.getHobbies(),requestModel.getSelfIntro(),requestModel.getInterestedIn());

        UserAccount ua=new UserAccount(requestModel.getEmail(),requestModel.getPassword(),user);

        String email=requestModel.getEmail();

        UofTStudentEmailVerifier ev=new UofTStudentEmailVerifier();

        if (!ev.verify(email)){
            userRegUIResponseModel=new UserRegUIResponseModel("ERR001");
            return this.userRegUIOutputBoundary.prepareView(userRegUIResponseModel);
        }

        if (this.userRepoManager.existsByEmail(email)){
            userRegUIResponseModel=new UserRegUIResponseModel("ERR002");
            return this.userRegUIOutputBoundary.prepareView(userRegUIResponseModel);
        }
        RequestModel rm=new RequestModel(ua);

        this.userRepoManager.save(rm);

        userRegUIResponseModel=new UserRegUIResponseModel("SUCCESS");


        return this.userRegUIOutputBoundary.prepareView(userRegUIResponseModel);
    }
}
