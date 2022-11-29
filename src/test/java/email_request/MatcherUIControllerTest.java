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

/**
 * This class test methods in MatcherUIController.
 */
class MatcherUIControllerTest {

    private MatcherUIController controller;
    private UserRepoManager userRepoManager;

    /**
     * Set up data access and controller for each test
     * The csv file has data for 3 users.
     * David: a free male user who requested 0 number of email addresses.
     * Jimmy: a free male user who already requests 6 email addresses that are more than the request limit.
     * Emma: a female user
     * @throws IOException throws IOException when the csv file path or the inquired user data is not found.
     */
    @BeforeEach
    void setUp() throws IOException {

        File csvFile = new File("src/main/resources/interactorTestFile.csv");
        userRepoManager = new UserRepo(csvFile);
        MatcherUIOutputBoundary output = new MatcherUIPresenter();
        MatcherUIInputBoundary matcherUIInputBoundary = new MatcherUIInteractor(output, userRepoManager);
        controller = new MatcherUIController(matcherUIInputBoundary);
    }

    /**
     * A free male user whose number of email requests is smaller than the request limit should
     * request the email address successfully.
     * The controller should return the requested email address.
     */
    @Test
    void testCreateSuccess() {
        MatcherUIResponseModel rm = controller.create("david.david@hotmail.com",
                "emma.emma@mail.utoronto.ca");
        assertEquals("emma.emma@mail.utoronto.ca", rm.getRequestedEmailAddress());

        // reset David's data
        User userB = new User("David", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "\"Hello, This is David \"", Gender.FEMALE);
        UserAccount userAccountB = new UserAccount("david.david@hotmail.com",
                "david.david", userB);
        RequestModel rqB = new RequestModel(userAccountB);
        userRepoManager.update("david.david@hotmail.com", rqB);
        assertEquals(0,
                userRepoManager.getUserAccount("david.david@hotmail.com").getUserAccount().getNumOfEmailRequest());

    }

    /**
     * A free male user whose number of email requests is more than the request limit should fail to
     * request the email address.
     * The controller should return the empty string.
     */
    @Test
    void testCreateFailure(){
        MatcherUIResponseModel rm = controller.create("jimmy.jimmy@hotmail.com",
                "emma.emma@mail.utoronto.ca");
        assertEquals("", rm.getRequestedEmailAddress());
    }
}