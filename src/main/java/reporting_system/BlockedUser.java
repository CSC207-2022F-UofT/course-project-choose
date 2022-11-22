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
        try{
            File csvFile = new File("src/main/resources/ConnViaEmail.csv");
            users = new UserRepo(csvFile);//
            Map<String, RequestModel> allUserAccount = users.getAllUserAccount();
            for (String s : allUserAccount.keySet()) {
                requestModel = allUserAccount.get(s);
                if(requestModel!=null && requestModel.getUserAccount()!=null){
                    UserAccount userAccount = requestModel.getUserAccount();
                    String email1 = userAccount.getEmail();
                    if(email1.equals(email)){
                        List<String> blockedAccounts = userAccount.getBlockedAccounts();
                        blockedAccounts.add(blockedEmail);
                        users.save(requestModel);
                        flag = true;
                    }
                }

            }
        }catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        if(flag){
            JOptionPane.showMessageDialog(null, "block success!");
        }else{
            JOptionPane.showMessageDialog(null, "block fail!");

        }
        return flag;
    }
}
