package upgrade;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import email_request.*;
import matching_system.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class UpgradeSystemMain {

    public static void main(String[] args) {

        // Build the main program window, link UpgradeUI and MatcherUI
        String currentEmail = "terry.tan@mail.utoronto.ca";
        JFrame application = new JFrame("Matching results");

        // Create the parts to plug into the Use Case+Entities engine
        UserRepoManager users;
        try{
            File csvFile = new File("src/main/resources/matchingSystemTest.csv");
            users = new UserRepo(csvFile);
        }catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }

        // create match results
        MatchRequestModel matchRequestModel = new MatchRequestModel(currentEmail);
        MatchUIPresenter presenter = new MatchUIPresenter();
        MatchManager matchManager = new MatchManager(presenter,matchRequestModel, users);

        // create controller for email requesting
        EmailConnOutputBoundary emailConnPresenter = new EmailConnPresenter();
        EmailConnInputBoundary interactor = new EmailConnInteractor(emailConnPresenter, users);
        EmailConnController emailConnController = new EmailConnController(interactor);

        // create upgrade controller
        UpgradePresenter upgradePresenter = new UpgradePresenter(currentEmail);
        UpgradeManager upgradeManager = new UpgradeManager(users, upgradePresenter);
        UpgradeController upgradeController = new UpgradeController(upgradeManager);

        // create the view for matching results
        MatchResultsUI matcherResultsUI = new MatchResultsUI(emailConnController,
                upgradeController,
                currentEmail, presenter);

        application.add(matcherResultsUI);
        application.pack();
        application.setVisible(true);
    }

}
