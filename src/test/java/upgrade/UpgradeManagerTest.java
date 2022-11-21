package upgrade;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpgradeManagerTest {

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
        UpgradeManager.instance().upgrade(mockEmail);
        assertEquals(true, mockUsers.getUserAccount("terry.tan@mail.utoronto.ca").getUserAccount().getSubStatus());
    }
}
