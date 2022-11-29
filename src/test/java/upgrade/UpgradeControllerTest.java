package upgrade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class test methods in UpgradeController
 */
public class UpgradeControllerTest {

    private class MockUpgradeInputBoundary implements UpgradeInputBoundary {
        public String receivedEmail = "";

        @Override
        public void upgrade(UpgradeRequestModel requestModel) {
            receivedEmail = requestModel.getEmail();
        }
    }

    /**
     * A free male user whose number of email requests has exceeded request limit should
     * upgrade successfully.
     */
    @Test
    void testUpgradeSuccess() {
        String mockEmail = "terry.tan@mail.utoronto.ca";
        MockUpgradeInputBoundary mockUpgradeInputBoundary = new MockUpgradeInputBoundary();
        UpgradeController upgradeController = new UpgradeController(mockUpgradeInputBoundary);
        upgradeController.upgrade(mockEmail);
        assertEquals(mockEmail, mockUpgradeInputBoundary.receivedEmail);
    }
}
