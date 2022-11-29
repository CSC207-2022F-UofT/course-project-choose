package upgrade;

/**
 * This class is view model for Presenter to present
 * Layer: Interface Adapters Layer
 */
public class UpgradePresenterViewModel {
    private String title;
    private String hint;
    private boolean needUpgrade;

    /**
     * @param title title format
     * @param hint present sentences for the user who has exceeded request limit to upgrade
     * @param needUpgrade whether the user click the Upgrade button
     */
    public UpgradePresenterViewModel(String title, String hint, boolean needUpgrade) {
        this.title = title;
        this.hint = hint;
        this.needUpgrade = needUpgrade;
    }

    public String getTitle() {
        return title;
    }

    public String getHint() {
        return hint;
    }

    public boolean getNeedUpgrade() {
        return needUpgrade;
    }
}
