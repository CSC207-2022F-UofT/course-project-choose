package login_management_system;

/**
 * This class contains raw data that LoginInteractor needs to do its job.
 * It's created, passed in, unpacked by the interactor and discarded.
 * Layer: Use Case Layer
 */
public class LoginRequestModel {

    /** User's input email. */
    final String email;

    /** User's input password. */
    final String password;

    public LoginRequestModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Return the email address of the user who tries to log in.
     * @return Return the email address of the user who tries to log in.
     */
    String getName() {
        return email;
    }

    /**
     * Return the password of the user who tries to log in.
     * @return Return the password of the user who tries to log in.
     */
    String getPassword() {
        return password;
    }

}
