package matching_system;


import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MatchManagerTest {
    MatchManager matchManager;
    MatchOutputBoundary presenter;
    MatchRequestModel matchRequestModel;
    UserRepoManager repoManager;
    /** Setup basic codes for all future tests*/
    @BeforeEach
    void setUp() throws IOException {
        File csvFile = new File("src/main/resources/matchingSystemTest.csv");
        repoManager = new UserRepo(csvFile);
        matchRequestModel = new MatchRequestModel("a@mail.utoronto.ca");
        presenter = new MatchUIPresenter();
        matchManager = new MatchManager(presenter, repoManager);
    }
    /** Test whether Create method works as intended*/
    @Test
    public void testCreate(){
        MatchResponseModel matchResponseModel = matchManager.create(matchRequestModel);
        ArrayList<String> names = new ArrayList<>();
        for(UserData userData:matchResponseModel.getMatchedData()){
            names.add(userData.name);
        }
        assertEquals(5, matchManager.create(matchRequestModel).getMatchedData().length);
        assertTrue(names.contains("b")&&names.contains("c")
                &&names.contains("d")&&names.contains("e"));
        assertTrue(names.contains("f") | names.contains("Terry"));
    }

}
