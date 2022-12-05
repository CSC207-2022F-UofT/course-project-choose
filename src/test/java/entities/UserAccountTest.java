package entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests methods in UserAccount.
 */
public class UserAccountTest {

    private static UserAccount userAccountA;
    private static UserAccount userAccountB;

    /** Set up two user accounts userAccountA and userAccountB before running any tests. */
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

    /**
     * Test to make sure getEmail returns the desired email address.
     */
    @Test
    void testGetEmail() {
       String email = userAccountA.getEmail();
       assertEquals(email, "emma.emma@mail.utoronto.ca");
    }

    /**
     * Test to make sure calling isReported increases a user's number of report by 1.
     */
    @Test
    void testIsReported() {
        assertEquals(userAccountA.getNumOfReport(), 0);
        userAccountA.isReported();
        assertEquals(userAccountA.getNumOfReport(), 1);
    }

    /**
     * test to make sure that the block method adds the blocked user to blockedAccounts.
     */
    @Test
    void testBlock() {
        assertEquals(userAccountA.getBlockedAccounts().size(), 0);
        userAccountA.block(userAccountB.getEmail());
        assertEquals(userAccountA.getBlockedAccounts().size(), 1);
        userAccountA.getBlockedAccounts().remove(0);
    }

    /**
     * test to make sure that getBlockedAccounts returns all email addresses in blockedAccounts.
     */
    @Test
    void testGetBlockedAccounts(){
        assertEquals(userAccountA.getBlockedAccounts().size(), 0);
        userAccountA.block(userAccountB.getEmail());
        List<String> blockedList = userAccountA.getBlockedAccounts();
        assertEquals("david.david@hotmail.com", blockedList.get(0));
        userAccountA.getBlockedAccounts().remove(0);
    }

    /**
     * Test to make sure that subscribe() changes a user's subscription status from false to true.
     */
    @Test
    void testSubscribe() {
        assertFalse(userAccountA.getSubStatus());
        userAccountA.subscribe();
        assertTrue(userAccountA.getSubStatus());
    }

    /**
     * Test to make sure that setValidEmail changes a user's email validation status from false to true.
     */
    @Test
    void testSetValidEmail() {
        assertFalse(userAccountA.getValidEmail());
        userAccountA.setValidEmail();
        assertTrue(userAccountA.getValidEmail());
    }

    /**
     * Test to make sure that incNumOfEmailRequest increases the number of email requests by 1.
     */
    @Test
    void testIncNumOfEmailRequest(){
        assertEquals(userAccountA.getNumOfEmailRequest(), 0);
        userAccountA.incNumOfEmailRequest();
        assertEquals(userAccountA.getNumOfEmailRequest(), 1);
    }

    /**
     * Test to make sure that getPassword returns the correct password.
     */
    @Test
    void testGetPassword(){
        assertEquals("helloToEmma", userAccountA.getPassword());
    }

    /**
     * Test to make sure that getUser returns the correct user object.
     */
    @Test
    void testGetUser(){
        assertEquals("Emma", userAccountA.getUser().getName());
    }

    /**
     * Test to make sure that seeRequestedEmail returns false with a free male user who requests more than the
     * maximum number of email requests.
     */
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

    /**
     * Test to make sure that seeRequestedEmail returns true with a free male user whose number of email
     * requests is equal to the maximum number of email requests.
     */
    @Test
    void testFreeMaleEmailRequestSuccess(){
        User userC = new User("Jimmy", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "Hello, This is Jimmy", Gender.FEMALE);
        List<String> blockedAccountsC = new ArrayList<>();
        UserAccount userAccountC = new UserAccount("jimmy.jimmy@hotmail.com",
                "jimmy.jimmy", userC, true, false,
                0, blockedAccountsC,4);
        assertTrue(userAccountC.seeRequestedEmail());
    }

    /**
     * Test to make sure seeRequestedEmail returns true with a female user.
     */
    @Test
    void testFemaleRequestEmail(){
        assertTrue(userAccountA.seeRequestedEmail());
    }

    /**
     * Test to make sure seeRequestedEmail returns true with a paid male user, even his number of email requests is
     * more than the maximum limit.
     */
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

    /**
     * Test to make sure seeRequestedEmail returns true with a paid male user, even his number of email requests is
     * a lot.
     */
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