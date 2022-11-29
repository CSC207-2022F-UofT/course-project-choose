package userReg;

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
     * @param ua The abstraction layer between UserRegUIController and UserRegUIInteractor
     */
    public UserRegUIResponseModel  userProfileCreate(UserAccount ua){

        UserRegUIRequestModel userRegUIRequestModel=new UserRegUIRequestModel(ua,"");
        return userRegInput.create(userRegUIRequestModel);




    }
}
