package userreg;

import entities.Gender;
import entities.Hobbies;
import entities.User;
import entities.UserAccount;

public class UserRegUIController {
    /**
     * This class is responsible to response to button clicks on
     * submit results and check the request data.
     * Layer: Interface Adapters
     */
    UserRegUIInputBoundary userRegInput;


    public UserRegUIController(UserRegUIInputBoundary userRegInput){

        this.userRegInput=userRegInput;
    }

    /**
     * Create a controller that responses to button clicks on submit and check the request data.
     * The abstraction layer between UserRegUIController and UserRegUIInteractor
     */
    public UserRegUIResponseModel  userProfileCreate(String eMail_v,String password_v,String name_v, Gender gender, int age_v, float height_v, String programOfStudy_v,
                                                     Hobbies hobby_v, String selfIntro_v, Gender interestedIn_v){
        User user=new User( name_v, gender,  age_v,
         height_v,  programOfStudy_v,
                 hobby_v,  selfIntro_v,  interestedIn_v);
        UserAccount ua=new UserAccount(eMail_v,password_v,user);
        UserRegUIRequestModel userRegUIRequestModel=new UserRegUIRequestModel(ua);
        return userRegInput.create(userRegUIRequestModel);

    }
}
