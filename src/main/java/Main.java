import blocking_reporting_system.blocking_system.BlockedUserController;
import blocking_reporting_system.blocking_system.BlockedUserInteractor;
import blocking_reporting_system.blocking_system.BlockedUserOutputBoundary;
import blocking_reporting_system.blocking_system.BlockedUserPresenter;
import blocking_reporting_system.reporting_system.ReportedUserController;
import blocking_reporting_system.reporting_system.ReportedUserInteractor;
import blocking_reporting_system.reporting_system.ReportedUserOutputBoundary;
import blocking_reporting_system.reporting_system.ReportedUserPresenter;
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

/**
 * This class runs the program.
 */
public class Main {

    public static void main(String[] args) {

        // Create the parts to plug into the program running engine.
        // data access
        UserRepoManager users;
        try{
            File csvFile = new File("src/main/resources/group46_data.csv");
            users = new UserRepo(csvFile);
        }catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }

        // Create presenters for all UI elements and store them in a big presenter
        MatchOutputBoundary matchUIPresenter = new MatchUIPresenter();
        EmailConnOutputBoundary emailConnPresenter = new EmailConnPresenter();
        UpgradeOutputBoundary upgradePresenter = new UpgradePresenter();
        LoginOutputBoundary loginPresenter = new LoginPresenter();
        UserRegUIOutputBoundary userRegUIPresenter = new UserRegUIPresenter();
        BlockedUserOutputBoundary blockedUserPresenter = new BlockedUserPresenter();
        ReportedUserOutputBoundary reportedUserPresenter= new ReportedUserPresenter();
        BigPresenter presenters = new BigPresenter(userRegUIPresenter,
                loginPresenter, matchUIPresenter,
                emailConnPresenter,
                upgradePresenter,
                blockedUserPresenter,
                reportedUserPresenter);

        // Create controllers for all UI elements and store them in a big controller
        MatchManager matchManager = new MatchManager(presenters.getMatchUIPresenter(), users);
        MatchController matchController = new MatchController(matchManager);

        UpgradeManager upgradeManager = new UpgradeManager(users, presenters.getUpgradePresenter());
        UpgradeController upgradeController = new UpgradeController(upgradeManager);

        EmailConnInputBoundary interactor = new EmailConnInteractor(presenters.getEmailConnPresenter(),
                users);
        EmailConnController emailConnController = new EmailConnController(interactor);

        LoginInputBoundary loginInputBoundary = new LoginInteractor(users,loginPresenter);
        LoginController loginController = new LoginController(loginInputBoundary);

        UserRegUIInputBoundary userRegUIInteractor = new UserRegUIInteractor(userRegUIPresenter, users);
        UserRegUIController userRegUIController = new UserRegUIController(userRegUIInteractor);

        BlockedUserInteractor blockedUserInteractor = new BlockedUserInteractor(blockedUserPresenter, users );
        BlockedUserController blockedUserController = new BlockedUserController(blockedUserInteractor);

        ReportedUserInteractor reportedUserInteractor = new ReportedUserInteractor(reportedUserPresenter, users);
        ReportedUserController reportedUserController = new ReportedUserController(reportedUserInteractor);

        BigController controllers = new BigController(userRegUIController,
                loginController, matchController,
                emailConnController, upgradeController,
                blockedUserController, reportedUserController);

        // pass all controllers and presenters to our home page, and start running the program.
        LoginUI loginUI = new LoginUI(controllers,presenters);
        loginUI.setVisible(true);
    }
}
