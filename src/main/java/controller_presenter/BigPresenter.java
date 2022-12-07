package controller_presenter;

import blocking_reporting_system.blocking_system.BlockedUserOutputBoundary;
import blocking_reporting_system.reporting_system.ReportedUserOutputBoundary;
import email_request.EmailConnOutputBoundary;
import login_management_system.LoginOutputBoundary;
import matching_system.MatchOutputBoundary;
import upgrade.UpgradeOutputBoundary;
import user_register_system.UserRegUIOutputBoundary;

/**
 * This class is a data structure for holding all presenters in this program.
 * It will be passed to our home page LoginUI as a parameter in order to navigate between UI elements.
 */
public class BigPresenter {

    // declare all presenters for this program.
    UserRegUIOutputBoundary userRegUIPresenter;
    MatchOutputBoundary matchUIPresenter;
    EmailConnOutputBoundary emailConnPresenter;
    UpgradeOutputBoundary upgradePresenter;
    LoginOutputBoundary loginPresenter;
    BlockedUserOutputBoundary blockedUserPresenter;
    ReportedUserOutputBoundary reportedUsePresenter;

    /**
     *
     * @param userRegUIPresenter presenter that contains the backend information for updating the view after
     *                           registration.
     * @param loginPresenter presenter that contains the backend information for updating the view after log-in
     * @param matchUIPresenter presenter that contains the backend information for updating the view after clicking
     *                         on "match" on HomePageUI.
     * @param emailConnPresenter presenter that contains the backend information for updating the view after clicking
     *                           "Request Email" on MatchUI results.
     * @param upgradePresenter presenter that contains the backend information for updating the view after clicking on
     *                         "upgrade"
     * @param blockedUserPresenter presenter that contains the backend information for updating the view after clicking
     *                             "Block this person" on MatchUI results.
     * @param reportedUsePresenter presenter that contains the backend information for updating the view after clicking
     *                             "Report his person" on MatchUI results.
     */
    public BigPresenter(UserRegUIOutputBoundary userRegUIPresenter,
            LoginOutputBoundary loginPresenter,
                        MatchOutputBoundary matchUIPresenter,
                        EmailConnOutputBoundary emailConnPresenter,
                        UpgradeOutputBoundary upgradePresenter,
                        BlockedUserOutputBoundary blockedUserPresenter,
                        ReportedUserOutputBoundary reportedUsePresenter){
        this.userRegUIPresenter = userRegUIPresenter;
        this.loginPresenter = loginPresenter;
        this.matchUIPresenter = matchUIPresenter;
        this.emailConnPresenter = emailConnPresenter;
        this.upgradePresenter = upgradePresenter;
        this.blockedUserPresenter = blockedUserPresenter;
        this.reportedUsePresenter = reportedUsePresenter;
    }

    /**
     * A getter method for matchUIPresenter.
     * @return presenter that contains the backend information for updating the view after clicking
     * "match" on HomePageUI
     */
    public MatchOutputBoundary getMatchUIPresenter(){
        return this.matchUIPresenter;
    }

    /**
     * A getter method for emailConnPresenter.
     * @return presenter that contains the backend information for updating the view after clicking
     * "Request Email" on MatchUI results.
     */
    public EmailConnOutputBoundary getEmailConnPresenter(){
        return this.emailConnPresenter;
    }

    /**
     * A getter method for upgradePresenter.
     * @return presenter that contains the backend information for updating the view after clicking on
     * "upgrade"
     */
    public UpgradeOutputBoundary getUpgradePresenter(){
        return this.upgradePresenter;
    }

    /**
     * A getter method for userRegUIPresenter.
     * @return presenter that contains the backend information for updating the view after
     * registration.
     */
    public UserRegUIOutputBoundary getUserRegUIPresenter(){return this.userRegUIPresenter;}

    /**
     * A getter method for blockedUserPresenter.
     * @return presenter that contains the backend information for updating the view after clicking
     * "Block this person" on MatchUI results.
     */
    public BlockedUserOutputBoundary getBlockedUserPresenter(){return this.blockedUserPresenter;}

    /**
     *  A getter method for reportedUsePresenter.
     * @return presenter that contains the backend information for updating the view after clicking
     * "Report his person" on MatchUI results.
     */
    public ReportedUserOutputBoundary getReportedUsePresenter(){return this.reportedUsePresenter;}
}
