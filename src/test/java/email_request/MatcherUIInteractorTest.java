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
 * This class tests methods in EmailConnInteractor.
 */

class MatcherUIInteractorTest {
    private EmailConnInteractor interactor;
    /** User Jimmy in our data file requests 6 email addresses already */
    private static final int jimmyNumRequest = 6;

    /** User David in our data file requests 0 email addresses */
    private static final int DavidNumRequest = 0;

    /**
     * Set up data access and interator for each test
     * The csv file has data for 3 users.
     * David: a free male user who requested 0 number of email addresses.
     * Jimmy: a free male user who already requests 6 email addresses that are more than the request limit.
     * Emma: a female user
     * @throws IOException throws IOException when the csv file path or the inquired user data is not found.
     */
    @BeforeEach
    void setUp() throws IOException {
        File csvFile = new File("src/main/resources/interactorTestFile.csv");
        UserRepoManager repo = new UserRepo(csvFile);
        EmailConnOutputBoundary output = new EmailConnPresenter();
        interactor = new EmailConnInteractor(output, repo);
    }

    /**
     * Test the following case that requests an email address successfully.
     * David, a free male user, requests 0 email addresses and should
     * request Emma's email address successfully.
     * Thus, Emma's email address should be contained in the response model.
     * After requesting an email address, David's number of email requests should be increased by 1.
     */
    @Test
    void testCreateSuccess(){
        EmailConnRequestModel rm = new EmailConnRequestModel("david.david@hotmail.com",
                "emma.emma@mail.utoronto.ca");
        EmailConnResponseModel rq = interactor.create(rm);
        assertEquals( "emma.emma@mail.utoronto.ca",
                rq.getRequestedEmailAddress());
        assertEquals(DavidNumRequest + 1,
                interactor.userRepoManager.getUserAccount("david.david@hotmail.com").getUserAccount().getNumOfEmailRequest());

        // reset David's data
        User userB = new User("David", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "\"Hello, This is David \"", Gender.FEMALE);
        UserAccount userAccountB = new UserAccount("david.david@hotmail.com",
                "david.david", userB);
        RequestModel  rqB = new RequestModel(userAccountB);
        interactor.userRepoManager.update("david.david@hotmail.com", rqB);
        assertEquals(DavidNumRequest,
                interactor.userRepoManager.getUserAccount("david.david@hotmail.com").getUserAccount().getNumOfEmailRequest());
    }

    /**
     * Test the following case that fails to request an email address.
     * Jimmy, a free male user, requests 6 email addresses that is more than the maximum limit.
     * Thus, Jimmy should fail to request Emma's email address.
     * Thus, the response model does not have Emma's email address, and contains "".
     * Since Jimmy fails to request an email address, Jimmy's number of email requests stays the same.
     */
    @Test
    void testCreateFailure() {
        EmailConnRequestModel rm = new EmailConnRequestModel("jimmy.jimmy@hotmail.com",
                "emma.emma@mail.utoronto.ca");
        EmailConnResponseModel rq = interactor.create(rm);
        assertEquals( "",
                rq.getRequestedEmailAddress());
        assertEquals(jimmyNumRequest,
                interactor.userRepoManager.getUserAccount("jimmy.jimmy@hotmail.com").getUserAccount().getNumOfEmailRequest());
    }


}