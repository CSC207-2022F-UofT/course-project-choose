package login_management_system;
public class LoginRequestModel {
    private String username;
    private String password;

    public LoginRequestModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getName() {
        return username;
    }

    void setName(String name) {
        this.username = name;
    }

    String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }

}