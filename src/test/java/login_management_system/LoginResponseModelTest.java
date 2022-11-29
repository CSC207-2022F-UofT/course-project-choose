package login_management_system;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import entities.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class LoginResponseModelTest {
    private LoginResponseModel loginResponseModel;
    private User user;

    @BeforeEach
    void setUp() throws IOException {
        File csvFile = new File("src/main/resources/matchingSystemTest.csv");
        UserRepoManager repo = new UserRepo(csvFile);
        user = repo.getUserAccount("b@hotmail.com").getUserAccount().getUser();
        loginResponseModel = new LoginResponseModel(user);
    }

    @Test
    void getUser() {
        assertEquals(user,
                loginResponseModel.getUser());
    }

    @Test
    void getLoginStatus() {
        assertFalse(loginResponseModel.getLoginStatus());
    }

    @Test
    void setLoginStatus() {
        loginResponseModel.setLoginStatus();
        assertTrue(loginResponseModel.getLoginStatus());
    }
}
