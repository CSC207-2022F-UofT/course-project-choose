package login_management_system;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class LoginControllerTest {
    private LoginController controller;
    private UserRepoManager userRepoManager;

    @BeforeEach
    void setUp() throws IOException {

        File csvFile = new File("src/main/resources/matchingSystemTest.csv");
        userRepoManager = new UserRepo(csvFile);
        LoginOutputBoundary output = new LoginPresenter();
        LoginInputBoundary input = new LoginInteractor(userRepoManager, output);
        controller = new LoginController(input);
    }

    @Test
    void testLoginSuccess() {
        LoginResponseModel rm = controller.checkValidLogin("h@hotmail.com",
                "david.david");
        assertTrue(rm.getLoginStatus());
        assertEquals(rm.getUser(), userRepoManager.getUserAccount("h@hotmail.com").getUserAccount().getUser());
    }

    @Test
    void testLoginFailure_UserNotExist(){
        String actualMessage = null;
        try{
            controller.checkValidLogin("h.com",
                    "david");
        } catch (LoginFailedException ex){
            actualMessage = ex.getmessage();
        }
        String expectedMessage = "User doesn't exists.";
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testLoginFailure_UnmatchedPassword(){
        String actualMessage = null;
        try{
            controller.checkValidLogin("h@hotmail.com",
                    "david");
        } catch (LoginFailedException ex){
            actualMessage = ex.getmessage();
        }
        String expectedMessage = "Password doesn't match username.";
        assertEquals(expectedMessage, actualMessage);
    }

}
