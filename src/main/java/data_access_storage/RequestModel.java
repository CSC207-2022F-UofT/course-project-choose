package data_access_storage;

import entities.UserAccount;

public class RequestModel {

    private UserAccount userAccount;

    public RequestModel(UserAccount user){
        this.userAccount = user;
    }

    public UserAccount getUserAccount(){
        return this.userAccount;
    }

}
