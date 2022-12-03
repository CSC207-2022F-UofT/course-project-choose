package login_management_system;


import entities.User;

public class LoginResponseModel {

    final User user;
    boolean loginStatus;

    public LoginResponseModel(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    public Boolean getLoginStatus(){return this.loginStatus;}
    public void setLoginStatus() {this.loginStatus = true; }

}
