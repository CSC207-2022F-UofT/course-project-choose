package data_access_storage;

import entities.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * This class test methods in UserRepo.
 */
class UserRepoTest {

    private static RequestModel rqA;
    private static RequestModel rqB;

    /** a csv file that contains user data */
    private static File csvFile;

    /** a UserRepo that is associated with the empty csv file emptyCsvFile. */
    private static UserRepo userRepoEmpty;

    /** a UserRepo that is associated with the csv file csvFile. */
    private static UserRepo userRepo;

    /** Set up emptyCsvFile, userRepoEmpty, request models rqA, and rqB before running any tests. */
    @BeforeAll
    static void setUp() throws IOException {
        // a csv file that's empty and contains no user data
        File emptyCsvFile = new File("src/main/resources/emptyTestFile.csv");
        // set up User Repo userRepoEmpty where its associated csv file is empty.
        userRepoEmpty = new UserRepo(emptyCsvFile);
        // first user data
        User userA = new User("Emma", Gender.FEMALE, 18,
                164, "Computer Science", Hobbies.FOOD,
                "\" Hello, This is Emma \"", Gender.MALE);
        UserAccount userAccountA = new UserAccount("emma.emma@mail.utoronto.ca",
                "helloToEmma", userA);

        rqA = new RequestModel(userAccountA);

        // second user data
        User userB = new User("David", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "\"Hello, This is David \"", Gender.FEMALE);
        UserAccount userAccountB = new UserAccount("david.david@hotmail.com",
                "david.david", userB);
        rqB = new RequestModel(userAccountB);

        // set up User Repo userRepo where its associated csv file has data for two users.
        csvFile = new File("src/main/resources/testFile.csv");
        userRepo = new UserRepo(csvFile);
    }

    /**
     * Test the methods existsByEmail(Sting email), save() and delete() simultaneously with a single user data.
     * 1. Start with an empty csv file, and test to confirm the user associated with the request model rqB does not exist.
     * 2. Save the request model rqB to emptyCsvFile, and test to confirm the user associated with
     * the request model rqB exists.
     * 3. Delete the request model rqB from emptyCsvFile, and test to confirm the user associated
     * with the request model rqB does not exist
     */
    @Test
    void testSingleUser(){
        assertFalse(userRepoEmpty.existsByEmail("david.david@hotmail.com"));
        userRepoEmpty.save(rqB);
        assertTrue(userRepoEmpty.existsByEmail("david.david@hotmail.com"));
        userRepoEmpty.delete(rqB);
        assertFalse(userRepoEmpty.existsByEmail("david.david@hotmail.com"));
    }

    /**
     * Test the methods existsByEmail(Sting email), save() and delete() simultaneously with multiple user data.
     * 1. Start with an empty csv file, and test to confirm the users associated with the request model rqB and rqA
     * do not exist.
     * 2. Save the request model rqB and rqA to emptyCsvFile, and test to confirm the users associated with
     * the request model rqB and rqA exist.
     * 3. Delete the request model rqB and rqA from emptyCsvFile, and test to confirm the users associated
     * with the request model rqB and rqA do not exist.
     */

    @Test
    void testMultiUser(){
        assertFalse(userRepoEmpty.existsByEmail("david.david@hotmail.com"));
        assertFalse(userRepoEmpty.existsByEmail("emma.emma@mail.utoronto.ca"));
        userRepoEmpty.save(rqB);
        userRepoEmpty.save(rqA);
        assertTrue(userRepoEmpty.existsByEmail("david.david@hotmail.com"));
        assertTrue(userRepoEmpty.existsByEmail("emma.emma@mail.utoronto.ca"));
        userRepoEmpty.delete(rqA);
        userRepoEmpty.delete(rqB);
        assertFalse(userRepoEmpty.existsByEmail("david.david@hotmail.com"));
        assertFalse(userRepoEmpty.existsByEmail("emma.emma@mail.utoronto.ca"));
    }

