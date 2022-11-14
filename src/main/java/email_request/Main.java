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
            File csvFile = new File("src/main/resources/testFile.csv");
            users = new UserRepo(csvFile);
        }catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }

        ConnViaEmailOutputBoundary presenter = new ConnViaEmailPresenter();
        ProfileViewUIInputBoundary interactor = new ConnViaEmailInteractor(presenter, users);
        ProfileViewUIController profileViewUIController = new ProfileViewUIController(interactor);

        UITemplate uiTemplate = new UITemplate(profileViewUIController, "david.david@hotmail.com",
                "emma.emma@mail.utoronto.ca");
        screens.add(uiTemplate, "profile page");
        cardLayout.show(screens, "profile");
        application.pack();
        application.setVisible(true);

    }


}
