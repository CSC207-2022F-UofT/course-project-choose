package reporting_system;


import data_access_storage.RequestModel;
import data_access_storage.UserRepoManager;
import entities.UserAccount;

import java.util.List;
import java.util.Map;

/**
 * This class is responsible to take the inputs/request from users, interact with
 * entities to fulfil the request and prepare output for users.
 * Layer: Use Case
 */
public class BlockedUserInteractor implements BlockedUserInputBoundary {

    final BlockedUserOutputBoundary BlockedUserOutputBoundary;
    final UserRepoManager userRepoManager;

    /**
     * Construct a BlockedUserInteractor object.
     * @param BlockedUserOutputBoundary a interface that allows BlockedUserInteractor to call
     *                                BlockedUserPrenseter without knowing its existence.
     * @param userRepoManager a data access interface
     */

    public BlockedUserInteractor(BlockedUserOutputBoundary BlockedUserOutputBoundary,
                                 UserRepoManager userRepoManager) {
        this.BlockedUserOutputBoundary = BlockedUserOutputBoundary;
        this.userRepoManager = userRepoManager;
    }

    /**
     * Take the email request from users and decide whether
     * the requesters can see the requested email address.
     * If so, return the requested email address, and empty string otherwise.
     * @param requestModel a data model for the email request
     * @return a data model for showing the requested email or empty string.
     */

    @Override
    public BlockedUserResponseModel updateBlocked(BlockedUserRequestModel requestModel) {

        boolean blockedStatus=false;
        String email=requestModel.getEmail();
        String blockedEmail= requestModel.getBlockedEmail();
        RequestModel requestModel2;
        Map<String, RequestModel> allUserAccount = this.userRepoManager.getAllUserAccount();
        for (String s : allUserAccount.keySet()) {
            requestModel2 = allUserAccount.get(s);
            if(requestModel2!=null && requestModel2.getUserAccount()!=null){
                UserAccount userAccount = requestModel2.getUserAccount();
                String email1 = userAccount.getEmail();
                if(email1.equals(email)){
                    List<String> blockedAccounts = userAccount.getBlockedAccounts();
                    blockedAccounts.add(blockedEmail);
                    this.userRepoManager.save(requestModel2);
                    blockedStatus = true;
                }
            }

        }
        // prepare the resulted email address to show to users.
        BlockedUserResponseModel BlockedUserResponseModel = new BlockedUserResponseModel(blockedStatus);
        return BlockedUserOutputBoundary.prepareView(BlockedUserResponseModel);
    }
}
