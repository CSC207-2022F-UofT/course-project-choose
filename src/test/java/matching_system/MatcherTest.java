package matching_system;

import data_access_storage.RequestModel;
import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import email_request.MatcherUIInteractor;
import email_request.MatcherUIOutputBoundary;
import email_request.MatcherUIPresenter;
import entities.Matcher;
import entities.User;
import entities.UserAccount;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MatcherTest {
    private UserAccount matchee;
    private ArrayList<UserAccount> targets = new ArrayList<UserAccount>();
    @BeforeEach
    void setUp() throws IOException {
        File csvFile = new File("src/main/resources/matchingSystemTest.csv");
        UserRepoManager repoManager = new UserRepo(csvFile);
        matchee = repoManager.getUserAccount("a@mail.utoronto.ca").getUserAccount();
        for(RequestModel requestModel:repoManager.getAllUserAccount().values()){
            targets.add(requestModel.getUserAccount());
        }
    }
    @Test
    public void testReturnSize(){
        Matcher matcher = new Matcher(matchee, targets);
        assertEquals(5,matcher.getMatches().length);
    }

    @Test
    public void testCorrectness(){
        Matcher matcher = new Matcher(matchee, targets);
        ArrayList<String> names = new ArrayList<String>();
        for(UserAccount userAccount:matcher.getMatches()){
            names.add(userAccount.getUser().getName());
        }
        assertTrue(names.contains("b")&&names.contains("c")
                &&names.contains("d")&&names.contains("e")&&names.contains("f"));
    }
}
