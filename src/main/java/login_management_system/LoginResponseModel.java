package login_management_system;

/**
 * This class is Output Data. Presenter will use it to prepare View.
 * Use Case Layer
 */

import entities.User;

public class LoginResponseModel {

    /** User that login successfully */
    final User user;
    boolean loginStatus;

    private String email;

    public LoginResponseModel(User user, String email) {
        this.user = user;
        this.email = email;
    }

    /**
     * Return the user who logins successfully.
     * @return Return the user who logins successfully.
     */
    public User getUser() {
        return user;
    }

    /**
     * Return the user's login status.
     * @return Return true if the user logins successfully and false otherwise.
     */
    public Boolean getLoginStatus(){return this.loginStatus;}

    /**
     * Change the user's login status.
     */
    public void setLoginStatus() {this.loginStatus = true; }

    /**
     * Return the user's email.
     * @return Return the user's who logins successfully.
     */
    public String getEmail(){
        return this.email;
    }

}
