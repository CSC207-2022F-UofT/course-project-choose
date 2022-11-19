package matching_system;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import email_request.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class MatchingSystemMain {
    public static void main(String[] args) {

        // Build the main program window
        JFrame application = new JFrame("View a user's profile page");


        UserRepoManager users;
        try{
            File csvFile = new File("src/main/resources/matchingSystemTest.csv");
            users = new UserRepo(csvFile);
        }catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        MatchRequestModel matchRequestModel = new MatchRequestModel("a@mail.utoronto.ca");
        MatchOutputBoundary presenter = new MatchUIPresenter();
        MatchManager matchManager = new MatchManager(presenter,matchRequestModel, users);
        MatcherUIOutputBoundary presenter1 = new MatcherUIPresenter();
//        UserData[] results = matchManager.create(matchRequestModel).getMatchedData();
//        for (UserData result: results){
//            System.out.println(result.name);
//        }
//        System.out.println(results);
        MatcherUIInputBoundary interactor = new MatcherUIInteractor(presenter1, users);
        MatcherUIController matcherUIController = new MatcherUIController(interactor);

        MatcherUITemplate matcherUiTemplate = new MatcherUITemplate(matcherUIController, "david.david@hotmail.com",
                "emma.emma@mail.utoronto.ca", matchManager.create(matchRequestModel));
        application.add(matcherUiTemplate);
//        application.setLayout(new BoxLayout(application, BoxLayout.Y_AXIS));
        application.pack();
        application.setVisible(true);
    }
}
