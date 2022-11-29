package email_request;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // Build the main program window
        JFrame application = new JFrame("View a user's profile page");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);
        UserRepoManager users;

        try{
            File csvFile = new File("src/main/resources/ConnViaEmail.csv");
            users = new UserRepo(csvFile);
        }catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }

        MatcherUIOutputBoundary presenter = new MatcherUIPresenter();
        MatcherUIInputBoundary interactor = new MatcherUIInteractor(presenter, users);
        MatcherUIController matcherUIController = new MatcherUIController(interactor);

        MatcherUITemplate matcherUiTemplate = new MatcherUITemplate(matcherUIController, "david.david@hotmail.com",
                "emma.emma@mail.utoronto.ca");
        screens.add(matcherUiTemplate, "profile page");
        cardLayout.show(screens, "profile");
        application.pack();
        application.setVisible(true);
    }


}
