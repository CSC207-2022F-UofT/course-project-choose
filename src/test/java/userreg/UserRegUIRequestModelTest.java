package userreg;

import entities.Gender;
import entities.Hobbies;
import entities.User;
import entities.UserAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class UserRegUIRequestModelTest {

    private UserRegUIRequestModel userRegUIRequestModel;

    @BeforeEach
    void setUp(){

        User user = new User("David22", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "\"Hello, This is David \"", Gender.FEMALE);
        UserAccount userAccount = new UserAccount("343567@mail.utoronto.ca",
                "david.david", user);
        userRegUIRequestModel = new UserRegUIRequestModel(userAccount);
    }

    @Test
    void getUserAccount() {

        User user = new User("David22", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "\"Hello, This is David \"", Gender.FEMALE);
        UserAccount userAccount = new UserAccount("343567@mail.utoronto.ca",
                "david.david", user);
        assertEquals(userRegUIRequestModel.getUserAccout().getEmail(), userAccount.getEmail());
        assertEquals(userRegUIRequestModel.getUserAccout().getPassword(), userAccount.getPassword());
        assertEquals(userRegUIRequestModel.getUserAccout().getUser().getName(), userAccount.getUser().getName());
        assertEquals(userRegUIRequestModel.getUserAccout().getUser().getAge(), userAccount.getUser().getAge());
        assertEquals(userRegUIRequestModel.getUserAccout().getUser().getHeight(), userAccount.getUser().getHeight(),5.96e-08);
        assertEquals(userRegUIRequestModel.getUserAccout().getUser().getHobby(), userAccount.getUser().getHobby());
        assertEquals(userRegUIRequestModel.getUserAccout().getUser().getGender(), userAccount.getUser().getGender());
        assertEquals(userRegUIRequestModel.getUserAccout().getUser().getInterestedIn(), userAccount.getUser().getInterestedIn());
        assertEquals(userRegUIRequestModel.getUserAccout().getUser().getSelfIntro(), userAccount.getUser().getSelfIntro());
        assertEquals(userRegUIRequestModel.getUserAccout().getUser().getProgramOfStudy(), userAccount.getUser().getProgramOfStudy());






    }


}