    /**
     * Test to confirm that GetUserAccount returns the correct request model.
     */
    @Test
    void testGetUserAccount(){
        userRepoEmpty.save(rqB);
        RequestModel rm = userRepoEmpty.getUserAccount("david.david@hotmail.com");
        assertEquals("david.david@hotmail.com", rm.getUserAccount().getEmail());
        assertEquals("David", rm.getUserAccount().getUser().getName());
        userRepoEmpty.delete(rqB);
    }

    /**
     * Test to make sure that getAllUserAccount returns all user data when the csv file is empty.
     */
    @Test
    void testGetAllUserAccountEmpty(){
        Map<String, RequestModel> accounts_empty = userRepoEmpty.getAllUserAccount();
        assertEquals(accounts_empty.size(), 0);
    }

    /**
     * Test to make sure that getAllUserAccount returns all user data when the csv file has data for one user.
     */
    @Test
    void testGetAllUserAccountSize1() {
        userRepoEmpty.save(rqB);
        Map<String, RequestModel> accounts_size1 = userRepoEmpty.getAllUserAccount();
        assertEquals(accounts_size1.size(), 1);
        userRepoEmpty.delete(rqB);
    }

    /**
     * Test to make sure that getAllUserAccount returns all user data when the csv file has data for two users.
     */
    @Test
    void testGetAllUserAccountSize2() {
        userRepoEmpty.save(rqB);
        userRepoEmpty.save(rqA);
        Map<String, RequestModel> accounts_size2 = userRepoEmpty.getAllUserAccount();
        assertEquals(accounts_size2.size(), 2);
        userRepoEmpty.delete(rqB);
        userRepoEmpty.delete(rqA);
    }

    /**
     * Test to make sure that getAllUserAccount returns all user data when the csv file starts with data for two users.
     */
    @Test
    void testNonEmptyCsvFile() {
        Map<String, RequestModel> accounts = userRepo.getAllUserAccount();
        assertEquals(accounts.size(), 2);
    }

    /**
     * Test to make sure when the csv file does not exist, an exception is thrown.
     */
    @Test
    public void testException(){
        assertThrows(RuntimeException.class, () -> {
            csvFile = new File("src/main/resources/exceptionFile.csv");
            userRepo = new UserRepo(csvFile);
        });
    }

    /**
     * Test to make sure DeleteByEmail deletes a user by his/her email address properly.
     * @throws IOException IOException is thrown when the specified csv file does not exist.
     */
    @Test
    public void testDeleteByEmail() throws IOException {
        userRepoEmpty.save(rqB);
        assertTrue(userRepoEmpty.existsByEmail("david.david@hotmail.com"));
        userRepoEmpty.delete("david.david@hotmail.com");
        assertFalse(userRepoEmpty.existsByEmail("david.david@hotmail.com"));

        File csvFileReal = new File("src/main/resources/emptyTestFile.csv");
        UserRepo userRepoFile = new UserRepo(csvFileReal);
        assertFalse(userRepoFile.existsByEmail("david.david@hotmail.com"));
    }

    /**
     * Test to make sure Update() updates a user data properly.
     * The user Emma's original age is 18, and is updated to 20.
     */
    @Test
    public void testUpdate() {
        userRepoEmpty.save(rqA);

        User userC = new User("Emma", Gender.FEMALE, 20,
                164, "Computer Science", Hobbies.FOOD,
                "\" Hello, This is Emma \"", Gender.MALE);
        UserAccount userAccountC = new UserAccount("emma.emma@mail.utoronto.ca",
                "helloToEmma", userC);
        RequestModel rqC = new RequestModel(userAccountC);

        userRepoEmpty.update("emma.emma@mail.utoronto.ca", rqC);

        assertEquals(20,
                userRepoEmpty.getUserAccount("emma.emma@mail.utoronto.ca").getUserAccount().getUser().getAge());

        userRepoEmpty.delete(rqC);
    }
}