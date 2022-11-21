package upgrade;

import data_access_storage.RequestModel;
import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import email_request.*;
import entities.UserAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpgradeInteractorTest {

    private class MockUpgradeOutputBoundary implements UpgradeOutputBoundary {
        public String receivedEmail = "";

        @Override
        public void onUpgrade(String email) {
            receivedEmail = email;
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
        UpgradeManager.instance().setUserRepoManager(mockUsers);

        String mockEmail = "terry.tan@mail.utoronto.ca";
        UpgradeInteractor upgradeInteractor = new UpgradeInteractor();
        MockUpgradeOutputBoundary mockUpgradeOutputBoundary = new MockUpgradeOutputBoundary();
        upgradeInteractor.setOutputBoundary(mockUpgradeOutputBoundary);

        upgradeInteractor.upgrade(mockEmail);
        assertEquals(mockUpgradeOutputBoundary.receivedEmail, mockEmail);
        assertEquals(true, mockUsers.getUserAccount("terry.tan@mail.utoronto.ca").getUserAccount().getSubStatus());
    }
}
