package reporting_system;

import data_access_storage.RequestModel;
import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import entities.UserAccount;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BlockedUser {
    /**
     *
     * @param email this is masterEmail
     * @param blockedEmail this is blockEmail
     */
    public  boolean blockedUser(String email,String blockedEmail){
        boolean flag = false;
        UserRepoManager users;
        RequestModel requestModel;
        try {
            File csvFile = new File("src/main/resources/blockeduserTest.csv");
            users = new UserRepo(csvFile);//
            BlockedUserOutputBoundary presenter = new BlockedUserPresenter();
            BlockedUserInputBoundary interactor = new BlockedUserInteractor(presenter, users);
            BlockedUserController matcherUIController = new BlockedUserController(interactor);
            BlockedUserResponseModel burm=matcherUIController.updateBlocked(email,blockedEmail);
            flag=burm.getBlockedStatus();
        }catch (Exception e){

        }
        if(flag){
            JOptionPane.showMessageDialog(null, "block success!");
        }else{
            JOptionPane.showMessageDialog(null, "block fail!");

        }
        return flag;
    }

    public static void main(String[] args) {
        BlockedUser bu=new BlockedUser();
        bu.blockedUser("j@mail.utoronto.ca","i@hotmail.com");
    }


}
