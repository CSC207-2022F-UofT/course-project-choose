package upgrade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class tests methods in UpgradePresenter
 */
public class UpgradePresenterTest {

    /**
     * Test the following case that requests upgrade successfully
     * shows the correct sentences including title and presented sentences
     * and tell if upgrade needed
     */
    @Test
    void testUpgradeSuccess() {

        String mockEmail = "terry.tan@mail.utoronto.ca";
        UpgradePresenter upgradePresenter = new UpgradePresenter(mockEmail);
        upgradePresenter.onUpgrade(new UpgradeResponseModel(""));
        UpgradePresenterViewModel viewModel = upgradePresenter.prepareView();

        String expectedInitialHint = "<html>Your number of email requests has exceeded request limit.<br>" +
                "Please EMT $50 to \"unlimited.access@mail.utoronto.ca\" and click \"Upgrade\" to subscribe.</html>";
        String expectedInitialTitle = "Hello terry.tan@mail.utoronto.ca";
        boolean expectedInitialNeedUpgrade = true;

        assertEquals(expectedInitialHint, viewModel.getHint());
        assertEquals(expectedInitialTitle, viewModel.getTitle());
        assertEquals(expectedInitialNeedUpgrade, viewModel.getNeedUpgrade());

        upgradePresenter.onUpgrade(new UpgradeResponseModel(mockEmail));
        viewModel = upgradePresenter.prepareView();
        String expectedUpgradeHint = "You now have unlimited access to email addresses.";
        String expectedUpgradeTitle = "Hello terry.tan@mail.utoronto.ca";
        boolean expectedUpgradeNeedUpgrade = false;
        assertEquals(expectedUpgradeHint, viewModel.getHint());
        assertEquals(expectedUpgradeTitle, viewModel.getTitle());
        assertEquals(expectedUpgradeNeedUpgrade, viewModel.getNeedUpgrade());
    }
}
