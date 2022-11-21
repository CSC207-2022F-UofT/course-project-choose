package upgrade;

public class UpgradePresenterViewModel {
    private String title;
    private String hint;
    private boolean needUpgrade;

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
