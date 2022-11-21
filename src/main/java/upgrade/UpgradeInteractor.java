package upgrade;

public class UpgradeInteractor implements UpgradeInputBoundary {

    UpgradeOutputBoundary outputBoundary;

    public UpgradeInteractor() {
    }

    public void setOutputBoundary(UpgradeOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void upgrade(String email) {
        UpgradeManager.instance().upgrade(email);
        if (this.outputBoundary != null) {
            this.outputBoundary.onUpgrade(email);
        }
    }
}
