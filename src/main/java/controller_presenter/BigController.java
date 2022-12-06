package controller_presenter;

import blocking_reporting_system.blocking_system.BlockedUserController;
import blocking_reporting_system.reporting_system.ReportedUserController;
import email_request.EmailConnController;
import login_management_system.LoginController;
import matching_system.MatchController;
import upgrade.UpgradeController;
import user_register_system.UserRegUIController;

/**
 * This class is a data structure for holding all controllers in this program.
 * It will be passed to our home page LoginUI as a parameter in order to navigate between UI elements.
 */
public class BigController {

    // declare all controllers in this program.
    UserRegUIController userRegUIController;
    LoginController loginController;
    MatchController matchController;
    EmailConnController emailConnController;
    UpgradeController upgradeController;
    BlockedUserController blockedUserController;
    ReportedUserController reportedUserController;

    /**
     * Create a big controller for holding all controllers in this program
     * @param userRegUIController controller that responses to clicking on the "register" button on Login UI.
     * @param loginController controller that responses to clicking on the "log-in" button on Login UI.
     * @param matchController controller that responses to clicking on the "match" button on HomePageUI.
     * @param emailConnController controller that responses to clicking on the "Email Request" button on MatchResultsUI.
     * @param upgradeController controller that responses to clicking on the "upgrade" button on upgradeUI.
     * @param blockedUserController controller that responses to clicking on the "Block this person" button
     *                              on MatchResultsUI.
     * @param reportedUserController controller that responses to clicking on the "Report this person"
     *                               button on MatchResultsUI.
     */
    public BigController(UserRegUIController userRegUIController,
                         LoginController loginController,
                         MatchController matchController,
                         EmailConnController emailConnController,
                         UpgradeController upgradeController,
                         BlockedUserController blockedUserController,
                         ReportedUserController reportedUserController){
        this.userRegUIController = userRegUIController;
        this.loginController = loginController;
        this.matchController = matchController;
        this.emailConnController = emailConnController;
        this.upgradeController = upgradeController;
        this.blockedUserController = blockedUserController;
        this.reportedUserController = reportedUserController;
    }

    /**
     * A getter method for the MatchController.
     * @return controller that responses to clicking on the "match" button on HomePageUI.
     */
    public MatchController getMatchController(){
        return this.matchController;
    }

    /**
     * A getter method for the EmailConnController.
     * @return controller that responses to clicking on the "Email Request" button on MatchResultsUI.
     */
    public EmailConnController getEmailConnController(){
        return this.emailConnController;
    }

    /**
     * A getter method for the UpgradeController.
     * @return controller that responses to clicking on the "upgrade" button on upgradeUI.
     */
    public UpgradeController getUpgradeController(){
        return this.upgradeController;
    }

    /**
     * A getter method for the LoginController.
     * @return controller that responses to clicking on the "log-in" button on Login UI.
     */
    public LoginController getLoginController(){return this.loginController;}

    /**
     * A getter method for the UserRegUIController.
     * @return controller that responses to clicking on the "register" button on Login UI.
     */
    public UserRegUIController getUserRegUIController(){return this.userRegUIController;}

    /**
     * A getter method for the BlockedUserController.
     * @return controller that responses to clicking on the "Block this person" button
     * on MatchResultsUI.
     */
    public BlockedUserController getBlockedUserController(){return this.blockedUserController;}

    /**
     * A getter method for the ReportedUserController.
     * @return controller that responses to clicking on the "Report this person" button
     * on MatchResultsUI.
     */
    public ReportedUserController getReportedUserController(){return this.reportedUserController;}


}
