package userreg;

import user_register_system.UserRegUIRequestModel;
import entities.Gender;
import entities.Hobbies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class UserRegUIRequestModelTest {

    private UserRegUIRequestModel userRegUIRequestModel;

    @BeforeEach
    void setUp(){

        userRegUIRequestModel = new UserRegUIRequestModel("343567@mail.utoronto.ca",
                "david.david","David22", 18,174,Gender.MALE,Hobbies.FOOD,
                "Computer Science",
                "Hello, This is David",Gender.FEMALE);
    }

    @Test
    void testModel() {


        Assertions.assertEquals(userRegUIRequestModel.getEmail(), "343567@mail.utoronto.ca");
        Assertions.assertEquals(userRegUIRequestModel.getPassword(), "david.david");
        Assertions.assertEquals(userRegUIRequestModel.getName(), "David22");
        Assertions.assertEquals(userRegUIRequestModel.getAge(), 18);
        Assertions.assertEquals(userRegUIRequestModel.getHeight(), 174, 5.96e-08);
        Assertions.assertEquals(userRegUIRequestModel.getHobbies(), Hobbies.FOOD);
        Assertions.assertEquals(userRegUIRequestModel.getProgramOfStudy(), "Computer Science");
        Assertions.assertEquals(userRegUIRequestModel.getSelfIntro(), "Hello, This is David");
        Assertions.assertEquals(userRegUIRequestModel.getGender(), Gender.MALE);
        Assertions.assertEquals(userRegUIRequestModel.getInterestedIn(), Gender.FEMALE);

    }


}