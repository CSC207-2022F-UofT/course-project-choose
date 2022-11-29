package login_management_system;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class LoginPresenterTest {
    private LoginPresenter lp;
    private UserRepoManager userRepoManager;

    @BeforeEach
    void setUp() throws IOException {
        lp = new LoginPresenter();
        File csvFile = new File("src/main/resources/matchingSystemTest.csv");
        userRepoManager = new UserRepo(csvFile);
    }

    @Test
    void prepareSuccessView() {
        User user = userRepoManager.getUserAccount("h@hotmail.com").getUserAccount().getUser();
        LoginResponseModel rm  = new LoginResponseModel(user);
        LoginResponseModel result =  lp.prepareSuccessView(rm);
        assertEquals(result, rm);
    }

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
