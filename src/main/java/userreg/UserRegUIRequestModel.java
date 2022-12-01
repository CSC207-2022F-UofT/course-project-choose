package userreg;

import entities.UserAccount;

public class UserRegUIRequestModel {
    /**
     * This class contains raw data that UserRegUIInterator needs to do its job.
     * It's created, passed in, unpacked by the interactor and discarded.
     * Layer: Use Case Layer
     */
    UserAccount userAccout; // the information of register(s)


    public UserRegUIRequestModel(UserAccount userAccount){
        this.userAccout=userAccount;
    }

    public UserAccount getUserAccout(){
        return this.userAccout;
    }

}
