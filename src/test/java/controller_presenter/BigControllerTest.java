package controller_presenter;

import blocking_reporting_system.blocking_system.BlockedUserController;
import blocking_reporting_system.blocking_system.BlockedUserInteractor;
import blocking_reporting_system.blocking_system.BlockedUserOutputBoundary;
import blocking_reporting_system.blocking_system.BlockedUserPresenter;
import blocking_reporting_system.reporting_system.ReportedUserController;
import blocking_reporting_system.reporting_system.ReportedUserInteractor;
import blocking_reporting_system.reporting_system.ReportedUserOutputBoundary;
import blocking_reporting_system.reporting_system.ReportedUserPresenter;
import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import email_request.*;
import login_management_system.*;
import matching_system.MatchController;
import matching_system.MatchManager;
import matching_system.MatchOutputBoundary;
import matching_system.MatchUIPresenter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import upgrade.UpgradeController;
import upgrade.UpgradeManager;
import upgrade.UpgradeOutputBoundary;
import upgrade.UpgradePresenter;
import user_register_system.*;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class tests the methods in BigController.
 */
class BigControllerTest {

    /** The big controller for this test class. */
    private static BigController controllers;

    /** Set up the big controller of holding controllers in this program before running any tests. */
    @BeforeAll
    static void setUp(){

        // data access
        UserRepoManager users;
        try{
            File csvFile = new File("src/main/resources/emptyTestFile.csv");
            users = new UserRepo(csvFile);
        }catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }

        // Create presenters for creating controllers
        MatchOutputBoundary matchUIPresenter = new MatchUIPresenter();
        EmailConnOutputBoundary emailConnPresenter = new EmailConnPresenter();
        UpgradeOutputBoundary upgradePresenter = new UpgradePresenter();
        LoginOutputBoundary loginPresenter = new LoginPresenter();
        UserRegUIOutputBoundary userRegUIPresenter = new UserRegUIPresenter();
        BlockedUserOutputBoundary blockedUserPresenter = new BlockedUserPresenter();
        ReportedUserOutputBoundary reportedUserPresenter= new ReportedUserPresenter();

        // Create controllers for all UI elements and store them in a big controller
        MatchManager matchManager = new MatchManager(matchUIPresenter, users);
        MatchController matchController = new MatchController(matchManager);

        UpgradeManager upgradeManager = new UpgradeManager(users, upgradePresenter);
        UpgradeController upgradeController = new UpgradeController(upgradeManager);

        EmailConnInputBoundary interactor = new EmailConnInteractor(emailConnPresenter,
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

        controllers = new BigController(userRegUIController,
                loginController, matchController,
                emailConnController, upgradeController,
                blockedUserController, reportedUserController);
    }

    /**
     * Test to make sure an object of type MatchController is returned.
     */
    @Test
    void getMatchController() {
        assertNotNull(controllers.getMatchController());
    }

    /**
     * Test to make sure an object of type EmailConnController is returned.
     */
    @Test
    void getEmailConnController() {
        assertNotNull(controllers.getEmailConnController());
    }

    /**
     * Test to make sure an object of type UpgradeController is returned.
     */
    @Test
    void getUpgradeController() {
        assertNotNull(controllers.getUpgradeController());
    }

    /**
     * Test to make sure an object of type LoginController is returned.
     */
    @Test
    void getLoginController() {
        assertNotNull(controllers.getLoginController());
    }

    /**
     * Test to make sure an object of type UserRegUIController is returned.
     */
    @Test
    void getUserRegUIController() {
        assertNotNull(controllers.getUserRegUIController());
    }

    /**
     * Test to make sure an object of type BlockedUserController is returned.
     */
    @Test
    void getBlockedUserController() {
        assertNotNull(controllers.getBlockedUserController());
    }

    /**
     * Test to make sure an object of type ReportedUserController is returned.
     */
    @Test
    void getReportedUserController() {
        assertNotNull(controllers.getReportedUserController());
    }
}