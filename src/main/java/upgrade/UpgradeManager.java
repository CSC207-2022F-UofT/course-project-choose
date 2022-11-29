package upgrade;

import data_access_storage.RequestModel;
import data_access_storage.UserRepoManager;

/**
 * This class is responsible to take the inputs/request from users, interact with
 * entities to fulfill the upgrading request and prepare output for users
 * Layer: Use Case Layer
 */

public class UpgradeManager implements UpgradeInputBoundary{

    UserRepoManager userRepoManager;
    UpgradeOutputBoundary upgradeOutputBoundary;

    /**
     * Construct an UpgradeManager object.
     * @param userRepoManager an interface to access database UserRepo
     * @param upgradeOutputBoundary an interface where passes output to UpgradeResponseModel
     */

    public UpgradeManager(UserRepoManager userRepoManager,
                          UpgradeOutputBoundary upgradeOutputBoundary) {
        this.userRepoManager = userRepoManager;
        this.upgradeOutputBoundary = upgradeOutputBoundary;
    }

    /**
     * @param upgradeRequestModel request model that includes email of the requester
     * and save it into the UpgradeOutputBoundary
     * */
    @Override
    public void upgrade(UpgradeRequestModel upgradeRequestModel) {
        String email = upgradeRequestModel.getEmail();
        RequestModel requestModel = userRepoManager.getUserAccount(email);
        requestModel.getUserAccount().subscribe();
        userRepoManager.save(requestModel);
        this.upgradeOutputBoundary.onUpgrade(new UpgradeResponseModel(email));
    }
}
