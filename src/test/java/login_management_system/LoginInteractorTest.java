package login_management_system;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginInteractorTest {
    private LoginInteractor interactor;

    @BeforeEach
    void setUp() throws IOException {
        File csvFile = new File("src/main/resources/matchingSystemTest.csv");
        UserRepoManager repo = new UserRepo(csvFile);
        LoginOutputBoundary output = new LoginPresenter();
        interactor = new LoginInteractor(repo, output);
    }

    @Test
    void testLoginSuccess(){
        LoginRequestModel rm = new LoginRequestModel("h@hotmail.com", "david.david");
        LoginResponseModel rq = interactor.checkValidLogin(rm);
        assertTrue(rq.getLoginStatus());

        assertEquals(rq.getUser(), interactor.userRepoManager.getUserAccount("h@hotmail.com").
                getUserAccount().getUser());
    }

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
