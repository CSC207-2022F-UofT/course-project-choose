package entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserAccountTest {

    private static UserAccount userAccountA;
    private static UserAccount userAccountB;

    @BeforeAll
    static void setUp(){
        User userA = new User("Emma", Gender.FEMALE, 18,
                164, "Computer Science", Hobbies.FOOD,
                "Hello, This is Emma", Gender.MALE);
        userAccountA = new UserAccount("emma.emma@mail.utoronto.ca",
                "helloToEmma", userA);

        User userB = new User("David", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "Hello, This is Emma", Gender.FEMALE);
       userAccountB = new UserAccount("david.david@hotmail.com",
                "david.david", userB);
    }

    @Test
    void getEmail() {
       String email = userAccountA.getEmail();
       assertEquals(email, "emma.emma@mail.utoronto.ca");
    }

    @Test
    void isReported() {
        assertEquals(userAccountA.getNumOfReport(), 0);
        userAccountA.isReported();
        assertEquals(userAccountA.getNumOfReport(), 1);
    }

    @Test
    void block() {
        assertEquals(userAccountA.getBlockedAccounts().size(), 0);
        userAccountA.block(userAccountB);
        assertEquals(userAccountA.getBlockedAccounts().size(), 1);
    }

    @Test
    void subscribe() {
        assertFalse(userAccountA.getSubStatus());
        userAccountA.subscribe();
        assertTrue(userAccountA.getSubStatus());
    }

    @Test
    void setValidEmail() {
        assertFalse(userAccountA.getValidEmail());
        userAccountA.setValidEmail();
        assertTrue(userAccountA.getValidEmail());
    }
}