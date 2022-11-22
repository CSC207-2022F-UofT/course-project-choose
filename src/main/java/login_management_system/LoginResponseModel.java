package login_management_system;
public class LoginResponseModel {

    String username;
    Boolean loginStatus;

    public LoginResponseModel(String email) {
        this.username = email;
    }

    public Boolean getLoginStatus(){return this.loginStatus;}

    public void setLoginStatus() {this.loginStatus = true; }

}