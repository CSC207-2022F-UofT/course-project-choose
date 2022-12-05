package upgrade;

/**
 * This class is the abstraction that allows UpgradeManager to pass upgrading request
 * to UpgradePresenter without violating Dependency Rules of Clean Architecture\
 * Layer: Use Case Layer
 */
public interface UpgradeOutputBoundary {
    /**
     * Prepare the upgrade subscription status for viewing
     * @param responseModel the upgrade status that is prepared for viewing
     */
    void onUpgrade(UpgradeResponseModel responseModel);

    void setCurrentEmail(String currentEmail);

    UpgradePresenterViewModel prepareView();
}

