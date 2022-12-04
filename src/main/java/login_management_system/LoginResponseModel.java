package login_management_system;


import entities.User;

public class LoginResponseModel {

    final User user;
    boolean loginStatus;

    private String email;

    public LoginResponseModel(User user, String email) {
        this.user = user;
        this.email = email;
    }

    public User getUser() {
        return user;
    }
    public Boolean getLoginStatus(){return this.loginStatus;}
    public void setLoginStatus() {this.loginStatus = true; }

    public String getEmail(){
        return this.email;
    }

}
