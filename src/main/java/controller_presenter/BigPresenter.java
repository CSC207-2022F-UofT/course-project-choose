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
     * @param userRegUIPresenter
     * @param loginPresenter
     * @param matchUIPresenter
     * @param emailConnPresenter
     * @param upgradePresenter
     * @param blockedUserPresenter
     * @param reportedUsePresenter
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

    public MatchOutputBoundary getMatchUIPresenter(){
        return this.matchUIPresenter;
    }

    public EmailConnOutputBoundary getEmailConnPresenter(){
        return this.emailConnPresenter;
    }

    public UpgradeOutputBoundary getUpgradePresenter(){
        return this.upgradePresenter;
    }

    public UserRegUIOutputBoundary getUserRegUIPresenter(){return this.userRegUIPresenter;}

    public BlockedUserOutputBoundary getBlockedUserPresenter(){return this.blockedUserPresenter;}

    public ReportedUserOutputBoundary getReportedUsePresenter(){return this.reportedUsePresenter;}

}
