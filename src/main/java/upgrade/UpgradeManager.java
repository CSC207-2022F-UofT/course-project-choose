package upgrade;

import data_access_storage.RequestModel;
import data_access_storage.UserRepoManager;

public class UpgradeManager implements UpgradeInputBoundary{

    UserRepoManager userRepoManager;
    UpgradeOutputBoundary upgradeOutputBoundary;

    public UpgradeManager(UserRepoManager userRepoManager,
                          UpgradeOutputBoundary upgradeOutputBoundary) {
        this.userRepoManager = userRepoManager;
        this.upgradeOutputBoundary = upgradeOutputBoundary;
    }

    @Override
    public void upgrade(UpgradeRequestModel upgradeRequestModel) {
        String email = upgradeRequestModel.getEmail();
        RequestModel requestModel = userRepoManager.getUserAccount(email);
        requestModel.getUserAccount().subscribe();
        userRepoManager.save(requestModel);
        this.upgradeOutputBoundary.onUpgrade(new UpgradeResponseModel(email));
    }
}
