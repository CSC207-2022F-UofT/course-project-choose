package login_management_system;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class test methods in LoginPresenter.
 */

public class LoginPresenterTest {
    private LoginPresenter lp;
    private UserRepoManager userRepoManager;

    /**
     * Set up data access and controller for each test
     * @throws IOException throws IOException when the csv file path or the inquired user data is not found.
     */

    @BeforeEach
    void setUp() throws IOException {
        lp = new LoginPresenter();
        File csvFile = new File("src/main/resources/matchingSystemTest.csv");
        userRepoManager = new UserRepo(csvFile);
    }

    /**
     * Test whether presenter return a LoginResponseModel as required and the LoginStatus is changed to true as
     * it should.
     */

    @Test
    void prepareSuccessView() {
        User user = userRepoManager.getUserAccount("h@hotmail.com").getUserAccount().getUser();
        LoginResponseModel rm  = new LoginResponseModel(user, "h@hotmail.com");
        LoginResponseModel result =  lp.prepareSuccessView(rm);
        assertEquals(result, rm);
        assertTrue(result.getLoginStatus());
    }

    /**
     * Test whether presenter return an error as required
     */

    @Test
    void prepareFailedView() {
        String actualMessage = null;
        try{
            lp.prepareFailView("You have entered an invalid username.");
        } catch (LoginFailedException ex){
            actualMessage = ex.getMessage();
        }
        String expectedMessage = "You have entered an invalid username.";
        assertEquals(expectedMessage, actualMessage);
    }
}
