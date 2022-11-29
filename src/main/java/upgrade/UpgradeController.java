package upgrade;

public class UpgradeController {

    /**
     * This class is responsible to response to button clicks on
     * upgrade and bundle the request data.
     * Layer: Interface Adapters Layer
     */
    UpgradeInputBoundary upgradeInputBoundary;

    /**
     * Create a controller that responses to button clicks on upgrade and bundle the request data
     * @param upgradeInputBoundary The abstraction layer
     */

    public UpgradeController(UpgradeInputBoundary upgradeInputBoundary) {
        this.upgradeInputBoundary = upgradeInputBoundary;
    }

    /**
     * @param email A String that store email of requester which pass to UpgradeRequestModel
     */
    public void upgrade(String email) {
        this.upgradeInputBoundary.upgrade(new UpgradeRequestModel(email));
    }
}
