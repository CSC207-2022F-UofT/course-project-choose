package data_access_storage;

import entities.Gender;
import entities.Hobbies;
import entities.User;
import entities.UserAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class test methods in RequestModel.
 */
class RequestModelTest {

    private RequestModel rm;

    /**
     * Set up the request model for each test.
     * The request model contains user account information of a user whose name is Emma.
     */
    @BeforeEach
    public void setUp() {
        User userA = new User("Emma", Gender.FEMALE, 18,
                164, "Computer Science", Hobbies.FOOD,
                "\" Hello, This is Emma \"", Gender.MALE);
        UserAccount userAccountA = new UserAccount("emma.emma@mail.utoronto.ca",
                "helloToEmma", userA);
       rm = new RequestModel(userAccountA);
    }

    /**
     * Test to check GetUserAccount returns the user account information of Emma.
     */
    @Test
    void testGetUserAccount() {
        UserAccount user = rm.getUserAccount();
        assertEquals("emma.emma@mail.utoronto.ca", user.getEmail());
        assertEquals("Emma", user.getUser().getName());
    }


}