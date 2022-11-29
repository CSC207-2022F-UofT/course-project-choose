package upgrade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class tests method in UpgradeResponseModel
 */
public class UpgradeResponseModelTest {

    /**
     * Test to make sure that getEmail returns the email of the user who requests upgrade
     */
    @Test
    void testGetEmail() {
        String mockEmail = "terry.tan@mail.utoronto.ca";
        UpgradeRequestModel upgradeModel = new UpgradeRequestModel(mockEmail);
        assertEquals(mockEmail, upgradeModel.getEmail());
    }
}
