package login_management_system;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class test methods in LoginController.
 */
public class LoginControllerTest {
    private LoginController controller;
    private UserRepoManager userRepoManager;

    /**
     * Set up data access and controller for each test
     * @throws IOException throws IOException when the csv file path or the inquired user data is not found.
     */
    @BeforeEach
    void setUp() throws IOException {

        File csvFile = new File("src/main/resources/matchingSystemTest.csv");
        userRepoManager = new UserRepo(csvFile);
        LoginOutputBoundary output = new LoginPresenter();
        LoginInputBoundary input = new LoginInteractor(userRepoManager, output);
        controller = new LoginController(input);
    }

    /**
     * A user who enters correct email and password.
     * The controller should have return the data model containing the user.
     */
    @Test
    void testLoginSuccess() {
        LoginResponseModel rm = controller.checkValidLogin("h@hotmail.com",
                "david.david");
        assertTrue(rm.getLoginStatus());
        assertEquals(rm.getUser(), userRepoManager.getUserAccount("h@hotmail.com").getUserAccount().getUser());
    }

    /**
     * A user who enters a username that doesn't exist.
     * The controller should have thrown an exception with the message "You have entered an invalid username".
     */
    @Test
    void testLoginFailure_UserNotExist(){
        String actualMessage = null;
        Exception loginException = assertThrows(LoginFailedException.class, () -> controller.
                checkValidLogin("h.com", "david"));
        String expectedMessage = "You have entered an invalid username.";
        assertEquals(expectedMessage, loginException.getMessage());
    }

    /**
     * A user who enters a username that doesn't exist.
     * The controller should have thrown an exception with the message "You have entered an invalid password.".
     */
    @Test
    void testLoginFailure_UnmatchedPassword(){
        String actualMessage = null;
        try{
            controller.checkValidLogin("h@hotmail.com",
                    "david");
        } catch (LoginFailedException ex){
            actualMessage = ex.getMessage();
        }
        String expectedMessage = "You have entered an invalid password.";
        assertEquals(expectedMessage, actualMessage);
    }

}
