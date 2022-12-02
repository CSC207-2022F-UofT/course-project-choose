package login_management_system;
public class LoginRequestModel {
    final String username;
    final String password;

    public LoginRequestModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getName() {
        return username;
    }

    String getPassword() {
        return password;
    }

}
