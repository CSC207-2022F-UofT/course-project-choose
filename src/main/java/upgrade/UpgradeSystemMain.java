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
        MatchRequestModel matchRequestModel = new MatchRequestModel("a@mail.utoronto.ca");
        MatchUIPresenter presenter = new MatchUIPresenter();
        MatchManager matchManager = new MatchManager(presenter,matchRequestModel, users);


        MatcherUIOutputBoundary presenter1 = new MatcherUIPresenter();
        MatcherUIInputBoundary interactor = new MatcherUIInteractor(presenter1, users);
        MatcherUIController matcherUIController = new MatcherUIController(interactor);

        MatcherUITemplateJames matcherUiTemplate = new MatcherUITemplateJames(matcherUIController,
                currentEmail,
                presenter);

        UpgradePresenter upgradePresenter = new UpgradePresenter(currentEmail);
        UpgradeManager upgradeManager = new UpgradeManager(users, upgradePresenter);
        UpgradeController upgradeController = new UpgradeController(upgradeManager);
        UpgradeUI upgradeUI = new UpgradeUI(currentEmail, upgradeController, upgradePresenter);
        matcherUiTemplate.addUpgradeFrame(upgradeUI);

        application.add(matcherUiTemplate);
        application.pack();
        application.setVisible(true);
    }

}
