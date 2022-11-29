package userReg;

import entities.UserAccount;
/**
 * This class contains raw data that UserRegUIInterator needs to do its job.
 * It's created, passed in, unpacked by the interactor and discarded.
 * Layer: Use Case Layer
 */
public class UserRegUIRequestModel {

    UserAccount userAccout; // the information of register

    String returnMsg;

    public UserRegUIRequestModel(UserAccount userAccount,String returnMsg){
        this.userAccout=userAccount;
        this.returnMsg=returnMsg;

    }


}
