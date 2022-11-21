package upgrade;

import data_access_storage.RequestModel;
import data_access_storage.UserRepoManager;

public class UpgradeManager {
    private UserRepoManager userRepoManager;
    private static UpgradeManager instance;

    public static UpgradeManager instance() {
        synchronized (UpgradeManager.class) {
            if (instance == null) {
                instance = new UpgradeManager();
            }
        }
        return instance;
    }

    public void setUserRepoManager(UserRepoManager userRepoManager) {
        this.userRepoManager = userRepoManager;
    }

    public void upgrade(String email) {
        if (this.userRepoManager != null) {
            RequestModel requestModel = userRepoManager.getUserAccount(email);
            requestModel.getUserAccount().subscribe();
            userRepoManager.save(requestModel);
        }
    }
}
