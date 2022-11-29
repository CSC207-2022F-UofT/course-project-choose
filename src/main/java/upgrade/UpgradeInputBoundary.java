package upgrade;

/** Layer: Use Case Layer */
public interface UpgradeInputBoundary {

    /**
     * @param requestModel a data model for the upgrading request
     */

    void upgrade(UpgradeRequestModel requestModel);
}
