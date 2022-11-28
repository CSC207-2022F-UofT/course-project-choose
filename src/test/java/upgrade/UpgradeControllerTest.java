package upgrade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UpgradeControllerTest {

    private class MockUpgradeInputBoundary implements UpgradeInputBoundary {
        public String receivedEmail = "";

        @Override
        public void upgrade(UpgradeRequestModel requestModel) {
            receivedEmail = requestModel.getEmail();
        }
    }

    @Test
    void testUpgradeSuccess() {
        String mockEmail = "terry.tan@mail.utoronto.ca";
        MockUpgradeInputBoundary mockUpgradeInputBoundary = new MockUpgradeInputBoundary();
        UpgradeController upgradeController = new UpgradeController(mockUpgradeInputBoundary);
        upgradeController.upgrade(mockEmail);
        assertEquals(mockEmail, mockUpgradeInputBoundary.receivedEmail);
    }
}
