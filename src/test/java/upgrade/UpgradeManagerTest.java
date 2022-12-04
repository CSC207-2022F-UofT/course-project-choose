package upgrade;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class tests methods in UpgradeManager
 */
public class UpgradeManagerTest {

    private class MockUpgradeOutputBoundary implements UpgradeOutputBoundary {
        public String receivedEmail = "";

        @Override
        public void onUpgrade(UpgradeResponseModel responseModel) {
            receivedEmail = responseModel.getEmail();
        }

        @Override
        public void setCurrentEmail(String currentEmail) {
            // please fill this in
        }

        @Override
        public UpgradePresenterViewModel prepareView() {
            return null;
        }
    }

    private class MockUpgradeInputBoundary implements UpgradeInputBoundary {
        public String receivedEmail = "";

        @Override
        public void upgrade(UpgradeRequestModel requestModel) {
            receivedEmail = requestModel.getEmail();
        }
    }

    /**
     * Test the following case that requests upgrade successfully.
     * Terry Tan, a free male user, requests sixth email address and should
     * upgrade successfully.
     * Thus, the upgrade subscription status should be updated as True
     * and Terry's number of email requests should be stayed at 5 after requesting upgrade
     */
    @Test
    void testUpgradeSuccess() {
        UserRepoManager mockUsers;
        try{
            File csvFile = new File("src/main/resources/upgradeTestFile.csv");
            mockUsers = new UserRepo(csvFile);
        }catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }

        MockUpgradeOutputBoundary outputBoundary = new MockUpgradeOutputBoundary();
        UpgradeManager upgradeManager = new UpgradeManager(mockUsers, outputBoundary);

        String mockEmail = "terry.tan@mail.utoronto.ca";

        upgradeManager.upgrade(new UpgradeRequestModel(mockEmail));
        assertEquals(outputBoundary.receivedEmail, mockEmail);
        assertTrue(mockUsers.getUserAccount("terry.tan@mail.utoronto.ca").getUserAccount().getSubStatus());
    }
}
