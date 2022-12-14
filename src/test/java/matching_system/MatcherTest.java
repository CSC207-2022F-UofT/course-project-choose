package matching_system;

import data_access_storage.RequestModel;
import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import entities.Matcher;
import entities.UserAccount;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MatcherTest {
    private UserAccount matchee;
    private ArrayList<UserAccount> targets = new ArrayList<>();
    /** Setup basic codes for all future tests*/
    @BeforeEach
    void setUp() throws IOException {
        File csvFile = new File("src/main/resources/matchingSystemTest.csv");
        UserRepoManager repoManager = new UserRepo(csvFile);
        matchee = repoManager.getUserAccount("a@mail.utoronto.ca").getUserAccount();
        for(RequestModel requestModel:repoManager.getAllUserAccount().values()){
            targets.add(requestModel.getUserAccount());
        }
    }
    /** Test whether the return size from Matcher is correct*/
    @Test
    public void testReturnSize(){
        Matcher matcher = new Matcher(matchee, targets);
        assertEquals(5,matcher.getMatches().length);
    }
    /** Test whether the content returned from Matcher is correct*/
    @Test
    public void testCorrectness(){
        Matcher matcher = new Matcher(matchee, targets);
        ArrayList<String> names = new ArrayList<>();
        for(UserAccount userAccount:matcher.getMatches()){
            names.add(userAccount.getUser().getName());
        }
        assertTrue(names.contains("b")&&names.contains("c")
                &&names.contains("d")&&names.contains("e"));
        assertTrue(names.contains("f") | names.contains("Terry"));
    }
}
