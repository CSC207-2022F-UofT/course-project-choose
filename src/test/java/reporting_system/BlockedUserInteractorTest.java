package reporting_system;

import data_access_storage.RequestModel;
import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import entities.Gender;
import entities.Hobbies;
import entities.User;
import entities.UserAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BlockedUserInteractorTest {

    private BlockedUserInteractor interactor;



    @BeforeEach
    void setUp() throws IOException {
        File csvFile = new File("src/main/resources/blockeduserTest.csv");
        UserRepoManager repo = new UserRepo(csvFile);
        BlockedUserOutputBoundary output = new BlockedUserPresenter();
        interactor = new BlockedUserInteractor(output, repo);
    }

    @Test
    void testCreateSuccess(){
        BlockedUserRequestModel rm = new BlockedUserRequestModel("b@hotmail.com",
                "f@hotmail.com");
        BlockedUserResponseModel rq = interactor.updateBlocked(rm);
        assertTrue( rq.getBlockedStatus());

    }

    @Test
    void testCreateFailure() {
        BlockedUserRequestModel rm = new BlockedUserRequestModel("jimmy.jimmy@hotmail.com",
                "emma.emma@mail.utoronto.ca");
        BlockedUserResponseModel rq = interactor.updateBlocked(rm);
        assertFalse(rq.getBlockedStatus());

    }




}