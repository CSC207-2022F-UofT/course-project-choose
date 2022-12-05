package reporting_system;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BlockedUserControllerTest {

    private BlockedUserController controller;
    private static final String email = "a@mail.utoronto.ca";
    private static final String blockedEmail = "c@mail.utoronto.ca";
    private UserRepoManager userRepoManager;

    @BeforeEach
    void setUp() throws IOException {

        File csvFile = new File("src/main/resources/blockeduserTest.csv");
        userRepoManager = new UserRepo(csvFile);
        BlockedUserOutputBoundary output = new BlockedUserPresenter();
        BlockedUserInputBoundary BlockedUserInputBoundary = new BlockedUserInteractor(output, userRepoManager);
        controller = new BlockedUserController(BlockedUserInputBoundary);
    }

//    @Test
//    void testBlockedSuccess() {
//        BlockedUserResponseModel rm = controller.updateBlocked("a@mail.utoronto.ca",
//                "c@mail.utoronto.ca");
//        assertTrue(rm.getBlockedStatus());
//
//    }

    @Test
    void testCreateFailure(){
        BlockedUserResponseModel rm = controller.updateBlocked("jimmy.jimmy@hotmail.com",
                "emma.emma@mail.utoronto.ca");
        assertFalse(rm.getBlockedStatus());
    }
}