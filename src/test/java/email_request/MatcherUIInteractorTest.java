package email_request;

import data_access_storage.RequestModel;
import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import entities.Gender;
import entities.Hobbies;
import entities.User;
import entities.UserAccount;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MatcherUIInteractorTest {

    private MatcherUIInteractor interactor;

    @BeforeEach
    void setUp() throws IOException {
        File csvFile = new File("src/main/resources/interactorTestFile.csv");
        UserRepoManager repo = new UserRepo(csvFile);
        MatcherUIOutputBoundary output = new MatcherUIPresenter();
        interactor = new MatcherUIInteractor(output, repo);
    }

    @Test
    void testCreateSuccess(){
        MatcherUIRequestModel rm = new MatcherUIRequestModel("david.david@hotmail.com",
                "emma.emma@mail.utoronto.ca");
        MatcherUIResponseModel rq = interactor.create(rm);
        assertEquals( "emma.emma@mail.utoronto.ca",
                rq.getRequestedEmailAddress());
        assertEquals(1,
                interactor.userRepoManager.getUserAccount("david.david@hotmail.com").getUserAccount().getNumOfEmailRequest());

        // reset David's data
        User userB = new User("David", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "\"Hello, This is David \"", Gender.FEMALE);
        UserAccount userAccountB = new UserAccount("david.david@hotmail.com",
                "david.david", userB);
        RequestModel  rqB = new RequestModel(userAccountB);
        interactor.userRepoManager.update("david.david@hotmail.com", rqB);
    }



}