package email_request;

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

class MatcherUIControllerTest {

    private MatcherUIController controller;
    private static final int DavidNumRequest = 0;
    private static final int JimmyNumRequest = 0;
    private UserRepoManager userRepoManager;

    @BeforeEach
    void setUp() throws IOException {

        File csvFile = new File("src/main/resources/interactorTestFile.csv");
        userRepoManager = new UserRepo(csvFile);
        MatcherUIOutputBoundary output = new MatcherUIPresenter();
        MatcherUIInputBoundary matcherUIInputBoundary = new MatcherUIInteractor(output, userRepoManager);
        controller = new MatcherUIController(matcherUIInputBoundary);
    }

    @Test
    void testCreateSuccess() {
        MatcherUIResponseModel rm = controller.create("david.david@hotmail.com",
                "emma.emma@mail.utoronto.ca");
        assertTrue("emma.emma@mail.utoronto.ca".equals(rm.getRequestedEmailAddress()));

        // reset David's data
        User userB = new User("David", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "\"Hello, This is David \"", Gender.FEMALE);
        UserAccount userAccountB = new UserAccount("david.david@hotmail.com",
                "david.david", userB);
        RequestModel rqB = new RequestModel(userAccountB);
        userRepoManager.update("david.david@hotmail.com", rqB);
        assertEquals(DavidNumRequest,
                userRepoManager.getUserAccount("david.david@hotmail.com").getUserAccount().getNumOfEmailRequest());

    }

    @Test
    void testCreateFailure(){
        MatcherUIResponseModel rm = controller.create("jimmy.jimmy@hotmail.com",
                "emma.emma@mail.utoronto.ca");
        assertTrue("".equals(rm.getRequestedEmailAddress()));
    }
}