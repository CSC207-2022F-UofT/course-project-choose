import controller_presenter.BigController;
import controller_presenter.BigPresenter;
import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import email_request.*;
import login_management_system.*;
import matching_system.*;
import upgrade.UpgradeController;
import upgrade.UpgradeManager;
import upgrade.UpgradeOutputBoundary;
import upgrade.UpgradePresenter;
import user_register_system.*;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // Create the parts to plug into the Use Case+Entities engine
        UserRepoManager users;
        try{
            File csvFile = new File("src/main/resources/matchingSystemTest.csv");
            users = new UserRepo(csvFile);
        }catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }

        // Create the big presenter for all UI pages
        MatchOutputBoundary matchUIPresenter = new MatchUIPresenter();
        EmailConnOutputBoundary emailConnPresenter = new EmailConnPresenter();
        UpgradeOutputBoundary upgradePresenter = new UpgradePresenter();
        LoginOutputBoundary loginPresenter = new LoginPresenter();
        UserRegUIOutputBoundary userRegUIPresenter = new UserRegUIPresenter();
        BigPresenter presenters = new BigPresenter(userRegUIPresenter, loginPresenter, matchUIPresenter,
                emailConnPresenter,
                upgradePresenter);

        // Create the big controller for all UI pages.
        // need to fix the logic in matching results
        MatchManager matchManager = new MatchManager(presenters.getMatchUIPresenter(), users);
        MatchController matchController = new MatchController(matchManager);

        UpgradeManager upgradeManager = new UpgradeManager(users, presenters.getUpgradePresenter());
        UpgradeController upgradeController = new UpgradeController(upgradeManager);

        EmailConnInputBoundary interactor = new EmailConnInteractor(presenters.getEmailConnPresenter(),
                users);
        EmailConnController emailConnController = new EmailConnController(interactor);

        // create log-in controller
        LoginInputBoundary loginInputBoundary = new LoginInteractor(users,loginPresenter);
        LoginController loginController = new LoginController(loginInputBoundary);

        // create user registration controller
        UserRegUIInputBoundary userRegUIInteractor = new UserRegUIInteractor(userRegUIPresenter, users);
        UserRegUIController userRegUIController = new UserRegUIController(userRegUIInteractor);


        BigController controllers = new BigController(userRegUIController,
                loginController, matchController,
                emailConnController, upgradeController);

        LoginUI loginUI = new LoginUI(controllers,presenters);
        loginUI.setVisible(true);
    }
}
