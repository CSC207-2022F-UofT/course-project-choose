package controller_presenter;

import email_request.EmailConnOutputBoundary;
import login_management_system.LoginOutputBoundary;
import matching_system.MatchOutputBoundary;
import upgrade.UpgradeOutputBoundary;

/**
 * This class is a data structure for all output boundaries in ths program.
 */
public class BigPresenter {
    MatchOutputBoundary matchUIPresenter;
    EmailConnOutputBoundary emailConnPresenter;
    UpgradeOutputBoundary upgradePresenter;

    LoginOutputBoundary loginPresenter;

    public BigPresenter(LoginOutputBoundary loginPresenter,
                        MatchOutputBoundary matchUIPresenter,
                        EmailConnOutputBoundary emailConnPresenter,
                        UpgradeOutputBoundary upgradePresenter){
        this.loginPresenter = loginPresenter;
        this.matchUIPresenter = matchUIPresenter;
        this.emailConnPresenter = emailConnPresenter;
        this.upgradePresenter = upgradePresenter;
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

}
