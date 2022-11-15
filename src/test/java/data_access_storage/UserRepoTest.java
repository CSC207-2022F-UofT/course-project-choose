package data_access_storage;

import entities.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;

class UserRepoTest {

    private static RequestModel rqA;
    private static RequestModel rqB;

    private static File emptyCsvFile;
    private static File csvFile;

    private static UserRepo userRepoEmpty;
    private static UserRepo userRepo;

    @BeforeAll
    static void setUp() throws IOException {
        emptyCsvFile = new File("src/main/resources/emptyTestFile.csv");
        userRepoEmpty = new UserRepo(emptyCsvFile);

        csvFile = new File("src/main/resources/emptyTestFile.csv");


        User userA = new User("Emma", Gender.FEMALE, 18,
                164, "Computer Science", Hobbies.FOOD,
                "\" Hello, This is Emma \"", Gender.MALE);
        UserAccount userAccountA = new UserAccount("emma.emma@mail.utoronto.ca",
                "helloToEmma", userA);

        rqA = new RequestModel(userAccountA);

        User userB = new User("David", Gender.MALE, 18,
                174, "Computer Science", Hobbies.FOOD,
                "\"Hello, This is David \"", Gender.FEMALE);
        UserAccount userAccountB = new UserAccount("david.david@hotmail.com",
                "david.david", userB);
        rqB = new RequestModel(userAccountB);
    }

    @Test
    void testSingleUser(){
        assertFalse(userRepoEmpty.existsByEmail("david.david@hotmail.com"));
        userRepoEmpty.save(rqB);
        assertTrue(userRepoEmpty.existsByEmail("david.david@hotmail.com"));
        userRepoEmpty.delete(rqB);
        assertFalse(userRepoEmpty.existsByEmail("david.david@hotmail.com"));
    }

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

    @Test
    void testGetUserAccount(){
        userRepoEmpty.save(rqB);
        RequestModel rm = userRepoEmpty.getUserAccount("david.david@hotmail.com");
        assertTrue("david.david@hotmail.com".equals(rm.getUserAccount().getEmail()));
        assertTrue("David".equals(rm.getUserAccount().getUser().getName()));
        userRepoEmpty.delete(rqB);
    }

    @Test
    void testGetAllUserAccountEmpty(){
        Map<String, RequestModel> accounts_empty = userRepoEmpty.getAllUserAccount();
        assertEquals(accounts_empty.size(), 0);
    }

    @Test
    void testGetAllUserAccountSize1() {
        userRepoEmpty.save(rqB);
        Map<String, RequestModel> accounts_size1 = userRepoEmpty.getAllUserAccount();
        assertEquals(accounts_size1.size(), 1);
        userRepoEmpty.delete(rqB);
    }
    @Test
    void testGetAllUserAccountSize2() {
        userRepoEmpty.save(rqB);
        userRepoEmpty.save(rqA);
        Map<String, RequestModel> accounts_size2 = userRepoEmpty.getAllUserAccount();
        assertEquals(accounts_size2.size(), 2);
        userRepoEmpty.delete(rqB);
        userRepoEmpty.delete(rqA);
    }

    @Test
    void testNonEmptyCsvFile(){



    }



}