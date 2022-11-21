package upgrade;

public class UpgradePresenter implements UpgradeOutputBoundary {

    private String currentEmail;
    private boolean finishSubscribed;

    public UpgradePresenter(String currentEmail) {
        this.currentEmail = currentEmail;
        this.finishSubscribed = false;
    }

    @Override
    public void onUpgrade(String email) {
        if (email == currentEmail)
            finishSubscribed = true;
    }

    public UpgradePresenterViewModel prepareView() {
        String hint = "";
        if (finishSubscribed) {
            hint = "You now have unlimited access to email addresses.";
        } else {
            hint = "<html>Your number of email requests has exceed request limit.<br>" +
                    "Please EMT $50 to \"unlimited.access@mail.utoronto.ca\" and click \"Upgrade\" to subscribe.</html>";
        }
        String title = String.format("Hello %s", currentEmail);
        return new UpgradePresenterViewModel(title, hint, !finishSubscribed);
    }
}
