package upgrade;

public class UpgradeController {

    UpgradeInputBoundary upgradeInputBoundary;

    public UpgradeController(UpgradeInputBoundary upgradeInputBoundary) {
        this.upgradeInputBoundary = upgradeInputBoundary;
    }

    public void upgrade(String email) {
        this.upgradeInputBoundary.upgrade(email);
    }
}
