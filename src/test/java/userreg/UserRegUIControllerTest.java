package userreg;

import user_register_system.*;
import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import entities.Gender;
import entities.Hobbies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserRegUIControllerTest {

    private UserRegUIController controller;

    private UserRepoManager userRepoManager;

    @BeforeEach
    void setUp() throws IOException {

        File csvFile = new File("src/main/resources/userReg.csv");
        userRepoManager = new UserRepo(csvFile);
        UserRegUIOutputBoundary output = new UserRegUIPresenter();
        UserRegUIInputBoundary UserRegUIInputBoundary = new UserRegUIInteractor(output, userRepoManager);
        controller = new UserRegUIController(UserRegUIInputBoundary);
    }
    @Test
    void testCreatSucess(){
        this.userRepoManager.delete("jim.jim@mail.utoronto.ca");
        UserRegUIResponseModel rm = controller.userProfileCreate("jim.jim@mail.utoronto.ca","123","David1", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "\"Hello, This is David \"", Gender.FEMALE);

        assertEquals("SUCCESS", rm.getRegMessage());
    }
    @Test
    void testEmailInvalid() {

        UserRegUIResponseModel rm = controller.userProfileCreate("343567@mail2.utoronto.ca","123","David1", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "\"Hello, This is David \"", Gender.FEMALE);
        assertEquals("ERR001", rm.getRegMessage());

    }

    @Test
    void testEmailExisted(){
        this.userRepoManager.delete("jim.jim@mail.utoronto.ca");
        UserRegUIResponseModel rm0 = controller.userProfileCreate("jim.jim@mail.utoronto.ca","123","David1", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "\"Hello, This is David \"", Gender.FEMALE);
        UserRegUIResponseModel rm = controller.userProfileCreate("jim.jim@mail.utoronto.ca","123","David1", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "\"Hello, This is David \"", Gender.FEMALE);
        assertEquals("ERR002", rm.getRegMessage());
    }
}