package userreg;


import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import entities.Gender;
import entities.Hobbies;
import entities.User;
import entities.UserAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import userreg.*;

import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class UserRegUIInteractorTest {

    private UserRegUIInteractor interactor;

    @BeforeEach
    void setUp() throws IOException {
        File csvFile = new File("src/main/resources/userReg.csv");
        UserRepoManager repo = new UserRepo(csvFile);
        UserRegUIOutputBoundary output = new UserRegUIPresenter();
        interactor = new UserRegUIInteractor(output, repo);
    }

    @Test
    void testCreateSuccess(){

        // user info
        User user = new User("David22", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "\"Hello, This is David \"", Gender.FEMALE);
        UserAccount userAccount = new UserAccount("56789@mail.utoronto.ca",
                "david.david", user);

        UserRegUIRequestModel requestModel=new UserRegUIRequestModel(userAccount);
        UserRegUIResponseModel urrm=interactor.create(requestModel);

        assertEquals("SUCCESS",urrm.getRegMessage());
    }

    @Test
    void testCreateEmailInvalid() {
        // user info
        User user = new User("David33", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "\"Hello, This is David \"", Gender.FEMALE);
        UserAccount userAccount = new UserAccount("david.david@hotmail.com",
                "david.david", user);

        UserRegUIRequestModel requestModel=new UserRegUIRequestModel(userAccount);
        UserRegUIResponseModel urrm=interactor.create(requestModel);

        assertEquals("ERR001",urrm.getRegMessage());
    }

    @Test
    void testCreateEmailExisted() {
        // user info
        User user = new User("David34", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "\"Hello, This is David \"", Gender.FEMALE);
        UserAccount userAccount = new UserAccount("34356@mail.utoronto.ca",
                "david.david", user);

        UserRegUIRequestModel requestModel=new UserRegUIRequestModel(userAccount);
        UserRegUIResponseModel urrm=interactor.create(requestModel);

        assertEquals("ERR002",urrm.getRegMessage());
    }




}