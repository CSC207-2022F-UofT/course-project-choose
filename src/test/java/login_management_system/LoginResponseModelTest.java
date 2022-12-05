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
 * This class test methods in LoginResponseModel.
 */

public class LoginResponseModelTest {
    private LoginResponseModel loginResponseModel;
    private User user;

    /**
     * Set up data access and controller for each test
     * @throws IOException throws IOException when the csv file path or the inquired user data is not found.
     */

    @BeforeEach
    void setUp() throws IOException {
        File csvFile = new File("src/main/resources/matchingSystemTest.csv");
        UserRepoManager repo = new UserRepo(csvFile);
        user = repo.getUserAccount("b@hotmail.com").getUserAccount().getUser();
        loginResponseModel = new LoginResponseModel(user, "b@hotmail.com");
    }

    /** Test to make sure getUser returns the login user */
    @Test
    void getUser() {
        assertEquals(user,
                loginResponseModel.getUser());
    }

    /** Test to make sure getEmail returns the login user's email address */
    @Test
    void getEmail() {
        assertEquals("b@hotmail.com",
                loginResponseModel.getEmail());
    }

    /** Test to make sure before login, login status is false */
    @Test
    void getLoginStatus() {
        assertFalse(loginResponseModel.getLoginStatus());
    }

    /** Test to make sure after login sucessfully, login status is true */
    @Test
    void setLoginStatus() {
        loginResponseModel.setLoginStatus();
        assertTrue(loginResponseModel.getLoginStatus());
    }
}
