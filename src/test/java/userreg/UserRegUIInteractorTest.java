package userreg;


import User_Register_System.*;
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
        repo.delete("david2@mail.utoronto.ca");
        repo.delete("56789@mail.utoronto.ca");
    }

    @Test
    void testCreateSuccess(){

        // user info

        UserRegUIRequestModel requestModel=new UserRegUIRequestModel("david2@mail.utoronto.ca",
                "david.david","David22", 18,
                174,Gender.MALE,  Hobbies.FOOD,"Computer Science",
                "\"Hello, This is David \"", Gender.FEMALE);
        UserRegUIResponseModel urrm=interactor.create(requestModel);

        assertEquals("SUCCESS",urrm.getRegMessage());
    }

    @Test
    void testCreateEmailInvalid() {
        // user info
        UserRegUIRequestModel requestModel=new UserRegUIRequestModel("56789@mail2.utoronto.ca",
                "david.david","David22", 18,
                174,Gender.MALE,  Hobbies.FOOD,"Computer Science",
                "\"Hello, This is David \"", Gender.FEMALE);
        UserRegUIResponseModel urrm=interactor.create(requestModel);

        assertEquals("ERR001",urrm.getRegMessage());
    }

    @Test
    void testCreateEmailExisted() {


        // user info
        UserRegUIRequestModel requestModel=new UserRegUIRequestModel("56789@mail.utoronto.ca",
                "david.david","David22", 18,
                174,Gender.MALE,  Hobbies.FOOD,"Computer Science",
                "\"Hello, This is David \"", Gender.FEMALE);
        UserRegUIResponseModel urrm0=interactor.create(requestModel);
        UserRegUIResponseModel urrm=interactor.create(requestModel);

        assertEquals("ERR002",urrm.getRegMessage());
    }




}