package blocking_reporting_system.blocking_system;


import data_access_storage.RequestModel;
import data_access_storage.UserRepoManager;
import entities.UserAccount;

import javax.sound.midi.SysexMessage;
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
     * @param blockedUserRequestModel a data model for the email request
     * @return a data model for showing the requested email or empty string.
     */

    @Override
    public BlockedUserResponseModel updateBlocked(BlockedUserRequestModel blockedUserRequestModel) {
        boolean blockedStatus=false;
        String email=blockedUserRequestModel.getEmail();
        String blockedEmail= blockedUserRequestModel.getBlockedEmail();
        RequestModel requestModel = this.userRepoManager.getUserAccount(email);
        requestModel.getUserAccount().block(blockedUserRequestModel.getBlockedEmail());
        this.userRepoManager.update(requestModel.getUserAccount().getEmail(), requestModel);
        blockedStatus = true;
        // prepare the resulted email address to show to users.
        BlockedUserResponseModel BlockedUserResponseModel = new BlockedUserResponseModel(blockedStatus);
        return BlockedUserOutputBoundary.prepareView(BlockedUserResponseModel);
    }
}
