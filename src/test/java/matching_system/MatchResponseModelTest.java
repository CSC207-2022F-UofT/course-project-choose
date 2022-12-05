//package matching_system;
//
//import data_access_storage.UserRepo;
//import data_access_storage.UserRepoManager;
//import entities.UserAccount;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class MatchResponseModelTest {
//
//    MatchManager matchManager;
//    MatchOutputBoundary presenter;
//    MatchRequestModel matchRequestModel;
//    UserRepoManager repoManager;
//    private ArrayList<UserAccount> targets = new ArrayList<UserAccount>();
//
//    /** Setup basic codes for all future tests*/
//    @BeforeEach
//    void setUp() throws IOException {
//        File csvFile = new File("src/main/resources/matchingSystemTest.csv");
//        repoManager = new UserRepo(csvFile);
//        matchRequestModel = new MatchRequestModel("a@mail.utoronto.ca");
//        presenter = new MatchUIPresenter();
//        matchManager = new MatchManager(presenter,matchRequestModel, repoManager);
//    }
//
//    /** Test whether getRequesterEmail work as intended*/
//    @Test
//    public void testResponseModelGetEmail(){
//        MatchResponseModel matchResponseModel = matchManager.create(matchRequestModel);
//        assertEquals("a@mail.utoronto.ca",matchResponseModel.getRequesterEmail());
//    }
//}
