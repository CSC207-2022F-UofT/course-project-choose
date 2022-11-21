package entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
       List<String> blockedAccounts = new ArrayList<>();
       userAccountB = new UserAccount("david.david@hotmail.com",
                "david.david", userB, true, true,
               0, blockedAccounts,7);
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
        userAccountA.block(userAccountB.getEmail());
        assertEquals(userAccountA.getBlockedAccounts().size(), 1);
        userAccountA.getBlockedAccounts().remove(0);
    }
    @Test
    void testBlockedAccounts(){
        assertEquals(userAccountA.getBlockedAccounts().size(), 0);
        userAccountA.block(userAccountB.getEmail());
        List<String> blockedList = userAccountA.getBlockedAccounts();
        assertTrue(blockedList.get(0).equals("david.david@hotmail.com"));
        userAccountA.getBlockedAccounts().remove(0);
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

    @Test
    void testIncNumOfEmailRequest(){
        assertEquals(userAccountA.getNumOfEmailRequest(), 0);
        userAccountA.incNumOfEmailRequest();
        assertEquals(userAccountA.getNumOfEmailRequest(), 1);
    }

    @Test
    void testGetPassword(){
        assertTrue(userAccountA.getPassword().equals("helloToEmma"));
    }

    @Test
    void testGetUser(){
        assertTrue(userAccountA.getUser().getName().equals("Emma"));
    }

    @Test
    void testFreeMaleEmailRequestFailure(){
        User userC = new User("Jimmy", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "Hello, This is Jimmy", Gender.FEMALE);
        List<String> blockedAccountsC = new ArrayList<>();
        UserAccount userAccountC = new UserAccount("jimmy.jimmy@hotmail.com",
                "jimmy.jimmy", userC, true, false,
                0, blockedAccountsC,7);
        assertFalse(userAccountC.seeRequestedEmail());
    }

    @Test
    void testFreeMaleEmailRequestSuccess(){
        User userC = new User("Jimmy", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "Hello, This is Jimmy", Gender.FEMALE);
        List<String> blockedAccountsC = new ArrayList<>();
        UserAccount userAccountC = new UserAccount("jimmy.jimmy@hotmail.com",
                "jimmy.jimmy", userC, true, false,
                0, blockedAccountsC,5);
        assertTrue(userAccountC.seeRequestedEmail());
    }

    @Test
    void testFemaleRequestEmail(){
        assertTrue(userAccountA.seeRequestedEmail());
    }

    @Test
    void testPaidMaleEmailRequestSuccess(){
        User userC = new User("Jimmy", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "Hello, This is Jimmy", Gender.FEMALE);
        List<String> blockedAccountsC = new ArrayList<>();
        UserAccount userAccountC = new UserAccount("jimmy.jimmy@hotmail.com",
                "jimmy.jimmy", userC, true, true,
                0, blockedAccountsC,6);
        assertTrue(userAccountC.seeRequestedEmail());
    }

    @Test
    void testPaidMaleEmailRequestSuccessManyRequests(){
        User userC = new User("Jimmy", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "Hello, This is Jimmy", Gender.FEMALE);
        List<String> blockedAccountsC = new ArrayList<>();
        UserAccount userAccountC = new UserAccount("jimmy.jimmy@hotmail.com",
                "jimmy.jimmy", userC, true, true,
                0, blockedAccountsC,100);
        assertTrue(userAccountC.seeRequestedEmail());
    }

}