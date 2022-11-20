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
        JFrame application = new JFrame("Matching results");

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

        // create Controller
        MatcherUIOutputBoundary presenter1 = new MatcherUIPresenter();
        MatcherUIInputBoundary interactor = new MatcherUIInteractor(presenter1, users);
        MatcherUIController matcherUIController = new MatcherUIController(interactor);

        MatcherUITemplateJames matcherUiTemplate = new MatcherUITemplateJames(matcherUIController,
                "j@mail.utoronto.ca",
                matchManager.create(matchRequestModel));
        application.add(matcherUiTemplate);
        application.pack();
        application.setVisible(true);
    }
}