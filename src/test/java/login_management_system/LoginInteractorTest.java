package login_management_system;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class test methods in LoginInteractor.
 */
public class LoginInteractorTest {
    private LoginInteractor interactor;

    /**
     * Set up data access and controller for each test
     * @throws IOException throws IOException when the csv file path or the inquired user data is not found.
     */
    @BeforeEach
    void setUp() throws IOException {
        File csvFile = new File("src/main/resources/matchingSystemTest.csv");
        UserRepoManager repo = new UserRepo(csvFile);
        LoginOutputBoundary output = new LoginPresenter();
        interactor = new LoginInteractor(repo, output);
    }

    /**
     * A user who enters correct email and password.
     * The interactor should have return the data model containing the user.
     */
    @Test
    void testLoginSuccess(){
        LoginRequestModel rm = new LoginRequestModel("h@hotmail.com", "david.david");
        LoginResponseModel rq = interactor.checkValidLogin(rm);
        assertTrue(rq.getLoginStatus());

        assertEquals(rq.getUser(), interactor.userRepoManager.getUserAccount("h@hotmail.com").
                getUserAccount().getUser());
    }

    /**
     * A user who enters a username that doesn't exist.
     * The interactor should have thrown an exception with the message "You have entered an invalid username".
     */
    @Test
    void testLoginFailure_UserNotExist() {
        String actualMessage = null;
        LoginRequestModel rm = new LoginRequestModel("h@hotm.com", "david.david");
        try{
            interactor.checkValidLogin(rm);
        } catch (LoginFailedException ex){
            actualMessage = ex.getMessage();
        }
        String expectedMessage = "You have entered an invalid username.";
        assertEquals(expectedMessage, actualMessage);
    }

    /**
     * A user who enters a username that doesn't exist.
     * The interactor should have thrown an exception with the message "You have entered an invalid password".
     */

    @Test
    void testLoginFailure_UnmatchedPassword(){
        String actualMessage = null;
        LoginRequestModel rm = new LoginRequestModel("h@hotmail.com", "david");
        try{
            interactor.checkValidLogin(rm);
        } catch (LoginFailedException ex){
            actualMessage = ex.getMessage();
        }
        String expectedMessage = "You have entered an invalid password.";
        assertEquals(expectedMessage, actualMessage);
    }

}
