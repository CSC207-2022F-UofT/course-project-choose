package data_access_storage;

import entities.Gender;
import entities.Hobbies;
import entities.User;
import entities.UserAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestModelTest {

    private RequestModel rm;

    @BeforeEach
    public void setUp() {
        User userA = new User("Emma", Gender.FEMALE, 18,
                164, "Computer Science", Hobbies.FOOD,
                "\" Hello, This is Emma \"", Gender.MALE);
        UserAccount userAccountA = new UserAccount("emma.emma@mail.utoronto.ca",
                "helloToEmma", userA);
       rm = new RequestModel(userAccountA);
    }

    @Test
    void testGetUserAccount() {
        UserAccount user = rm.getUserAccount();
        assertTrue("emma.emma@mail.utoronto.ca".equals(user.getEmail()));
        assertTrue("Emma".equals(user.getUser().getName()));
    }


}