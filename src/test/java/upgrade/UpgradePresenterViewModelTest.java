package upgrade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpgradePresenterViewModelTest {

    @Test
    void testGetSuccess() {
        String expectedHint = "You now have unlimited access to email addresses.";
        String expectedTitle = "Hello terry.tan@mail.utoronto.ca";
        boolean expectedNeedUpgrade = false;
        UpgradePresenterViewModel viewModel =
                new UpgradePresenterViewModel(expectedTitle, expectedHint, expectedNeedUpgrade);
        assertEquals(expectedHint, viewModel.getHint());
        assertEquals(expectedTitle, viewModel.getTitle());
        assertEquals(expectedNeedUpgrade, viewModel.getNeedUpgrade());
    }
}
