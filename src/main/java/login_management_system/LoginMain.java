package login_management_system;

import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class LoginMain {
    public static void main(String[] args) {
        JFrame application = new JFrame("login");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);
        UserRepoManager userGatewayImp;

        try {
            File csvFile = new File("src/main/resources/matchingSystemTest.csv");
            userGatewayImp = new UserRepo(csvFile);
        } catch (IOException ex) {
            throw new RuntimeException("Could not create file.");
        }
        LoginOutputBoundary outputBoundary = new LoginPresenter();
        LoginInputBoundary interactor = new LoginInteractor(userGatewayImp, outputBoundary);
        LoginController LoginController = new LoginController(interactor);

        LoginUI loginUI = new LoginUI(LoginController);
        screens.add(loginUI, "login");
        cardLayout.show(screens, "login");
        application.pack();
        application.setVisible(true);
    }
}
