package data_access_storage;

import entities.UserAccount;

/**
 * This class represents our data saved to the database.
 */
public class RequestModel {
    /** user account */
    private UserAccount userAccount;

    /***
     * Create a Request Model with the given user account.
     * @param user the user account.
     */
    public RequestModel(UserAccount user){
        this.userAccount = user;
    }

    /**
     * Get the user account
     * @return the user account
     */
    public UserAccount getUserAccount(){
        return this.userAccount;
    }

}
