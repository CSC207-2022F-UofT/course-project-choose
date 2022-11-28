package upgrade;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpgradeManagerTest {

    private class MockUpgradeOutputBoundary implements UpgradeOutputBoundary {
        public String receivedEmail = "";

        @Override
        public void onUpgrade(UpgradeResponseModel responseModel) {
            receivedEmail = responseModel.getEmail();
        }
    }

    private class MockUpgradeInputBoundary implements UpgradeInputBoundary {
        public String receivedEmail = "";

        @Override
        public void upgrade(UpgradeRequestModel requestModel) {
            receivedEmail = requestModel.getEmail();
        }
    }

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
        assertEquals(true, mockUsers.getUserAccount("terry.tan@mail.utoronto.ca").getUserAccount().getSubStatus());
    }
}
