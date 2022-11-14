package data_access_storage;

import email_request.RequestModel;
import entities.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserRepoTest {

    private static RequestModel rqA;
    private static RequestModel rqB;

    private static File csvFile;

    private static UserRepo userRepo;

    @BeforeAll
    static void setUp() throws IOException {
        csvFile = new File("src/main/resources/testFile.csv");
        userRepo = new UserRepo(csvFile);

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
        assertFalse(userRepo.existsByEmail("david.david@hotmail.com"));
        userRepo.save(rqB);
        assertTrue(userRepo.existsByEmail("david.david@hotmail.com"));
        userRepo.delete(rqB);
        assertFalse(userRepo.existsByEmail("david.david@hotmail.com"));
    }

    @Test
    void testMultiUser(){
        assertFalse(userRepo.existsByEmail("david.david@hotmail.com"));
        assertFalse(userRepo.existsByEmail("emma.emma@mail.utoronto.ca"));
        userRepo.save(rqB);
        userRepo.save(rqA);
        assertTrue(userRepo.existsByEmail("david.david@hotmail.com"));
        assertTrue(userRepo.existsByEmail("emma.emma@mail.utoronto.ca"));
        userRepo.delete(rqA);
        userRepo.delete(rqB);
        assertFalse(userRepo.existsByEmail("david.david@hotmail.com"));
        assertFalse(userRepo.existsByEmail("emma.emma@mail.utoronto.ca"));
    }









}