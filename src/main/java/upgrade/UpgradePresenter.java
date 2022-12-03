package upgrade;

import java.util.Objects;

/**
 * This class handles the upgrading request by passing email address
 * and prepare the upgrade subscription status for viewing purpose
 * Layer: Use Case Layer
 */
public class UpgradePresenter implements UpgradeOutputBoundary {

    private String currentEmail;
    private boolean finishSubscribed;

    /**
     * @param currentEmail bundle upgrade request by passing email
     */
    public UpgradePresenter(String currentEmail) {
        this.currentEmail = currentEmail;
        this.finishSubscribed = false;
    }

    /**
     * @param responseModel the upgrade status that is prepared for viewing
     * and update the subscription status
     */
    @Override
    public void onUpgrade(UpgradeResponseModel responseModel) {
        if (Objects.equals(responseModel.getEmail(), currentEmail)) {
            finishSubscribed = true;
        }
    }

    /**
     * Prepare the upgrade subscription status for viewing
     * @return the upgrade subscription status that iis prepared for viewing
     */
    public UpgradePresenterViewModel prepareView() {
        String hint;
        if (finishSubscribed) {
            hint = "You now have unlimited access to email addresses.";
        } else {
            hint = "<html>Your number of email requests has exceeded request limit.<br>" +
                    "Please EMT $50 to \"unlimited.access@mail.utoronto.ca\" and click \"Upgrade\" to subscribe.</html>";
        }
        String title = String.format("Hello %s", currentEmail);
        return new UpgradePresenterViewModel(title, hint, !finishSubscribed);
    }
}
