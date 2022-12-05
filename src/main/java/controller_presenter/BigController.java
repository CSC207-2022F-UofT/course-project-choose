package controller_presenter;

import email_request.EmailConnController;
import login_management_system.LoginController;
import matching_system.MatchController;
import upgrade.UpgradeController;
import user_register_system.UserRegUIController;

/**
 * This class is a data structure for all controllers in ths program.
 */
public class BigController {

    UserRegUIController userRegUIController;
    LoginController loginController;
    MatchController matchController;
    EmailConnController emailConnController;
    UpgradeController upgradeController;

    public BigController(UserRegUIController userRegUIController,
                         LoginController loginController,
                         MatchController matchController,
                         EmailConnController emailConnController,
                         UpgradeController upgradeController){
        this.userRegUIController = userRegUIController;
        this.loginController = loginController;
        this.matchController = matchController;
        this.emailConnController = emailConnController;
        this.upgradeController = upgradeController;
    }

    public MatchController getMatchController(){
        return this.matchController;
    }

    public EmailConnController getEmailConnController(){
        return this.emailConnController;
    }

    public UpgradeController getUpgradeController(){
        return this.upgradeController;
    }

    public LoginController getLoginController(){return this.loginController;}

    public UserRegUIController getUserRegUIController(){return this.userRegUIController;}


}
