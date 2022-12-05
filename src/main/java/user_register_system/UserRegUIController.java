package user_register_system;

import entities.Gender;
import entities.Hobbies;

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

        UserRegUIRequestModel userRegUIRequestModel=new UserRegUIRequestModel(eMail_v,password_v,name_v,   age_v,
                height_v,  gender,hobby_v,programOfStudy_v,
                    selfIntro_v,interestedIn_v);
        return userRegInput.create(userRegUIRequestModel);

    }
}
