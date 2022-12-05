package matching_system;

import controller_presenter.BigPresenter;
import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import email_request.EmailConnOutputBoundary;
import email_request.EmailConnPresenter;
import login_management_system.LoginOutputBoundary;
import login_management_system.LoginPresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import upgrade.UpgradeOutputBoundary;
import upgrade.UpgradePresenter;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MatchControllerTest {
    MatchManager matchManager;
    MatchOutputBoundary presenter;
    MatchRequestModel matchRequestModel;
    UserRepoManager repoManager;
    MatchController matchController;

    /** Setup basic codes for all future tests*/
    @BeforeEach
    void setUp() throws IOException {
        File csvFile = new File("src/main/resources/matchingSystemTest.csv");
        repoManager = new UserRepo(csvFile);
        matchRequestModel = new MatchRequestModel("a@mail.utoronto.ca");
        presenter = new MatchUIPresenter();
        matchManager = new MatchManager(presenter, repoManager);
        matchController = new MatchController(matchManager);
    }

    /** Test whether Create method works as intended*/
    @Test
    public void testControllerCreate(){
        MatchResponseModel matchResponseModel = matchController.create(matchRequestModel.getUserEmail());
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
